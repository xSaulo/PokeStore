package com.poke.controller;

import com.poke.domain.Comentario;
import com.poke.service.IComentarioService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    //Comentarios
    @GetMapping("/foro")
    public String comentarios(Model model) {
        List<Comentario> listaComentarios = comentarioService.getAllComentarios();
        model.addAttribute("comentarios", listaComentarios);
        return "comentarios";
    }

    @GetMapping("/crearForo")
    public String crearComentario(Model model) {
        model.addAttribute("comentario", new Comentario());
        return "crearComentario";
    }

    @PostMapping("/guardarComentario")
    public String guardarComentario(@ModelAttribute Comentario comentario) {
        comentario.setCalificacionComentario(comentario.getCalificacionComentario());
        //
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fecha.format(formatter);
        comentario.setFechaComentario(fechaFormateada);
        //
        comentarioService.saveComentario(comentario);
        return "redirect:/foro";
    }

    @GetMapping("/eliminarComentario/{idComentario}")
    public String eliminarComentario(@PathVariable("idComentario") Long idComentario) {
        comentarioService.delete(idComentario);
        return "redirect:/foro";
    }

    @GetMapping("/editarComentario/{idComentario}")
    public String editarComentario(@PathVariable("idComentario") Long idComentario, Model model) {
        Comentario comentario = comentarioService.getComentarioByID(idComentario);
        model.addAttribute("comentario", comentario);
        return "crearComentario";
    }

}
