package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Actividades;
import com.singapure.app.services.TiposActividadesService;

@RestController
public class TiposActividadesController {
	
	@Autowired
	TiposActividadesService tiposActividadesService;

	@GetMapping("/v1/tipoActividades")
    public ResponseEntity<?> consultarActividades(@RequestBody Actividades actividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.consultarTiposActividades(actividad));
    }
	
	@PostMapping("/v1/tipoActividadesActualiza")
    public ResponseEntity<?> actualizarActividades(@RequestBody Actividades actividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.actualizarTiposActividades(actividad));
    }
	
	@PostMapping("/v1/tipoActividadesEliminar")
    public ResponseEntity<?> eliminarActividades(@RequestBody Actividades actividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.elimanarTiposActividades(actividad));
    }

}
