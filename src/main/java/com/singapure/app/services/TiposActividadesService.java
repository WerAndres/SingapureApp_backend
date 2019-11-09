package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Actividades;
import com.singapure.app.repo.TiposActividadesRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class TiposActividadesService {
	
	@Autowired
	private TiposActividadesRepository tiposActividadesRepository;

	public Object consultarTiposActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object actualizarTiposActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object elimanarTiposActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

}
