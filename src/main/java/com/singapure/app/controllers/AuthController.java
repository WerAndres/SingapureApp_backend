package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.CodeStatus;
import com.singapure.app.models.Usuarios;
import com.singapure.app.services.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	AuthService authService;

	@PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody Usuarios user) throws Exception {
    	Usuarios userRes = authService.auth(user);
    	if(userRes != null) {    		
    		return GenericResponse.ok(userRes);
    	}else {    		
    		return GenericResponse.generic(CodeStatus.HTTP_UNAUTHORIZED, CodeStatus.USERPASS_INCORRECT, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED + "", CodeStatus.USERPASS_INCORRECT_TEXT);
    	}
    }
	
	@PostMapping("/auth/create")
    public ResponseEntity<?> create(@RequestBody Usuarios user) throws Exception {
		Usuarios userRes = authService.getUser(user);
		if(userRes == null) {
	    	userRes = authService.createUser(user);
	    	if(userRes != null) {	
	    		userRes.setIdUsuario(null);
	    		userRes.setPassword(null);
	    		return GenericResponse.ok(userRes);	    		
	    	}else {
	    		return GenericResponse.generic(CodeStatus.HTTP_INTERNAL_SERVER_ERROR, CodeStatus.ERROR_GENERIC, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR + "", CodeStatus.ERROR_GENERIC_TEXT);
	    	}
		}else {
			return GenericResponse.generic(CodeStatus.HTTP_CONFLICT, CodeStatus.USER_ALREADY_EXISTS, HttpStatus.CONFLICT, HttpStatus.CONFLICT + "", CodeStatus.USER_ALREADY_EXISTS_TEXT);    		
    	}
    }
}