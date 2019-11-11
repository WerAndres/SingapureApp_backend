package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.UsuariosMaterias;
import com.singapure.app.services.UsuariosMateriasService;

@RestController
public class UsuariosMateriasController {
	
	@Autowired
	UsuariosMateriasService usuariosMateriasService;
	@RequestMapping(value = "/secured/v1/usuarioMateria/filter", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getByUser(@RequestParam String email) throws Exception {
    	return usuariosMateriasService.findByEmail(email);
    }
	
	@GetMapping("/secured/v1/usuarioMateria")
    public ResponseEntity<?> getAll() throws Exception {
    	return usuariosMateriasService.getAllMaterias();
    }
	
	@PostMapping("/secured/v1/usuarioMateria/create")
    public ResponseEntity<?> create(@RequestBody UsuariosMaterias usuarioMateria) throws Exception {
    	return usuariosMateriasService.create(usuarioMateria);
    }
	
	@PostMapping("/v1/usuarioMateria/update")
    public ResponseEntity<?> update(@RequestBody UsuariosMaterias usuarioMateria) throws Exception {
    	return usuariosMateriasService.update(usuarioMateria);
    }
	
	@PostMapping("/v1/usuarioMateria/delete")
    public ResponseEntity<?> delete(@RequestBody UsuariosMaterias usuarioMateria) throws Exception {
    	return usuariosMateriasService.delete(usuarioMateria);
    }


}
