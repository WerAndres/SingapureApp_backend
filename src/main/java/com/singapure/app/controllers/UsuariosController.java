package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Usuarios;
import com.singapure.app.services.UsuariosService;


@RestController
public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	@PostMapping("/v1/usuarios")
	public ResponseEntity<?> updateUser(@RequestBody Usuarios usuario) throws Exception {
		return usuariosService.updateUser(usuario);

	}

}