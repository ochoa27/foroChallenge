package com.desafio.foro.controller;

import com.desafio.foro.domain.dto.usuario.DatosActualizacionUsuario;
import com.desafio.foro.domain.dto.usuario.DatosRegistroUsuario;
import com.desafio.foro.domain.dto.usuario.DatosUsuario;
import com.desafio.foro.domain.model.Usuario;
import com.desafio.foro.domain.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        var usuario =new Usuario(datosRegistroUsuario);
        repository.save(usuario);
        return  ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosUsuario>> listarPacientes(@PageableDefault (size = 10, sort = {"name"}) Pageable paginacion){
        var page= repository.findAllByActivoTrue(paginacion).map(DatosUsuario::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/deletedefinitly/{id}")
    @Transactional
    public  ResponseEntity eliminarUsuario(@PathVariable Long id){
        Usuario usuario= repository.getReferenceById(id);
        DatosUsuario datosUsuario=new DatosUsuario(usuario.getId(), usuario.getName(), usuario.getLastname(), usuario.getEmail(), usuario.getTel());
        repository.delete(usuario);
        return ResponseEntity.ok("el usuario se ha eliminado permanentemente "+datosUsuario);
    }

    @DeleteMapping("/deletenormal/{id}")
    @Transactional
    public ResponseEntity desactivarUsuario(@PathVariable Long id){
        Usuario usuario= repository.getReferenceById(id);
        DatosUsuario datosUsuario=new DatosUsuario(usuario.getId(), usuario.getName(), usuario.getLastname(), usuario.getEmail(), usuario.getTel());
        usuario.desactivarUsuario();
        return ResponseEntity.ok("el usuario se ha desactivado: "+datosUsuario);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizacionUsuario datos){
        var usuario=repository.getReferenceById(datos.id());
        usuario.actualizarInformacionUsuario(datos);
        return ResponseEntity.ok("el usuario se ha actualizado: " +new DatosUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerById(@PathVariable Long id){
        var usuario=repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosUsuario(usuario));
    }


}
