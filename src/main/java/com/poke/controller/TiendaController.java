package com.poke.controller;

import com.poke.domain.Articulo;
import com.poke.service.IArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class TiendaController {

    @Autowired
    private IArticuloService articuloService;

    //Productos
    @GetMapping("/tienda")
    public String productos(Model model) {
        List<Articulo> listaProducto = articuloService.getArticulos(true);
        model.addAttribute("productos", listaProducto);
        return "tienda";
    }

    @GetMapping("/tienda/producto/{articulo}")
    public String producto(@PathVariable Articulo articulo, Model model) {
        Articulo articuloNuevo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articuloNuevo);
        return "producto";
    }

}
