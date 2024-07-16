package com.desafio.foro.domain.model;

import com.desafio.foro.domain.dto.usuario.DatosActualizacionUsuario;
import com.desafio.foro.domain.dto.usuario.DatosRegistroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="usuarios")
@Entity(name= "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String tel;
    private Boolean activo;


    public Usuario(DatosRegistroUsuario datos) {
        this.name = datos.name();
        this.lastname = datos.lastname();
        this.email = datos.email();
        this.tel = datos.tel();
        this.activo=true;
    }



    public void desactivarUsuario() {
        this.activo=false;
    }

    public void actualizarInformacionUsuario(DatosActualizacionUsuario datos) {
        if (datos.name()!=null){
            this.name= datos.name();
        }
        if (datos.lastName()!=null){
            this.lastname= datos.lastName();
        }
        if (datos.email()!=null){
            this.email= datos.email();
        }
        if (datos.tel()!=null){
            this.tel= datos.tel();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public Boolean getActivo() {
        return activo;
    }
}
