package com.singapure.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.Actividades;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Interacciones;
import com.singapure.app.models.Temas;
import com.singapure.app.models.TiposActividades;
import com.singapure.app.repo.CursosRepository;
import com.singapure.app.repo.InteraccionesRepository;

@Service
public class InteraccionesService {

	@Autowired
	private InteraccionesRepository interaccionesRepository;
	
	public ResponseEntity<?> getAllInteracciones() {
		
		List<Interacciones> interacciones = interaccionesRepository.findAll();
		if(interacciones.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		return GenericResponse.ok(interacciones);
	}

	public ResponseEntity<?> update(Interacciones interacciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> delete(Interacciones interacciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> create(Interacciones interacciones) {
		
		if(interacciones.getFechaAct()== null) {
			interacciones.setFechaAct(new Date());
		}
		if(interacciones.getFechaCrea() == null) {
			interacciones.setFechaCrea(new Date());
		}
		
		try {
			
			Interacciones interac = interaccionesRepository.save(interacciones);
			if(interac == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(interacciones);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

}
