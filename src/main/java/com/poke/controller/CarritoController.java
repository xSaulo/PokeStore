package com.poke.controller;

import com.poke.domain.Articulo;
import com.poke.domain.Cliente;
import com.poke.domain.Item;
import com.poke.service.ItemService;
import com.poke.service.impl.ArticuloService;
import com.poke.service.impl.ClienteService;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class CarritoController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private ClienteService clienteService;

//    @Autowired
//    private HttpSession session;
    //VER
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }

    //AGREGAR
    @GetMapping("/carrito/agregar/{idArticulo}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);
        if (item2 == null) {
            Articulo articulo = articuloService.getArticulo(item);
            item2 = new Item(articulo);
        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }

    //MODIFICAR
    @GetMapping("/carrito/modificar/{idArticulo}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    //ELIMINAR
    @GetMapping("/carrito/eliminar/{idArticulo}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    //ACTUALIZAR
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    //FACTURAR
    @GetMapping("/facturar/carrito")
    public String facturarCarrito(HttpSession session, Model model, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        var items = itemService.gets();
        var itemsCopia = itemService.gets();
        model.addAttribute("items", itemsCopia);

        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);

        Cliente clienteEncontrado = null;
        String b = "";

        if (authentication != null && authentication.isAuthenticated()) {
            String correoElectronico = ((UserDetails) authentication.getPrincipal()).getUsername();
            System.out.println("Correo electrónico: " + correoElectronico);

            var clientes = clienteService.getClientes();

            for (Cliente i : clientes) {
                System.out.println(i.getNombre());
                if (correoElectronico.equals(i.getNombre())) {
                    System.out.println("ENCONTRADO");
                    clienteEncontrado = i;
                    b = clienteEncontrado.getCorreo();

                    Cliente nCliente = clienteService.getCliente(i);
                    double credito = (nCliente.getCredito().getLimite());

                    double total = (credito - carritoTotalVenta);

                    nCliente.getCredito().setLimite(total);

                    clienteService.save(nCliente);

//                    ItemService.listaItems.clear(); // Borra la lista original
                    break;
                }
            }

        }

        return "/carrito/fragmentosFactura";
    }

    @GetMapping("/carrito/fragmentosFactura")
    public String factura() {
        ItemService.listaItems.clear();
        return "/carrito/fragmentosFactura";
    }
}
