package com.singapure.app.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Prueba;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PruebaController {

	@GetMapping("/secured/api/prueba/{id}/{content}")
    public Prueba prueba(@PathVariable(value="id") int id, @PathVariable(value="content") String content) {
    	System.out.println("id: " + id);
    	System.out.println("content: " + content);
        return new Prueba(id, content);
    }
	
	@PostMapping("/secured/api/prueba")
    public Prueba prueba() {
        return new Prueba(5, "post");
    }
    

}