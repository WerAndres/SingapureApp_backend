package com.singapure.app.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.singapure.app.dto.AuthenticationToken;
import com.singapure.app.models.Usuarios;
import com.singapure.app.repo.UsuariosRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class AuthService {
	
	@Autowired	
	private UsuariosRepository userRepository;
	
	private static final long EXPIRATION_SECONDS = 6000;
	private static final String SECURITY_KEY = "!@asdsadJAS780";
	
	public Usuarios auth(Usuarios user) throws Exception{
		Usuarios userBD = userRepository.getUserByEmailAndPwd(user.getEmail(), user.getPassword());
		if(userBD != null) {
			
			AuthenticationToken tok = generate(userBD.getEmail(), userBD.getIdUsuario()+"");
			userBD.setToken(tok.getToken());
			userBD.setPassword(null);
			userBD.setIdUsuario(null);
		}
		return userBD;
	}
	
	public Usuarios createUser(Usuarios user) throws Exception{
		if(user.getFechaActualizacion() == null) {
			user.setFechaActualizacion(new Date());
		}
		if(user.getFechaCreacion() == null) {
			user.setFechaCreacion(new Date());
		}
		Usuarios userBD = userRepository.save(user);
		return userBD;
	}
	
	public Usuarios getUser(Usuarios user) throws Exception{
		Usuarios userBD = userRepository.findByEmail(user.getEmail());
		return userBD;
	}
	
	public AuthenticationToken generate(@RequestHeader("clientTxt") String clientTxt,
			@RequestHeader("clientId") String clientId) {
		return new AuthenticationToken(Jwts.builder().setSubject(clientTxt).claim("role", "USER")
				.claim("Id", clientId).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_SECONDS * 1000))
				.signWith(SignatureAlgorithm.HS512, SECURITY_KEY).compact());
	}
	
	


}
