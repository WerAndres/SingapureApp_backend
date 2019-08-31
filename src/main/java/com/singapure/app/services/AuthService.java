package com.singapure.app.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.singapure.app.dto.AuthenticationToken;
import com.singapure.app.models.User;
import com.singapure.app.repo.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class AuthService {
	
	@Autowired	
	private UserRepository userRepository;
	
	private static final long EXPIRATION_SECONDS = 6000;
	private static final String SECURITY_KEY = "!@asdsadJAS780";
	
	public User auth(User user) throws Exception{
		User userBD = userRepository.getUserByEmailAndPwd(user.getEmail(), user.getPassword());
		if(userBD != null) {
			
			AuthenticationToken tok = generate(userBD.getEmail(), userBD.getId()+"");
			userBD.setToken(tok.getToken());
			userBD.setPassword(null);
			userBD.setId(null);
		}
		return userBD;
	}
	
	public User createUser(User user) throws Exception{
		User userBD = userRepository.save(user);
		return userBD;
	}
	
	public User getUser(User user) throws Exception{
		User userBD = userRepository.findByEmail(user.getEmail());
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
