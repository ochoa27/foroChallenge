package com.desafio.foro.domain.repository;

import com.desafio.foro.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso,Long> {
}
