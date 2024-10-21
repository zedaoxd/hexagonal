package br.com.bruno.goodpraticies.infrastructure.dto;

import java.util.UUID;

public record ClientUpdateResponse(
        UUID id,
        String name,
        String email
) {
}
