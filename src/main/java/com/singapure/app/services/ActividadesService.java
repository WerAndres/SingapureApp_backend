package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Actividades;
import com.singapure.app.repo.ActividadesRepository;

@Service
public class ActividadesService {
	
	@Autowired
	private ActividadesRepository actividadesRepository;

	public Object consultarActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object actualizarActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object elimanarActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

}
