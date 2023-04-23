package com.poke.dao;

import com.poke.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Long>{
    
    
}