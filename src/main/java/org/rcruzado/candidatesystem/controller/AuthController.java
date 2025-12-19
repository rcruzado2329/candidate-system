package org.rcruzado.candidatesystem.controller;

import lombok.RequiredArgsConstructor;
import org.rcruzado.candidatesystem.dto.ApiErrorResponse;
import org.rcruzado.candidatesystem.dto.AuthRequest;
import org.rcruzado.candidatesystem.dto.AuthResponse;
import org.rcruzado.candidatesystem.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password()
                    )
            );

            UserDetails user = (UserDetails) authentication.getPrincipal();
            //return new AuthResponse(jwtUtil.generateToken(user));

            String token = jwtUtil.generateToken(user);

            return ResponseEntity.ok(new AuthResponse(token));

        } catch (HttpClientErrorException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiErrorResponse(
                            400,
                            "Sintaxis o formato de solicitud inválidos",
                            java.time.LocalDateTime.now()
                    ));
        } catch (BadCredentialsException ex) {
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new ApiErrorResponse(
                            422,
                            "Usuario o contraseña inválidos",
                            java.time.LocalDateTime.now()
                    ));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiErrorResponse(
                            500,
                            "Error interno del servidor. Intente nuevamente.",
                            LocalDateTime.now()
                    ));
        }

    }

}
