package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.TiposActividades;
import com.singapure.app.services.TiposActividadesService;

@RestController
public class TiposActividadesController {
	
	@Autowired
	TiposActividadesService tiposActividadesService;

	@GetMapping("/v1/tipoActividades")
    public ResponseEntity<?> consultarActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.consultarTiposActividades(tipoActividad));
    }
	
	@PostMapping("/v1/tipoActividadesCrear")
    public ResponseEntity<?> crearActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.crearTiposActividades(tipoActividad));
    }
	
	@PostMapping("/v1/tipoActividadesActualiza")
    public ResponseEntity<?> actualizarActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.actualizarTiposActividades(tipoActividad));
    }
	
	@PostMapping("/v1/tipoActividadesEliminar")
    public ResponseEntity<?> eliminarActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.elimanarTiposActividades(tipoActividad));
    }

}
