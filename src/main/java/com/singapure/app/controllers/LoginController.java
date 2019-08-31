package com.singapure.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.singapure.app.dto.GenericResponse;
import com.singapure.app.models.User;
import com.singapure.app.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
    	User userRes = loginService.login(user);
    	if(userRes != null) {
    		GenericResponse<User> response = new GenericResponse<>();
    		return ResponseEntity.ok(response.ok(userRes));
    	}else {
    		return new ResponseEntity<>(new GenericResponse<>(HttpStatus.NOT_FOUND, "Usuario o contraseña errados", HttpStatus.NOT_FOUND.toString(), null), HttpStatus.NOT_FOUND);
    	}
    }
}