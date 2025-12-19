package org.rcruzado.candidatesystem.dto;

public record ClientMetricsResponse(
        long totalClients,
        double averageAge,
        double ageStandardDeviation
) {}
