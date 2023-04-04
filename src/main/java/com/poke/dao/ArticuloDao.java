package com.poke.dao;

import com.poke_dom.Articulo;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
    
}