package com.poke.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")

public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Cliente")
    private Long idCliente;
    
    
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    
    @JoinColumn(name="id credito", referencedColumnName="id_credito ")
    @ManyToOne
    private Credito credito;
    
    public Cliente(){
        
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }


}
