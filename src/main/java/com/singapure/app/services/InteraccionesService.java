package com.singapure.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Interacciones;
import com.singapure.app.models.Materias;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.InteraccionesRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class InteraccionesService {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
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
	
	public ResponseEntity<?> getAllfilterEmail(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		try {
			List<Interacciones> inter = interaccionesRepository.findByidUser(user.getIdUsuario());
			return GenericResponse.ok(inter);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SELECT,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> getAllfilterTema(String idTema) {
		try {
			List<Interacciones> inter = interaccionesRepository.findByidTema(Long.parseLong(idTema));
			return GenericResponse.ok(inter);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SELECT,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.BAD_REQUEST + "");
		}
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
		Usuarios user = usuariosRepository.findByEmail(interacciones.getEmail());
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		interacciones.setUsuario(user);
		if(interacciones.getFechaActualizacion()== null) {
			interacciones.setFechaActualizacion(new Date());
		}
		if(interacciones.getFechaCreacion() == null) {
			interacciones.setFechaCreacion(new Date());
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
