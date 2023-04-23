package com.poke.dao;

import com.poke.domain.Credito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoDao extends CrudRepository<Credito, Long>{

    public CreditoDao save(CreditoDao credito);
    
    
}