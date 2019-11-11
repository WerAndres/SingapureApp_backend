package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.UsuariosMaterias;
import com.singapure.app.services.UsuariosMateriasService;

@RestController
public class UsuariosMateriasController {
	
	@Autowired
	UsuariosMateriasService usuariosMateriasService;

	@GetMapping("/secured/v1/usuarioMateria")
    public ResponseEntity<?> consultarUsuariosMaterias(@RequestBody String email) throws Exception {
    	return usuariosMateriasService.consultarUsuariosMaterias(email);
    }
	
	@PostMapping("/secured/v1/usuarioMateriaCrear")
    public ResponseEntity<?> crearUsuariosMaterias(@RequestBody UsuariosMaterias usuarioMateria) throws Exception {
    	return usuariosMateriasService.crearUsuariosMaterias(usuarioMateria);
    }
	
	@PostMapping("/v1/usuarioMateriaActualiza")
    public ResponseEntity<?> actualizarUsuariosMaterias(@RequestBody UsuariosMaterias usuarioMateria) throws Exception {
    	return usuariosMateriasService.actualizarUsuariosMaterias(usuarioMateria);
    }
	
	@PostMapping("/v1/usuarioMateriaEliminar")
    public ResponseEntity<?> eliminarUsuariosMaterias(@RequestBody UsuariosMaterias usuarioMateria) throws Exception {
    	return usuariosMateriasService.elimanarUsuariosMaterias(usuarioMateria);
    }


}
