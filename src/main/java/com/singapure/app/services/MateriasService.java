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
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		if(resp.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		return GenericResponse.ok(resp);
	}

	public ResponseEntity<?> consultarMaterias(Integer id) {
		return null;
	}

	public ResponseEntity<?> actualizarMaterias(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> eliminarMaterias(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> crearMaterias(Materias materias) {
		try {
			Materias mat = materiasRepository.save(materias);
			if(mat == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(mat);
		}catch (Exception e) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}	
	}

}
