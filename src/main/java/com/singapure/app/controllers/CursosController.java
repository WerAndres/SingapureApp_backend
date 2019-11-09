package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Cursos;
import com.singapure.app.services.CursosService;

@RestController
public class CursosController {
	
	@Autowired
	CursosService cursosService;

	@GetMapping("/v1/cursos")
    public ResponseEntity<?> consultarCursos(@RequestBody Cursos cursos) throws Exception {
    	return GenericResponse.ok(CursosService.consultarCursos(cursos));
    }
	
	@PostMapping("/v1/cursosActualiza")
    public ResponseEntity<?> actualizarCursos(@RequestBody Cursos cursos) throws Exception {
    	return GenericResponse.ok(CursosService.actualizarCursos(cursos));
    }
	
	@PostMapping("/v1/cursosEliminar")
    public ResponseEntity<?> eliminarCursos(@RequestBody Cursos cursos) throws Exception {
    	return GenericResponse.ok(CursosService.elimanarCursos(cursos));
    }

}
