package com.poke.dao;

import com.poke.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
    Cliente findByCorreo(String correo);
    Cliente findByNombre(String nombre);

    
}