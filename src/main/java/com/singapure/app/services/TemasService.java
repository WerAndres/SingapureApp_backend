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
import com.singapure.app.models.Temas;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.MateriasRepository;
import com.singapure.app.repo.PadresAlumnosRepository;
import com.singapure.app.repo.TemasRepository;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class TemasService {

	@Autowired
	private TemasRepository temasRepository;
	
	@Autowired
	private MateriasRepository materiasRepository;
		
	@Autowired
	private PadresAlumnosRepository padresAlumnosRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
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
	
	public ResponseEntity<?> getAllfilterEmail(String email) {
		Usuarios user = usuariosRepository.findByEmail(email);
		if(user == null) {
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.USER_NOT_EXISTS,
					HttpStatus.BAD_REQUEST, CodeStatus.USER_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
		}
		try {
			List<Temas> usMat = temasRepository.findByUserIdTemFilter(user.getIdUsuario());
			if(user.getTipoUsuario().getIdTipoUsuario() == 3) {
				for (Temas item : usMat) {
					item.getMateria().setUsuariosAlumnos(padresAlumnosRepository.findMateriasByIdPadre(user.getIdUsuario(), item.getMateria().getIdMateria()));
				}
			}
			return GenericResponse.ok(usMat);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_SELECT,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_SELECT_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}
	
	public ResponseEntity<?> update(Temas tema) {
		try {
			Temas temasOld = temasRepository.findByIdtema(tema.getIdTema());
			if(temasOld == null) {
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_TOPIC_NO_EXIST,
						HttpStatus.BAD_REQUEST, CodeStatus.ERROR_TOPIC_NO_EXIST_TEXT, HttpStatus.BAD_REQUEST + "");
			}
			
			Materias materiaOld = materiasRepository.findByIdMateria(tema.getMateria().getIdMateria());
			if(materiaOld == null) {
				return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.CLASS_NOT_EXISTS,
						HttpStatus.BAD_REQUEST, CodeStatus.CLASS_NOT_EXISTS_TEXT, HttpStatus.BAD_REQUEST + "");
			}
			tema.setFechaActualizacion(new Date());
			tema.setFechaCreacion(temasOld.getFechaCreacion());
			tema.setMateria(materiaOld);
			Temas temasNew = temasRepository.save(tema);
			return GenericResponse.ok(temasNew);
		} catch (Exception e) {
			e.printStackTrace();
			return GenericResponse.generic(CodeStatus.HTTP_BAD_REQUEST, CodeStatus.ERROR_UPDATE,
					HttpStatus.BAD_REQUEST, CodeStatus.ERROR_UPDATE_TEXT, HttpStatus.BAD_REQUEST + "");
		}
	}

	public ResponseEntity<?> delete(Temas tema) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> create(Temas tema) {
		
		if(tema.getFechaActualizacion()== null) {
			tema.setFechaActualizacion(new Date());
		}
		if(tema.getFechaCreacion() == null) {
			tema.setFechaCreacion(new Date());
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
