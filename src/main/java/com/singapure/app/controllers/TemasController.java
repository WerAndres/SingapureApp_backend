package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Temas;
import com.singapure.app.services.TemasService;

@RestController
public class TemasController {
	
	@Autowired
	TemasService temasService;

	@GetMapping("/v1/temas")
    public ResponseEntity<?> consultarTemas(@RequestBody Temas tema) throws Exception {
    	return GenericResponse.ok(temasService.consultarTemas(tema));
    }
	
	@PostMapping("/v1/actividadesActualiza")
    public ResponseEntity<?> actualizarTemas(@RequestBody Temas tema) throws Exception {
    	return GenericResponse.ok(temasService.actualizarTemas(tema));
    }
	
	@PostMapping("/v1/actividadesEliminar")
    public ResponseEntity<?> eliminarTemas(@RequestBody Temas tema) throws Exception {
    	return GenericResponse.ok(temasService.elimanarTemas(tema));
    }


}
