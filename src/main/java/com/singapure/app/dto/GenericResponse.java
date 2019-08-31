package com.singapure.app.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.singapure.app.models.CodeStatus;

@JsonInclude(Include.NON_NULL)
public class GenericResponse<T> {
		
	public Integer codeStatus;
	public Integer internalCodeStatus;
	public HttpStatus status;
	public String message;
	public String error;
	public T bussinesData;
	
	public GenericResponse(Integer codeStatus, Integer internalCodeStatus, HttpStatus status, String message, String error, T bussinesData){
		this.bussinesData = bussinesData;
		this.internalCodeStatus = internalCodeStatus;
		this.codeStatus = codeStatus;
		this.status = status;
		this.message = message;
		this.error = error;
	} 
	
	public GenericResponse() {
		this(null, null, null, null, null , null);
	}
	
	@SuppressWarnings("rawtypes")
	public static ResponseEntity ok(Object bussinesData) {
		return new ResponseEntity<>(new GenericResponse<>(CodeStatus.HTTP_OK, CodeStatus.OK, HttpStatus.OK, CodeStatus.OK_TEXT, HttpStatus.OK.toString(), bussinesData), HttpStatus.OK);
	}
	@SuppressWarnings("rawtypes")
	public static ResponseEntity generic(Integer codeStatus, Integer internalCodeStatus, HttpStatus httpStatus, String message) {
		return new ResponseEntity<>(new GenericResponse<>(codeStatus, internalCodeStatus, httpStatus, message, httpStatus.toString(), null), httpStatus);
	}
	@SuppressWarnings("rawtypes")
	public static ResponseEntity generic(Integer codeStatus, Integer internalCodeStatus, HttpStatus httpStatus, String message, Object bussinesData) {
		return new ResponseEntity<>(new GenericResponse<>(codeStatus, internalCodeStatus, httpStatus, message, httpStatus.toString(), bussinesData), httpStatus);
	}
	
}
