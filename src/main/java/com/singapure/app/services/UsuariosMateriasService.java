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
	
	public ResponseEntity<?> crearUsuariosMaterias(UsuariosMaterias usuarioMateria) {
		Usuarios user = usuariosRepository.findByEmail(usuarioMateria.getEmail());
		Materias mat = materiasRepository.findByIdMateria(usuarioMateria.getMateria().getIdMateria());
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		usuarioMateria.setUsuario(user);
		usuarioMateria.setMateria(mat);
		if(usuarioMateria.getFechaActualizacion() == null) {
			usuarioMateria.setFechaActualizacion(new Date());
		}
		if(usuarioMateria.getFechaCreacion() == null) {
			usuarioMateria.setFechaCreacion(new Date());
		}
		try {
			List<UsuariosMaterias> usC = usuariosMateriasRepository.findByUserIdMat(user.getIdUsuario(), mat.getIdMateria());
			if(!usC.isEmpty()) {
				return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.RELATION_ALREADY_EXIST,
						HttpStatus.CONFLICT, HttpStatus.CONFLICT + "", CodeStatus.RELATION_ALREADY_EXIST_TEXT);
			}
			UsuariosMaterias usCRet = usuariosMateriasRepository.save(usuarioMateria);
			if(usCRet == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
			}
			return GenericResponse.ok(usCRet);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

	public ResponseEntity<?> consultarUsuariosMaterias(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		return GenericResponse.ok(usuariosMateriasRepository.findByUserId(user.getIdUsuario()));
	}

	public ResponseEntity<?> actualizarUsuariosMaterias(UsuariosMaterias usuarioMateria) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> elimanarUsuariosMaterias(UsuariosMaterias usuarioMateria) {
		// TODO Auto-generated method stub
		return null;
	}

}
