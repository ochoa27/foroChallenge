package com.desafio.foro.controller;

import com.desafio.foro.domain.dto.curso.DatosRegistroCurso;
import com.desafio.foro.domain.model.Curso;
import com.desafio.foro.domain.repository.ICursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ICursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registroCurso(@RequestBody @Valid DatosRegistroCurso datos){
        var curso=new Curso(datos);
        repository.save(curso);
        return ResponseEntity.ok(curso);
    }
}
