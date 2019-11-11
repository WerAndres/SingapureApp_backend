package com.singapure.app.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;

	public ResponseEntity<?> updateUser(Usuarios usuario) {
		Usuarios usuarioSave = usuariosRepository.findByEmail(usuario.getKeyEmail());
		usuarioSave.setFechaActualizacion(new Date());
		usuarioSave.setNombre(usuario.getNombre() != null ? usuario.getNombre() : usuarioSave.getNombre());
		usuarioSave.setPhoto(usuario.getPhoto() != null ? usuario.getPhoto() : usuarioSave.getPhoto());

		if (usuario.getKeyEmail().equals(usuario.getEmail())) {
			usuarioSave.setEmail(usuario.getEmail());
			return GenericResponse.ok(usuariosRepository.save(usuarioSave));
		} else {
			Usuarios emailExiste = usuariosRepository.findByEmail(usuario.getEmail());
			if (emailExiste != null) {
				if (emailExiste.getEmail().equals(usuario.getEmail())) {
					return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.USER_ALREADY_EXISTS,
							HttpStatus.CONFLICT, HttpStatus.CONFLICT + "", CodeStatus.USER_ALREADY_EXISTS_TEXT);
				}else {
					usuarioSave.setEmail(usuario.getEmail());
					return GenericResponse.ok(usuariosRepository.save(usuarioSave));
				}
			}else {
				usuarioSave.setEmail(usuario.getEmail());
				return GenericResponse.ok(usuariosRepository.save(usuarioSave));
			}
		}
	}
}
