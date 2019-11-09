package com.singapure.app.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.UsuariosRepository;
@Service
public class UsuariosService {
	
	@Autowired	
	private UsuariosRepository usuariosRepository;
	
	public Usuarios updateUser(Usuarios usuario){
		Usuarios usuarioSave = usuariosRepository.findByEmail(usuario.getEmail());
		usuarioSave.setFechaActualizacion(new Date());
		usuarioSave.setNombre(usuario.getNombre() != null ? usuario.getNombre() : usuarioSave.getNombre());
		usuarioSave.setPhoto(usuario.getPhoto() != null ? usuario.getPhoto() : usuarioSave.getPhoto());
		return usuariosRepository.save(usuarioSave);
	}
}