package com.poke.controller;

import com.poke.domain.Cliente;
import com.poke.service.IClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/registro/cliente")
public class UsuarioController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        var totalCredito = 0;
        for (Cliente c : clientes) {
            totalCredito += c.getCredito().getLimite();

        }
        model.addAttribute("totalCredito", totalCredito);
        return "/registro/registro";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {

        return "/registro/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        // Encriptamos la contraseña
        String passwordEncrypted = passwordEncoder.encode(cliente.getContra());
        cliente.setContra(passwordEncrypted);

        // Guardamos el cliente en la base de datos
        clienteService.save(cliente);

        return "redirect:/registro/cliente/registro";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/registro/cliente/registro ";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/registro/modifica";
    }
}
