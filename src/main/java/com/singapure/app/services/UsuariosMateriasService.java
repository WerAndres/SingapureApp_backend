package com.singapure.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Materias;
import com.singapure.app.models.Usuarios;
import com.singapure.app.models.UsuariosMaterias;
import com.singapure.app.repo.MateriasRepository;
import com.singapure.app.repo.UsuariosMateriasRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class UsuariosMateriasService {
	
	@Autowired
	private UsuariosMateriasRepository usuariosMateriasRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private MateriasRepository materiasRepository;
	
	public ResponseEntity<?> create(UsuariosMaterias usuarioMateria) {
		Usuarios user = usuariosRepository.findByEmail(usuarioMateria.getEmail());
		Materias mat = materiasRepository.findByIdMateria(usuarioMateria.getMateria().getIdMateria());
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		if(mat == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.CLASS_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.CLASS_NOT_EXISTS_TEXT);
		}
		UsuariosMaterias usuMat = new UsuariosMaterias();
		usuMat.setUsuario(user);
		usuMat.setMateria(mat);
		if(usuMat.getFechaActualizacion() == null) {
			usuMat.setFechaActualizacion(new Date());
		}
		if(usuMat.getFechaCreacion() == null) {
			usuMat.setFechaCreacion(new Date());
		}
		try {
			List<UsuariosMaterias> usC = usuariosMateriasRepository.findByUserIdMat(user.getIdUsuario(), mat.getIdMateria());
			if(!usC.isEmpty()) {
				return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.RELATION_ALREADY_EXIST,
						HttpStatus.CONFLICT, CodeStatus.RELATION_ALREADY_EXIST_TEXT, HttpStatus.CONFLICT + "");
			}
			UsuariosMaterias usCRet = usuariosMateriasRepository.save(usuMat);
			if(usCRet == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
			}
			return GenericResponse.ok(usCRet);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}

	public ResponseEntity<?> findByEmail(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		try {
			List<UsuariosMaterias> usMat = usuariosMateriasRepository.findByUserId(user.getIdUsuario());
			return GenericResponse.ok(usMat);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> getAllMaterias() {
		List<UsuariosMaterias> userMat = usuariosMateriasRepository.findAll();
		if(userMat.isEmpty()) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		return GenericResponse.ok(userMat);
	}
	
	public ResponseEntity<?> update(UsuariosMaterias usuarioMateria) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> delete(UsuariosMaterias usuarioMateria) {
		try {
			UsuariosMaterias usC = usuariosMateriasRepository.findByIdUserIdMat(usuarioMateria.getIdUsuarioMateria());
			if(usC == null) {
				return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.ERROR_DELETE,
						HttpStatus.CONFLICT, CodeStatus.ERROR_DELETE_TEXT, HttpStatus.CONFLICT + "");
			}
			usuariosMateriasRepository.delete(usC);
			return GenericResponse.ok(null);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}

}
