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
    public ResponseEntity<?> consultarActividades() throws Exception {
    	return GenericResponse.ok(tiposActividadesService.getAllTiposActividades());
    }
	
	@PostMapping("/v1/tipoActividades/create")
    public ResponseEntity<?> crearActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.create(tipoActividad));
    }
	
	@PostMapping("/v1/tipoActividades/update")
    public ResponseEntity<?> actualizarActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.update(tipoActividad));
    }
	
	@PostMapping("/v1/tipoActividades/delete")
    public ResponseEntity<?> eliminarActividades(@RequestBody TiposActividades tipoActividad) throws Exception {
    	return GenericResponse.ok(tiposActividadesService.delete(tipoActividad));
    }

}
