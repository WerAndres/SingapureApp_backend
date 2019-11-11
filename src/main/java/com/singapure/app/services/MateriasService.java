package com.singapure.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Materias;
import com.singapure.app.repo.MateriasRepository;

@Service
public class MateriasService {
	
	@Autowired
	private MateriasRepository materiasRepository;

	public ResponseEntity<?> getAll() {
		List<Materias> resp = materiasRepository.findAll();
		if(resp == null) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.LIST_CLASS_EMPTY,
					HttpStatus.NOT_FOUND, CodeStatus.LIST_CLASS_EMPTY_TEXT);
		}
		if(resp.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.LIST_CLASS_EMPTY,
					HttpStatus.NOT_FOUND, CodeStatus.LIST_CLASS_EMPTY_TEXT);
		}
		return GenericResponse.ok(resp);
	}

	public Object consultarMaterias(Integer id) {
		return null;
	}

	public Object actualizarMaterias(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eliminarMaterias(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object crearMaterias(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

}
