
package com.poke.service;


import com.poke.domain.Cliente;
import com.poke.domain.Item;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;

public interface ItemService {     
    List<Item> listaItems = new ArrayList<>();
    
    public List<Item> gets();
    
    public Item get(Item item);
    
    public void delete(Item item);

    public void save(Item item);
    
    public void actualiza(Item item);
    
    public void facturar(Double total, HttpSession session);
}