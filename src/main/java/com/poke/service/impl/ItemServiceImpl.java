package com.poke.service.impl;

import com.poke.dao.ClienteDao;
import com.poke.dao.CreditoDao;
import com.poke.domain.Cliente;
import com.poke.domain.Credito;
import com.poke.domain.Item;
import com.poke.service.ItemService;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private CreditoDao creditoDao;

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item i : listaItems) {
            //Busca si ya existe el articulo en el carrito
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                //Valida si aún puede colocar un item adicional -segun existencias-
                if (i.getCantidad() < item.getExistencias()) {
                    //Incrementa en 1 la cantidad de elementos
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {//Si no está el articulo en el carrito se agrega cantidad =1.            
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    //Se usa para eliminar un articulo del carrito
    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item i : listaItems) {
            ++posicion;
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    //Se obtiene la información de un articulo del carrito... para modificarlo
    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                return i;
            }
        }
        return null;
    }

    //Se usa en la página para actualizar la cantidad de articulos
    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    /*En un futuro sería el proceso de generar la facturación...
    por ahora sólo borra los elementos del carrito */
    @Override
    public void facturar(Double total, HttpSession session) {
        //Cliente cliente = (Cliente) session.getAttribute("cliente");
//        String username = authentication.getName();

        //System.out.println(cliente.getIdCliente());

//        Credito credito = cliente.getCredito();
//        
//        credito.setLimite(total);
//        credito = creditoDao.save(credito);
//        cliente.setCredito(credito);
//        clienteDao.save(cliente);
        //cliente.getCredito().setLimite(cTotal);
        listaItems.clear();
    }
}
