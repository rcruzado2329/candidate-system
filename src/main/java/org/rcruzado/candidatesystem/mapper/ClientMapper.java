package mapper;

import dto.ClientResponse;
import entity.Client;

public class ClientMapper {

    private static final int LIFE_EXPECTANCY_YEARS = 75;

    private ClientMapper() {
        // Evita instanciación
    }

    public static ClientResponse toResponse(Client client) {
        if (client == null) {
            return null;
        }

        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .lastName(client.getLastName())
                .age(client.getAge())
                .birthDate(client.getBirthDate())
                .estimatedLifeEventDate(calculateEstimatedLifeEvent(client.getBirthDate()))
                .build();
    }

    private static LocalDate calculateEstimatedLifeEvent(LocalDate birthDate) {
        return birthDate.plusYears(LIFE_EXPECTANCY_YEARS);
    }
}
