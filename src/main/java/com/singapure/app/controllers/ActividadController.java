package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Actividades;
import com.singapure.app.services.ActividadesService;

@RestController
public class ActividadController {
	
	@Autowired
	ActividadesService actividadesService;

	@GetMapping("/v1/actividades")
    public ResponseEntity<?> getAll() throws Exception {
    	return actividadesService.getAllActividades();
    }
	
	@PostMapping("/v1/actividades/create")
    public ResponseEntity<?> crearActividades(@RequestBody Actividades actividad) throws Exception {
    	return actividadesService.create(actividad);
    }
	
	@PostMapping("/v1/actividades/update")
    public ResponseEntity<?> actualizarActividades(@RequestBody Actividades actividad) throws Exception {
    	return actividadesService.update(actividad);
    }
	
	@PostMapping("/v1/actividades/delete")
    public ResponseEntity<?> eliminarActividades(@RequestBody Actividades actividad) throws Exception {
    	return actividadesService.delete(actividad);
    }

}
