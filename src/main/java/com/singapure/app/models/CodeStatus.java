package com.singapure.app.models;

public class CodeStatus {
	//CODIGOS EXITOSOS INTERNOS
	public static Integer OK 						= 100;
	public static String OK_TEXT					= "OK";
	
	//CODIGOS NO EXITOSOS
	public static Integer ERROR_GENERIC		= 999;
	public static String ERROR_GENERIC_TEXT	= "Ups... algo ha fallado";
	
	public static Integer USERPASS_INCORRECT		= 998;
	public static String USERPASS_INCORRECT_TEXT	= "Usuario y contraseña errados";
	
	public static Integer USER_ALREADY_EXISTS 		= 997;
	public static String USER_ALREADY_EXISTS_TEXT	= "Usuario ya existe";
	
	public static Integer LIST_COURSE_EMPTY 		= 996;
	public static String LIST_COURSE_EMPTY_TEXT	= "Lista de cursos vacia";
	
	//CODIGOS EXITOSOS HTTP
	public static Integer HTTP_OK 					= 200;
	public static Integer HTTP_CREATED				= 202;
	
	
	//CODIGOS NO EXITOSOS
	public static Integer HTTP_BAD_REQUEST			= 400;
	public static Integer HTTP_UNAUTHORIZED 		= 401;
	public static Integer HTTP_NOT_FOUND 			= 404;
	public static Integer HTTP_CONFLICT 			= 409;
	
	public static Integer HTTP_INTERNAL_SERVER_ERROR= 500;
	
}
