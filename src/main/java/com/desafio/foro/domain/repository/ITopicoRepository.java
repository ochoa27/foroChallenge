package com.desafio.foro.domain.repository;

import com.desafio.foro.domain.model.Topico;
import com.desafio.foro.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicoRepository extends JpaRepository<Topico,Long> {

//    Page<Topico> findAllByStatusAbierta(Pageable paginacion);

}
