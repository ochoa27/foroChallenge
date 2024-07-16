package com.desafio.foro.domain.dto.usuario;

import com.desafio.foro.domain.model.Topico;
import com.desafio.foro.domain.model.Usuario;

public record DatosUsuario(

         Long id,
         String name,
         String lastname,
         String email,
         String tel) {

    public DatosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getName(), usuario.getLastname(), usuario.getEmail(), usuario.getTel());
    }



}
