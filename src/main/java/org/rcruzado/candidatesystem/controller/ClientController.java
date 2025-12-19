package controller;


import dto.ClientMetricsResponse;
import dto.ClientResponse;
import dto.CreateClientRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
@Tag(name = "Clients API")
public class ClientController {

    private final ClientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@Valid @RequestBody CreateClientRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ClientResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/metrics")
    public ClientMetricsResponse metrics() {
        return service.getMetrics();
    }

}
