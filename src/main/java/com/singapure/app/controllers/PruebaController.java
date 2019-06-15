package com.singapure.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Prueba;

@RestController
public class PruebaController {

    @GetMapping("/prueba")
    public Prueba prueba() {
        return new Prueba(1, "Hola");
    }
}