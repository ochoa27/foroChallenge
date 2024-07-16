package com.desafio.foro.domain.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosRegistroUsuario(
         
        @NotBlank
         String name,
         @NotBlank
         String lastname,
         @NotBlank
                 @Email
         String email,
         
         @NotBlank
                 @Size(min = 0, max = 15)
         String tel) {
}
