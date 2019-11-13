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

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Temas;
import com.singapure.app.services.TemasService;

@RestController
public class TemasController {
	
	@Autowired
	TemasService temasService;

	@GetMapping("/v1/temas")
    public ResponseEntity<?> getAll() throws Exception {
    	return temasService.getAllTemas();
    }
	
	@RequestMapping(value = "/secured/v1/temas/filter", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getAllFilter(@RequestParam String email) throws Exception {
    	return temasService.getAllfilterEmail(email);
    }
	
	
	@PostMapping("/v1/temas/create")
    public ResponseEntity<?> crearTemas(@RequestBody Temas tema) throws Exception {
    	return GenericResponse.ok(temasService.create(tema));
    }
	
	@PostMapping("/v1/temas/update")
    public ResponseEntity<?> ActualizarTemas(@RequestBody Temas tema) throws Exception {
    	return GenericResponse.ok(temasService.update(tema));
    }
	
	@PostMapping("/v1/temas/delete")
    public ResponseEntity<?> eliminarTemas(@RequestBody Temas tema) throws Exception {
    	return GenericResponse.ok(temasService.delete(tema));
    }


}
