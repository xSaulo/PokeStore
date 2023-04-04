package com.poke.dao;

import com.poke_dom.Credito;
import org.springframework.data.repository.CrudRepository;


public interface CreditoDao extends CrudRepository<Credito, Long>{

    public CreditoDao save(CreditoDao credito);
    
    
}