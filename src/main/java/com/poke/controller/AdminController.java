package com.poke.controller;

import com.poke.domain.Admin;
import com.poke.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admin/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var admins = adminService.getAdmins();
        model.addAttribute("admins", admins);
        model.addAttribute("totalAdmins", admins.size());

        return "/admin/listado";
    }

    @GetMapping("/nuevo")
    public String adminNuevo(Admin admin) {

        return "/admin/modifica";
    }

    @PostMapping("/guardar")
    public String adminGuardar(Admin admin) {
        adminService.save(admin);
        return "redirect:/admin/admin/listado";
    }

    @GetMapping("/eliminar/{idAdmin}")
    public String adminEliminar(Admin admin) {
        adminService.delete(admin);
        return "redirect:/admin/admin/listado ";
    }

    @GetMapping("/modificar/{idAdmin}")
    public String adminModificar(Admin admin, Model model) {
        admin = adminService.getAdmin(admin);
        model.addAttribute("admin", admin);
        return "/admin/modifica";
    }
}
