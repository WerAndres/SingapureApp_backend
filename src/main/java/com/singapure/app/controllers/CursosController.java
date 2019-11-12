package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Cursos;
import com.singapure.app.services.CursosService;
import com.singapure.app.services.UsuariosMateriasService;

@RestController
public class CursosController {
	
	@Autowired
	private CursosService cursosService;
	
	@Autowired
	UsuariosMateriasService usuariosMateriasService;

	@GetMapping("/v1/cursos")
    public ResponseEntity<?> getAllCursos() throws Exception {
    	return cursosService.getAllCursos();
    }
		
	@PostMapping("/v1/cursos/create")
    public ResponseEntity<?> create(@RequestBody Cursos cursos) throws Exception {
    	return cursosService.create(cursos);
    }
	
	@PostMapping("/v1/cursos/update")
    public ResponseEntity<?> update(@RequestBody Cursos cursos) throws Exception {
    	return cursosService.update(cursos);
    }
	
	@PostMapping("/v1/cursos/delete")
    public ResponseEntity<?> delete(@RequestBody Cursos cursos) throws Exception {
    	return cursosService.delete(cursos);
    }

}
