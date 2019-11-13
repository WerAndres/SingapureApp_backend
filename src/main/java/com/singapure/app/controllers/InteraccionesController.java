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

import com.singapure.app.models.Interacciones;
import com.singapure.app.services.InteraccionesService;

@RestController
public class InteraccionesController {
	
	@Autowired
	private InteraccionesService interaccionesService;

	@GetMapping("/v1/interacciones")
    public ResponseEntity<?> getAllInteracciones() throws Exception {
    	return interaccionesService.getAllInteracciones();
    }
	
	
	@RequestMapping(value = "/secured/v1/interacciones/filterEmail", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getAllFilterEmail(@RequestParam String email) throws Exception {
    	return interaccionesService.getAllfilterEmail(email);
    }
	
	@RequestMapping(value = "/secured/v1/interacciones/filterTema", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getAllFilterTema(@RequestParam String idTema) throws Exception {
    	return interaccionesService.getAllfilterTema(idTema);
    }
	
	@PostMapping("/secured/v1/interacciones/create")
    public ResponseEntity<?> create(@RequestBody Interacciones interacciones) throws Exception {
    	return interaccionesService.create(interacciones);
    }
	
	@PostMapping("/v1/interacciones/update")
    public ResponseEntity<?> actualizarInteracciones(@RequestBody Interacciones interacciones) throws Exception {
    	return interaccionesService.update(interacciones);
    }
	
	@PostMapping("/v1/interacciones/delete")
    public ResponseEntity<?> delete(@RequestBody Interacciones interacciones) throws Exception {
    	return interaccionesService.delete(interacciones);
    }

}
