package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.UsuariosCursos;
import com.singapure.app.repo.UsuariosCursosRepository;

@Service
public class UsuariosCursosService {
	
	@Autowired
	private UsuariosCursosRepository usuariosCursosRepository;

	public Object consultarUsuariosCursos(UsuariosCursos usuarioCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object actualizarUsuariosCursos(UsuariosCursos usuarioCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object elimanarUsuariosCursos(UsuariosCursos usuarioCurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
