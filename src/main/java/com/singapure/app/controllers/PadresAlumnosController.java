package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Actividades;
import com.singapure.app.models.PadresAlumnos;
import com.singapure.app.services.ActividadesService;
import com.singapure.app.services.PadresAlumnosService;


@RestController
public class PadresAlumnosController {

	@Autowired
	PadresAlumnosService padresAlumnosService;

	@GetMapping("/v1/padresAlumnos")
    public ResponseEntity<?> consultarPadresAlumnos(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return GenericResponse.ok(padresAlumnosService.consultarpadresAlumnos(padresAlumnos));
    }
	
	@PostMapping("/v1/padresAlumnosActualiza")
    public ResponseEntity<?> actualizarPadresAlumnos(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return GenericResponse.ok(padresAlumnosService.actualizarpadresAlumnos(padresAlumnos));
    }
	
	@PostMapping("/v1/padresAlumnosEliminar")
    public ResponseEntity<?> eliminarpadresAlumnos(@RequestBody PadresAlumnos padresAlumnos) throws Exception {
    	return GenericResponse.ok(padresAlumnosService.elimanarpadresAlumnos(padresAlumnos));
    }
	
}
