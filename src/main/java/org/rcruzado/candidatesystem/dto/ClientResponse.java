package dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ClientResponse(
    @NotBlank
    String name,
    @NotBlank String lastName,
    @Min(0) Integer age,
    @NotNull
    LocalDate birthDate,
    @NotNull
    LocalDate estimatedLifeEventDate
) {}
