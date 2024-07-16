package com.desafio.foro.domain.dto.topico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
         String titulo,
         @NotBlank
         String mensaje,
         @NotNull
         Long idUsuario,
         @NotNull
         Long idCurso) {
}
