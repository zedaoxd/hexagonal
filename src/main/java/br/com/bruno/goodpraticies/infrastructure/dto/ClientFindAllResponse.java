package br.com.bruno.goodpraticies.infrastructure.dto;

import java.util.UUID;

public record ClientFindAllResponse(
        UUID id,
        String name,
        String email
) {
}
