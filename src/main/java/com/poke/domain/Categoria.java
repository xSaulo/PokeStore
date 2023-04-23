package com.poke.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "categoria")

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private boolean activo;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Articulo> articulos;

    public Categoria() {

    }

    public Categoria(Long idCategoria, String descripcion, boolean activo, List<Articulo> articulos) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.activo = activo;
        this.articulos = articulos;
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
