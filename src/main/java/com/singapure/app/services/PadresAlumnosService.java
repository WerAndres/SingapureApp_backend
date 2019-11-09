package com.singapure.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.PadresAlumnos;
import com.singapure.app.repo.InteraccionesRepository;
import com.singapure.app.repo.padresAlumnosRepository;

@Service
public class PadresAlumnosService {

	@Autowired
	private padresAlumnosRepository padresAlumnosRepository;
	
	public Object consultarpadresAlumnos(PadresAlumnos padresAlumnos) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object actualizarpadresAlumnos(PadresAlumnos padresAlumnos) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object elimanarpadresAlumnos(PadresAlumnos padresAlumnos) {
		// TODO Auto-generated method stub
		return null;
	}

}
