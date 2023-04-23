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
@Table(name="credito")

public class Credito implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito")
    private Long idCredito;
    private double limite;
    
    @OneToMany(mappedBy = "credito", cascade = CascadeType.ALL)
    private List<Cliente> clientes;
    
    
    public Credito(){
        
    }

    public Credito(double limite) {
        this.limite = limite;
    }


    
}
