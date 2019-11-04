package com.singapure.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singapure.app.models.TiposUsuarios;
import com.singapure.app.repo.TiposUsuariosRepository;
@Service
public class TiposUsuariosService {
	
	@Autowired	
	private TiposUsuariosRepository tiposUsuariosRepository;
	
	public List<TiposUsuarios> getAll(){
		return tiposUsuariosRepository.findAll();
	}
}
