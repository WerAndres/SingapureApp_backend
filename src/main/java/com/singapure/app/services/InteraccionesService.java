package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Interacciones;
import com.singapure.app.repo.CursosRepository;
import com.singapure.app.repo.InteraccionesRepository;

@Service
public class InteraccionesService {

	@Autowired
	private InteraccionesRepository interaccionesRepository;
	
	public static Object consultarInteracciones(Interacciones interacciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object actualizarInteracciones(Interacciones interacciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object eliminarInteracciones(Interacciones interacciones) {
		// TODO Auto-generated method stub
		return null;
	}

}
