package com.poke.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="articulo")

public class Articulo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idArticulo;
    
    
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias ;
    private String imagen;
    private double activo;
    
    @JoinColumn(name="id categoria", referencedColumnName="id_categoria ")
    @ManyToOne
    private Credito credito;
    
    public Articulo(){
        
    }

    public Articulo(String descripcion, String detalle, double precio, int existencias, String imagen, double activo, Credito credito) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        this.credito = credito;
    }



    
}
