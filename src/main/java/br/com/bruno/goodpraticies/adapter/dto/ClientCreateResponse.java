package br.com.bruno.goodpraticies.adapter.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClientCreateResponse(
        UUID id,
        String name,
        String email
) {
}
