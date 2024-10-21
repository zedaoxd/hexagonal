package br.com.bruno.goodpraticies.infrastructure.dto;

public record ClientUpdateRequest(
        String name,
        String email
) {
}
