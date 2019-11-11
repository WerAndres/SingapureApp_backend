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

import com.singapure.app.models.Materias;
import com.singapure.app.services.MateriasService;

@RestController
public class MateriasController {
	
	@Autowired
	MateriasService materiasService;

	@GetMapping("/secured/v1/materias")
    public ResponseEntity<?> getAll() throws Exception {
    	return materiasService.getAll();
    }
	
	@RequestMapping(value = "/secured/v1/materias/cantidatosAgregar", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> getAllFilter(@RequestParam String email) throws Exception {
    	return materiasService.getAllMateriasCandidates(email);
    }
	
	@GetMapping("/v1/materias/:idCurso")
    public ResponseEntity<?> getById(@RequestParam Integer idCurso) throws Exception {
    	return materiasService.getById(idCurso);
    }
	
	@PostMapping("/v1/materias/crear")
    public ResponseEntity<?> create(@RequestBody Materias Materias) throws Exception {
    	return materiasService.create(Materias);
    }
	
	@PostMapping("/v1/materias/actualizar")
    public ResponseEntity<?> update(@RequestBody Materias Materias) throws Exception {
    	return materiasService.update(Materias);
    }
	
	@PostMapping("/v1/materias/eliminar")
    public ResponseEntity<?> delete(@RequestBody Materias Materias) throws Exception {
    	return materiasService.delete(Materias);
    }

}
