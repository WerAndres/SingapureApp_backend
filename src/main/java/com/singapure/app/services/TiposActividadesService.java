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
import com.singapure.app.repo.TiposActividadesRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class TiposActividadesService {
	
	@Autowired
	private TiposActividadesRepository tiposActividadesRepository;

	public ResponseEntity<?> getAllTiposActividades() {
		List<TiposActividades> tipoAct = tiposActividadesRepository.findAll();
		if(tipoAct == null) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		if(tipoAct.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		return GenericResponse.ok(tipoAct);
	}

	public ResponseEntity<?> update(TiposActividades tipoActividad) {
		
		TiposActividades tipoAct = tiposActividadesRepository.save(tipoActividad);
		
		if(tipoAct == null) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		return GenericResponse.ok(tipoAct);
	}

	public ResponseEntity<?> delete(TiposActividades tipoActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> create(TiposActividades tipoActividad) {
		
		if(tipoActividad.getFechaAct()== null) {
			tipoActividad.setFechaAct(new Date());
		}
		if(tipoActividad.getFechaCrea() == null) {
			tipoActividad.setFechaCrea(new Date());
		}
		
		try {
			
			TiposActividades tipoAct = tiposActividadesRepository.save(tipoActividad);
			if(tipoAct == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(tipoActividad);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}
}
