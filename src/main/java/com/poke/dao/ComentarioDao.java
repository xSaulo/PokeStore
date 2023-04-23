package com.poke.dao;

import com.poke.domain.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioDao extends CrudRepository<Comentario, Long>{
    
}
