package com.singapure.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Cursos;
import com.singapure.app.repo.CursosRepository;

@Service
public class CursosService {
	
	@Autowired
	private CursosRepository cursosRepository;


	public ResponseEntity<?> getAllCursos() {
		List<Cursos> cursos = cursosRepository.findAll();
		if(cursos.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		return GenericResponse.ok(cursos);
	}


	public ResponseEntity<?> update(Cursos cursos) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> delete(Cursos cursos) {
		cursosRepository.delete(cursos);
		return GenericResponse.ok(cursos);
	}

	public ResponseEntity<?> create(Cursos curso) {
		
		if(curso.getFechaActualizacion()== null) {
			curso.setFechaActualizacion(new Date());
		}
		if(curso.getFechaCreacion() == null) {
			curso.setFechaCreacion(new Date());
		}
		
		try {
			
			Cursos cur = cursosRepository.save(curso);
			if(cur == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(curso);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

}
