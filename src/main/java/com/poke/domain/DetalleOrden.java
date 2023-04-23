package com.poke.domain;

import java.io.Serializable;
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
@Table(name = "Detalles_Orden")
public class DetalleOrden implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_Detalle")
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_Orden")
    private Orden orden;

    @JoinColumn(name = "precio")
    private Double precio;

    public DetalleOrden(Long idDetalle, Orden orden, Double precio) {
        this.idDetalle = idDetalle;
        this.orden = orden;
        this.precio = precio;
    }
    
}
