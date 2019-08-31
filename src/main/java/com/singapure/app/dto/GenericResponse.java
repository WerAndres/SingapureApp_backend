package com.singapure.app.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericResponse<T> {
	
	public HttpStatus status;
	public String message;
	public String error;
	public T bussinesData;
	
	public GenericResponse(HttpStatus status, String message, String error, T bussinesData){
		this.bussinesData = bussinesData;
		this.status = status;
		this.message = message;
		this.error = error;
	} 
	
	public GenericResponse() {
		this(null, null, null , null);
	}
	
	public GenericResponse<T> ok(T bussinesData) {
		this.status = HttpStatus.ACCEPTED;
		this.message = "OK";
		this.error = null;
		this.bussinesData = bussinesData;
		return this;
	}
}
