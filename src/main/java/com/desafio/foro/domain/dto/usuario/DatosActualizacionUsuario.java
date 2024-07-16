package com.desafio.foro.domain.dto.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionUsuario(
        @NotNull
        Long id,
        String name,
        String lastName,
        String email,
        String tel
) {
}
