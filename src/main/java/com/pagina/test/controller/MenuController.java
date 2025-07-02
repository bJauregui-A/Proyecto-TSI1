package com.pagina.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menu() {
        return "menu"; // Renderiza templates/menu.html
    }

    @PostMapping("/procesar")
    @ResponseBody
    public String procesarFormulario(HttpServletRequest request) {
        String dato = request.getParameter("campoEjemplo");
        return "Formulario procesado con: " + dato;
    }
}
