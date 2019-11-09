package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Actividades;
import com.singapure.app.models.Usuarios;
import com.singapure.app.services.ActividadesService;
import com.singapure.app.services.UsuariosService;

@RestController
public class ActividadController {
	
	@Autowired
	ActividadesService actividadesService;

	@GetMapping("/v1/actividades")
    public ResponseEntity<?> consultarActividades(@RequestBody Actividades actividad) throws Exception {
    	return GenericResponse.ok(actividadesService.consultarActividades(actividad));
    }
	
	@PostMapping("/v1/actividadesActualiza")
    public ResponseEntity<?> actualizarActividades(@RequestBody Actividades actividad) throws Exception {
    	return GenericResponse.ok(actividadesService.actualizarActividades(actividad));
    }
	
	@PostMapping("/v1/actividadesEliminar")
    public ResponseEntity<?> eliminarActividades(@RequestBody Actividades actividad) throws Exception {
    	return GenericResponse.ok(actividadesService.elimanarActividades(actividad));
    }

}
