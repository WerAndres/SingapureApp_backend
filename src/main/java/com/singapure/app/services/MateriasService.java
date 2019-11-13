package com.singapure.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Materias;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.MateriasRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class MateriasService {
	
	@Autowired
	private MateriasRepository materiasRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	public ResponseEntity<?> getAll() {
		List<Materias> resp = materiasRepository.findAll();
		if(resp == null) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.NOT_FOUND + "");
		}
		if(resp.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_NOT_FOUND, CodeStatus.ERROR_SELECT,
					HttpStatus.NOT_FOUND, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.NOT_FOUND + "");
		}
		return GenericResponse.ok(resp);
	}

	public ResponseEntity<?> getAllbyEmail(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		try {
			List<Materias> usMat = materiasRepository.findByUserIdMatFilter(user.getIdUsuario());
			return GenericResponse.ok(usMat);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SELECT,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> getById(Integer id) {
		return null;
	}

	public ResponseEntity<?> update(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> delete(Materias materias) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> create(Materias materias) {
		try {
			Materias mat = materiasRepository.save(materias);
			if(mat == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
			}
			return GenericResponse.ok(mat);
		}catch (Exception e) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
		}	
	}

}
