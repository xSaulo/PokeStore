package com.poke.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "Ordenes")
public class Orden implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Orden")
    private Long idOrden;
    
    @Column(name = "total")
    private Double total;

    @ManyToOne
    //name = nombre de la tabla en la base de datos
    //referencedColumnName = nombre de la columna REFERENCIA
    @JoinColumn(name="id_cliente", referencedColumnName = "id_Cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<DetalleOrden> detalleOC; 

    public Orden(Long idOrden, Double total, Cliente cliente, List<DetalleOrden> detalleOC) {
        this.idOrden = idOrden;
        this.total = total;
        this.cliente = cliente;
        this.detalleOC = detalleOC;
    }
    
    
}
