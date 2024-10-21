package br.com.bruno.goodpraticies.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientCreateRequest(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email
) {
}
