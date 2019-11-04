package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.services.TiposUsuariosService;

@RestController
public class TiposUsuariosController {
	
	@Autowired
	TiposUsuariosService tiposUsuariosService;

	@GetMapping("/v1/tipos_usuarios")
    public ResponseEntity<?> login() throws Exception {
    	return GenericResponse.ok(tiposUsuariosService.getAll());
    }
	
}