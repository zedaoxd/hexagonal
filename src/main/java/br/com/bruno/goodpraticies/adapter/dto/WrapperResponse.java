package br.com.bruno.goodpraticies.adapter.dto;

import lombok.Builder;

@Builder
public record WrapperResponse<T>(
        T data,
        String message,
        Integer status
) {
}
