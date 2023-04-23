package com.poke.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "cliente")

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cliente")
    private Long idCliente;

    private String nombre;
    private String apellidos;
    private String correo;
    private String contra;
    private Integer telefono;
    private int activo;
    private String rol;

    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito ")
    @ManyToOne
    private Credito credito;

    public Cliente() {

    }

    public Cliente(String nombre, String apellidos, String correo, Integer telefono, Credito credito, String contra, int activo, String rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
        this.contra = contra;
        this.activo = activo;
        this.rol = rol;
    }

    public List<String> getRoleList() {
        if (this.rol.length() > 0) {
            return Arrays.asList(this.rol.split(","));
        }
        return new ArrayList<>();
    }

}
