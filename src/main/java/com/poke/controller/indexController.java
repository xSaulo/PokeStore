package com.poke.controller;

import com.poke_serv.ArticuloService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class indexController {

    @Autowired
    private Object articulos;
    @GetMapping("/inicio")
    public String inicio(Model model) {
        return "index";
    }
}
