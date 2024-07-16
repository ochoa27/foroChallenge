package com.desafio.foro.domain.repository;


import com.desafio.foro.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {


    Page<Usuario> findAllByActivoTrue(Pageable paginacion);
}
