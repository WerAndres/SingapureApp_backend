package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.PadresAlumnos;
import com.singapure.app.services.PadresAlumnosService;


@RestController
public class PadresAlumnosController {

	@Autowired
	PadresAlumnosService padresAlumnosService;

	@GetMapping("/secured/v1/padresAlumnos/alumno")
    public ResponseEntity<?> findByEmailAlumno(@RequestParam String email) throws Exception {
    	return padresAlumnosService.findByEmailAlumno(email);
    }
	@GetMapping("/secured/v1/padresAlumnos/padre")
    public ResponseEntity<?> findByEmailPadre(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return padresAlumnosService.findByEmailPadre(padresAlumnos);
    }
	
	@PostMapping("/secured/v1/padresAlumnosActualiza")
    public ResponseEntity<?> update(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return padresAlumnosService.update(padresAlumnos);
    }
	
	@PostMapping("/secured/v1/padresAlumnos/create")
    public ResponseEntity<?> createAlumno(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return padresAlumnosService.create(padresAlumnos);
    }
	
	@PostMapping("/secured/v1/padresAlumnosEliminar")
    public ResponseEntity<?> delete(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return padresAlumnosService.delete(padresAlumnos);
    }
	
}
