package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Materias;
import com.singapure.app.services.MateriasService;

@RestController
public class MateriasController {
	
	@Autowired
	MateriasService materiasService;

	@GetMapping("/v1/materias")
    public ResponseEntity<?> consultarAllMaterias() throws Exception {
    	return GenericResponse.ok(materiasService.getAll());
    }
	
	@GetMapping("/v1/materias/:idCurso")
    public ResponseEntity<?> consultarMaterias(@RequestParam Integer idCurso) throws Exception {
    	return GenericResponse.ok(materiasService.consultarMaterias(idCurso));
    }
	
	@PostMapping("/v1/materiasCrear")
    public ResponseEntity<?> crearMaterias(@RequestBody Materias Materias) throws Exception {
    	return GenericResponse.ok(materiasService.crearMaterias(Materias));
    }
	
	@PostMapping("/v1/materiasActualiza")
    public ResponseEntity<?> actualizarMaterias(@RequestBody Materias Materias) throws Exception {
    	return GenericResponse.ok(materiasService.actualizarMaterias(Materias));
    }
	
	@PostMapping("/v1/materiasEliminar")
    public ResponseEntity<?> eliminarMaterias(@RequestBody Materias Materias) throws Exception {
    	return GenericResponse.ok(materiasService.eliminarMaterias(Materias));
    }

}
