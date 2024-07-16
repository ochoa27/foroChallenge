package com.desafio.foro.controller;

import com.desafio.foro.domain.dto.topico.DatosRegistroTopico;
import com.desafio.foro.domain.dto.topico.DatosTopico;
import com.desafio.foro.domain.dto.usuario.DatosUsuario;
import com.desafio.foro.domain.model.Topico;
import com.desafio.foro.domain.repository.ITopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private ITopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity creacionTopico(@RequestBody @Valid DatosRegistroTopico datos){
        var topico=new Topico(datos);
        repository.save(topico);
        return  ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopico>> listadoTopicos(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacion){
        var page = repository.findAll(paginacion).map(DatosTopico::new);
        return ResponseEntity.ok(page);
    }

}
