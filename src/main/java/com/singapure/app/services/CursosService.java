package com.singapure.app.services;

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

	public ResponseEntity<?> consultarAllCursos() {
		List<Cursos> resp = cursosRepository.findAll();
		if(resp == null) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.LIST_COURSE_EMPTY,
					HttpStatus.NOT_FOUND, CodeStatus.LIST_COURSE_EMPTY_TEXT);
		}
		if(resp.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.LIST_COURSE_EMPTY,
					HttpStatus.NOT_FOUND, CodeStatus.LIST_COURSE_EMPTY_TEXT);
		}
		return GenericResponse.ok(resp);
	}

	public static Object consultarCursos(Integer id) {
		return null;
	}

	public static Object actualizarCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object elimanarCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object crearCursos(Cursos cursos) {
		// TODO Auto-generated method stub
		return null;
	}

}
