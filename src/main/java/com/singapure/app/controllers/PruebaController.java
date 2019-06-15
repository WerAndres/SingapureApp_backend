package com.singapure.app.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Prueba;

@RestController
public class PruebaController {


    @PostMapping("/prueba")
    public Prueba prueba() {
        return new Prueba(1, "Hola");
    }
}