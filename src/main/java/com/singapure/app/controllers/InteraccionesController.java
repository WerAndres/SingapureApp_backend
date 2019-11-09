package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Interacciones;
import com.singapure.app.services.InteraccionesService;

@RestController
public class InteraccionesController {
	
	@Autowired
	InteraccionesService interaccionesService;

	@GetMapping("/v1/Interacciones")
    public ResponseEntity<?> consultarInteracciones(@RequestBody Interacciones interacciones) throws Exception {
    	return GenericResponse.ok(InteraccionesService.consultarInteracciones(interacciones));
    }
	
	@PostMapping("/v1/InteraccionesActualiza")
    public ResponseEntity<?> actualizarInteracciones(@RequestBody Interacciones interacciones) throws Exception {
    	return GenericResponse.ok(InteraccionesService.actualizarInteracciones(interacciones));
    }
	
	@PostMapping("/v1/InteraccionesEliminar")
    public ResponseEntity<?> eliminarInteracciones(@RequestBody Interacciones interacciones) throws Exception {
    	return GenericResponse.ok(InteraccionesService.eliminarInteracciones(interacciones));
    }

}
