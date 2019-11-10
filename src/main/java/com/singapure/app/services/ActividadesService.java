package com.singapure.app.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Actividades;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.ActividadesRepository;

@Service
public class ActividadesService {
	
	@Autowired
	private ActividadesRepository actividadesRepository;

	public ResponseEntity<?> consultarActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> actualizarActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> elimanarActividades(Actividades actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> crearActividades(Actividades actividad) {
		if(actividad.getFechaAct() == null) {
			actividad.setFechaAct(new Date());
		}
		if(actividad.getFechaCrea() == null) {
			actividad.setFechaCrea(new Date());
		}
		Actividades actividadBD = actividadesRepository.save(actividad);
		return null;
	}

}
