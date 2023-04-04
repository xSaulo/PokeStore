package com.poke.controller;

import com.poke_dom.Cliente;
import com.poke_serv.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        var totalCredito=0;
        for(Cliente c: clientes){
            totalCredito+=c.getCredito().getLimite();
        }
        model.addAttribute("totalCredito", totalCredito);
        
        return "/cliente/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Model model, Cliente cliente) {
        return "/cliente/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Model model, Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }
}
