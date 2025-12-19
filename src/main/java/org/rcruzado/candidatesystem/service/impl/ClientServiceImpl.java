package org.rcruzado.candidatesystem.service.impl;

import org.rcruzado.candidatesystem.dto.ClientMetricsResponse;
import org.rcruzado.candidatesystem.dto.ClientResponse;
import org.rcruzado.candidatesystem.dto.CreateClientRequest;
import org.rcruzado.candidatesystem.entity.Client;
import lombok.RequiredArgsConstructor;
import org.rcruzado.candidatesystem.exception.BusinessException;
import org.rcruzado.candidatesystem.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import org.rcruzado.candidatesystem.repository.ClientRepository;
import org.rcruzado.candidatesystem.service.ClientService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    /**
     * Crea un nuevo cliente
     */
    @Override
    public ClientResponse create(CreateClientRequest request) {

        // Validación de negocio
        if (repository.existsByNameAndLastName(
                request.name(),
                request.lastName()
        )) {
            throw new BusinessException("El cliente ya existe");
        }

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

    /**
     * Lista todos los clientes
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClientResponse> findAll() {
        //return List.of();
        return repository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(ClientMapper::toResponse)
                .toList();
    }

    /**
     * Devuelve métricas de clientes
     */
    @Override
    @Transactional(readOnly = true)
    public ClientMetricsResponse getMetrics() {

        List<Integer> ages = repository.findAllAges();

        long totalClients = ages.size();

        if (ages.isEmpty()) {
            return new ClientMetricsResponse(0, 0, 0);
        }

        double average = ages.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        double variance = ages.stream()
                .mapToDouble(age -> Math.pow(age - average, 2))
                .average()
                .orElse(0);

        double standardDeviation = Math.sqrt(variance);

        return new ClientMetricsResponse(totalClients, average, standardDeviation);

    }
}
