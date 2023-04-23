package com.poke.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Admins")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Admin")
    private Long idAdmin;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "rol")
    private Integer rol;

    public Admin() {

    }

    public Admin(String usuario, String contrasena, int rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}
