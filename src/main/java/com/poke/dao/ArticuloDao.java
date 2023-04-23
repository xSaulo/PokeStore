package com.poke.dao;

import com.poke.domain.Articulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
    
}