package service;

import dto.ClientMetricsResponse;
import dto.ClientResponse;
import dto.CreateClientRequest;

import java.util.List;

public interface ClientService {
    ClientResponse create(CreateClientRequest request);
    List<ClientResponse> findAll();
    ClientMetricsResponse getMetrics();
}
