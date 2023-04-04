package com.poke.service.impl;

import com.poke_dom.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getClientes();
    
    Cliente getCliente(Cliente cliente);
    
    void save(Cliente cliente);
    
    void delete(Cliente cliente);
    
    
}
