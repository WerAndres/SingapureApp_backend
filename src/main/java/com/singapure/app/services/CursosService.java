package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Cursos;
import com.singapure.app.repo.CursosRepository;

@Service
public class CursosService {
	
	@Autowired
	private CursosRepository cursosRepository;

	public ResponseEntity<?> getAll() {
		return null;
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
