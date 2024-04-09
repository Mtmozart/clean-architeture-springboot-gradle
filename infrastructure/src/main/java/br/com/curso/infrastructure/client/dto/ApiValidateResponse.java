package br.com.curso.infrastructure.client.dto;

public record ApiValidateResponse(
        Boolean success,
        String message
) {
}
