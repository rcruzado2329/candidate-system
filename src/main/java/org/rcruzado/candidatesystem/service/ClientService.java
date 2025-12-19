package org.rcruzado.candidatesystem.service;

import org.rcruzado.candidatesystem.dto.ClientMetricsResponse;
import org.rcruzado.candidatesystem.dto.ClientResponse;
import org.rcruzado.candidatesystem.dto.CreateClientRequest;

import java.util.List;

public interface ClientService {
    ClientResponse create(CreateClientRequest request);
    List<ClientResponse> findAll();
    ClientMetricsResponse getMetrics();
}
