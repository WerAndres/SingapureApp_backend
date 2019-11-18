package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.models.Actividades;
import com.singapure.app.services.ActividadesService;

@RestController
public class ActividadController {
	
	@Autowired
	ActividadesService actividadesService;

	@GetMapping("/secured/v1/actividades")
    public ResponseEntity<?> getAll() throws Exception {
    	return actividadesService.getAllActividades();
    }
	
	@RequestMapping(value = "/secured/v1/actividades/filterEmail", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getAllFilterEmail(@RequestParam String email) throws Exception {
    	return actividadesService.getAllfilterEmail(email);
    }
	
	@RequestMapping(value = "/secured/v1/actividades/filterTema", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getAllFilterTema(@RequestParam String idTema) throws Exception {
    	return actividadesService.getAllfilterTema(idTema);
    }
	
	@PostMapping("/secured/v1/actividades/crear")
    public ResponseEntity<?> crearActividades(@RequestBody Actividades actividad) throws Exception {
    	return actividadesService.create(actividad);
    }
	
	@PostMapping("/secured/v1/actividades/actualizar")
    public ResponseEntity<?> actualizarActividades(@RequestBody Actividades actividad) throws Exception {
    	return actividadesService.update(actividad);
    }
	
	@PostMapping("/v1/actividades/delete")
    public ResponseEntity<?> eliminarActividades(@RequestBody Actividades actividad) throws Exception {
    	return actividadesService.delete(actividad);
    }

}
