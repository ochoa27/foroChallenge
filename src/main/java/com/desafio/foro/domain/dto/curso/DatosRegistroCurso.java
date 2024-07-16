package com.desafio.foro.domain.dto.curso;

import com.desafio.foro.domain.util.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank
         String nombreCurso,
         @NotNull
         Categoria categoria) {
}
