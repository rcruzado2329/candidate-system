package org.rcruzado.candidatesystem.metrics;


import org.rcruzado.candidatesystem.entity.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientMetricsCalculator {

    public double averageAge(List<Client> clients) {
        return clients.stream()
                .mapToInt(Client::getAge)
                .average()
                .orElse(0);
    }

    public double standardDeviation(List<Client> clients) {
        double avg = averageAge(clients);
        return Math.sqrt(
                clients.stream()
                        .mapToDouble(c -> Math.pow(c.getAge() - avg, 2))
                        .average()
                        .orElse(0)
        );
    }

}
