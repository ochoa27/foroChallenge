package com.desafio.foro.domain.dto.topico;

import com.desafio.foro.domain.model.Curso;
import com.desafio.foro.domain.model.Topico;
import com.desafio.foro.domain.model.Usuario;

import java.time.LocalDateTime;

public record DatosTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status){
//        String usuarioName,
//        String cursoName) {

    public DatosTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus());// usuario.getName(),curso.getNombreCurso());
    }


}
