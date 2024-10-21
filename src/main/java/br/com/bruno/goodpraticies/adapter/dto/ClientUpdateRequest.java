package br.com.bruno.goodpraticies.adapter.dto;

public record ClientUpdateRequest(
        String name,
        String email
) {
}
