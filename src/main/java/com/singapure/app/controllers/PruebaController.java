package com.singapure.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Prueba;

@RestController
public class PruebaController {

    @GetMapping("/prueba/{id}/{content}")
    public Prueba prueba(@PathVariable(value="id") int id, @PathVariable(value="content") String content) {
    	System.out.println("id: " + id);
    	System.out.println("content: " + content);
        return new Prueba(id, content);
    }
}