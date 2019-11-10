package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.UsuariosCursos;
import com.singapure.app.services.UsuariosCursosService;

@RestController
public class UsuariosCursosController {
	
	@Autowired
	UsuariosCursosService usuariosCursosService;

	@GetMapping("/v1/usuarioCurso")
    public ResponseEntity<?> consultarUsuariosCursos(@RequestBody UsuariosCursos usuarioCurso) throws Exception {
    	return GenericResponse.ok(usuariosCursosService.consultarUsuariosCursos(usuarioCurso));
    }
	
	@PostMapping("/v1/usuarioCursoCrear")
    public ResponseEntity<?> crearUsuariosCursos(@RequestBody UsuariosCursos usuarioCurso) throws Exception {
    	return GenericResponse.ok(usuariosCursosService.crearUsuariosCursos(usuarioCurso));
    }
	
	@PostMapping("/v1/usuarioCursoActualiza")
    public ResponseEntity<?> actualizarUsuariosCursos(@RequestBody UsuariosCursos usuarioCurso) throws Exception {
    	return GenericResponse.ok(usuariosCursosService.actualizarUsuariosCursos(usuarioCurso));
    }
	
	@PostMapping("/v1/usuarioCursoEliminar")
    public ResponseEntity<?> eliminarUsuariosCursos(@RequestBody UsuariosCursos usuarioCurso) throws Exception {
    	return GenericResponse.ok(usuariosCursosService.elimanarUsuariosCursos(usuarioCurso));
    }


}
