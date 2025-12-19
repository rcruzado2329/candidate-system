package service.impl;

import dto.ClientMetricsResponse;
import dto.ClientResponse;
import dto.CreateClientRequest;
import entity.Client;
import lombok.RequiredArgsConstructor;
import mapper.ClientMapper;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public ClientResponse create(CreateClientRequest request) {
        Client client = Client.builder()
                .name(request.name())
                .lastName(request.lastName())
                .age(request.age())
                .birthDate(request.birthDate())
                .createdAt(LocalDate.now())
                .build();

        repository.save(client);
        return ClientMapper.toResponse(client);
    }

    @Override
    public List<ClientResponse> findAll() {
        return List.of();
    }

    @Override
    public ClientMetricsResponse getMetrics() {
        return null;
    }
}
