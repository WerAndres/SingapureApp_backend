package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Temas;
import com.singapure.app.repo.TemasRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class TemasService {

	@Autowired
	private TemasRepository temasRepository;
	
	public Object consultarTemas(Temas tema) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object actualizarTemas(Temas tema) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object elimanarTemas(Temas tema) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object crearTemas(Temas tema) {
		// TODO Auto-generated method stub
		return null;
	}

}
