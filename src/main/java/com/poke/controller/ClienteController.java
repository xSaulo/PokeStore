package com.poke.controller;

import com.poke.domain.Cliente;
import com.poke.service.IClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admin/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        var totalCredito = 0;
        for (Cliente c : clientes) {
            totalCredito += c.getCredito().getLimite();

        }
        model.addAttribute("totalCredito", totalCredito);
        return "/cliente/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {

        return "/cliente/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/admin/cliente/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/admin/cliente/listado ";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }
}
