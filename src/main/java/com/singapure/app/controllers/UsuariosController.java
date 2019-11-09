package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Usuarios;
import com.singapure.app.services.UsuariosService;

@RestController
public class UsuariosController {
	
	@Autowired
	UsuariosService usuariosService;

	@PutMapping("/v1/usuarios")
    public ResponseEntity<?> updateUser(Usuarios usuario) throws Exception {
    	return GenericResponse.ok(usuariosService.updateUser(usuario));
    }
	
}