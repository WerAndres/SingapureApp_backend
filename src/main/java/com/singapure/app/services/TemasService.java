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
import com.singapure.app.models.Materias;
import com.singapure.app.models.Temas;
import com.singapure.app.models.TiposActividades;
import com.singapure.app.repo.TemasRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class TemasService {

	@Autowired
	private TemasRepository temasRepository;
	
	public ResponseEntity<?> getAllTemas() {
		List<Temas> temas = temasRepository.findAll();
		if(temas == null) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		if(temas.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND + "", CodeStatus.ERROR_SELECT_TEXT);
		}
		return GenericResponse.ok(temas);
	}

	public ResponseEntity<?> update(Temas tema) {
		Temas tem = temasRepository.save(tema);
		if(tem == null){
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
		return GenericResponse.ok(tema);
	}

	public ResponseEntity<?> delete(Temas tema) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> create(Temas tema) {
		
		
		if(tema.getFechaAct()== null) {
			tema.setFechaAct(new Date());
		}
		if(tema.getFechaCrea() == null) {
			tema.setFechaCrea(new Date());
		}
		
		try {
			
			Temas tem = temasRepository.save(tema);
			if(tem == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(tema);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

}
