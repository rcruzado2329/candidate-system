package org.rcruzado.candidatesystem.config;

import lombok.RequiredArgsConstructor;
import org.rcruzado.candidatesystem.security.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Deshabilitar CSRF (API REST stateless)
                .csrf(AbstractHttpConfigurer::disable)

                // Autorización de endpoints
                .authorizeHttpRequests(auth -> auth
                        // Swagger y Actuator públicos
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/actuator/health",
                                "/api/v1/auth/**"
                        ).permitAll().anyRequest().authenticated()

                        // Endpoints de clientes requieren autenticación
                        //.requestMatchers(HttpMethod.POST, "/api/v1/clients/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.GET, "/api/v1/clients/**").hasAnyRole("ADMIN", "USER")

                        // Cualquier otra petición
                        //**.anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;

                // Autenticación básica (fácil de probar)
                //**.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }

}
