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
import com.singapure.app.models.Temas;
import com.singapure.app.models.TiposActividades;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.ActividadesRepository;
import com.singapure.app.repo.TemasRepository;
import com.singapure.app.repo.TiposActividadesRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class ActividadesService {
	
	@Autowired
	private ActividadesRepository actividadesRepository;
	
	@Autowired
	private TiposActividadesRepository tipoActividadesRepository;
	
	@Autowired
	private TemasRepository temasRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	public ResponseEntity<?> getAllActividades() {
		List<Actividades> actividades = actividadesRepository.findAll();
		if(actividades.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		return GenericResponse.ok(actividades);
	}

	public ResponseEntity<?> getAllfilterEmail(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		try {
			List<Actividades> acti = actividadesRepository.findByidUser(user.getIdUsuario());
			return GenericResponse.ok(acti);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SELECT,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> getAllfilterTema(String idTema) {
		try {
			List<Actividades> inter = actividadesRepository.findByidTema(Long.parseLong(idTema));
			return GenericResponse.ok(inter);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SELECT,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> update(Actividades actividad) {
		
		Actividades acti = actividadesRepository.save(actividad);
		if(acti == null){
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
		return GenericResponse.ok(actividad);
	}

	public ResponseEntity<?> delete(Actividades actividad) {
		
		return null;
	}

	public ResponseEntity<?> create(Actividades actividad) {
		
		TiposActividades tipoAct = tipoActividadesRepository.findByIdAct(actividad.getTiposActividades().getIdTipoActividad());
		Temas tema = temasRepository.findByIdtema(actividad.getTema().getIdTema());
		if(tipoAct == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		actividad.setTiposActividades(tipoAct);
		actividad.setTema(tema);
		
		if(actividad.getFechaAct()== null) {
			actividad.setFechaAct(new Date());
		}
		if(actividad.getFechaCrea() == null) {
			actividad.setFechaCrea(new Date());
		}
		try {
			
			Actividades acti = actividadesRepository.save(actividad);
			if(acti == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(actividad);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

}
