package com.singapure.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.PadresAlumnos;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.PadresAlumnosRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class PadresAlumnosService {

	@Autowired
	private PadresAlumnosRepository padresAlumnosRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public ResponseEntity<?> findByEmailPadre(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		try {
			List<PadresAlumnos> padAlum = padresAlumnosRepository.findByIdAlumno(user.getIdUsuario());
			return GenericResponse.ok(padAlum);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

	public ResponseEntity<?> findByEmailAlumno(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.USER_NOT_EXISTS_TEXT);
		}
		try {
			List<PadresAlumnos> padAlum = padresAlumnosRepository.findByIdPadre(user.getIdUsuario());
			return GenericResponse.ok(padAlum);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST + "", CodeStatus.ERROR_SAVE_TEXT);
		}
	}

	public ResponseEntity<?> delete(PadresAlumnos padreAlumno) {
		try {
			PadresAlumnos padA = padresAlumnosRepository.findByIdPadreAlumno(padreAlumno.getIdPadreAlumno());
			if(padA == null) {
				return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.ERROR_DELETE,
						HttpStatus.CONFLICT, CodeStatus.ERROR_DELETE_TEXT, HttpStatus.CONFLICT + "");
			}
			padresAlumnosRepository.delete(padA);
			return GenericResponse.ok(null);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> update(PadresAlumnos padresAlumnos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResponseEntity<?> create(PadresAlumnos padresAlumnos) {
		Usuarios userPadre = usuariosRepository.findByEmail(padresAlumnos.getPadre().getEmail());
		Usuarios userAlumno = usuariosRepository.findByEmail(padresAlumnos.getAlumno().getEmail());
		if(userPadre == null || userAlumno == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		PadresAlumnos padAlum = new PadresAlumnos();
		padAlum.setAlumno(userAlumno);
		padAlum.setPadre(userPadre);
		if(padAlum.getFechaActualizacion() == null) {
			padAlum.setFechaActualizacion(new Date());
		}
		if(padAlum.getFechaCreacion() == null) {
			padAlum.setFechaCreacion(new Date());
		}
		try {
			List<PadresAlumnos> pad = padresAlumnosRepository.findByIdPadreIdAlumno(userPadre.getIdUsuario(), userAlumno.getIdUsuario());
			if(!pad.isEmpty()) {
				return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.RELATION_ALREADY_EXIST,
						HttpStatus.CONFLICT, CodeStatus.RELATION_ALREADY_EXIST_TEXT, HttpStatus.CONFLICT + "");
			}
			PadresAlumnos padRet = padresAlumnosRepository.save(padAlum);
			if(padRet == null){
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
						HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
			}
			return GenericResponse.ok(padRet);
		}catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SAVE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SAVE_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}

}
