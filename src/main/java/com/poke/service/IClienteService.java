package com.poke.service;

import com.poke.domain.Cliente;
import java.util.List;

public interface IClienteService {

    List<Cliente> getClientes();

    Cliente getCliente(Cliente cliente);

    void save(Cliente cliente);

    void delete(Cliente cliente);
    
    Cliente findByCorreo(String username);

}
