package org.rcruzado.candidatesystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateClientRequest (

    @NotBlank String name,
    @NotBlank String lastName,
    @Min(0) Integer age,
    @NotNull LocalDate birthDate
) {}
