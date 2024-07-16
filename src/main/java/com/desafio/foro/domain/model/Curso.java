package com.desafio.foro.domain.model;


import com.desafio.foro.domain.dto.curso.DatosRegistroCurso;
import com.desafio.foro.domain.util.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="cursos")
@Entity(name= "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCurso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosRegistroCurso datosRegistroCategoria) {
        this.nombreCurso = datosRegistroCategoria.nombreCurso();
        this.categoria = datosRegistroCategoria.categoria();
    }



    public Long getId() {
        return id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
