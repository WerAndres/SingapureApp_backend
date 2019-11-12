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
	private InteraccionesService interaccionesService;

	@GetMapping("/v1/interacciones")
    public ResponseEntity<?> getAllInteracciones() throws Exception {
    	return GenericResponse.ok(interaccionesService.getAllInteracciones());
    }
	
	@PostMapping("/v1/interacciones/create")
    public ResponseEntity<?> create(@RequestBody Interacciones interacciones) throws Exception {
    	return GenericResponse.ok(interaccionesService.create(interacciones));
    }
	
	@PostMapping("/v1/interacciones/update")
    public ResponseEntity<?> actualizarInteracciones(@RequestBody Interacciones interacciones) throws Exception {
    	return GenericResponse.ok(interaccionesService.update(interacciones));
    }
	
	@PostMapping("/v1/interacciones/delete")
    public ResponseEntity<?> delete(@RequestBody Interacciones interacciones) throws Exception {
    	return GenericResponse.ok(interaccionesService.delete(interacciones));
    }

}
