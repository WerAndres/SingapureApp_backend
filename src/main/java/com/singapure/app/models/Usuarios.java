package com.singapure.app.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity    
@Table(name = "usuarios", schema = "prin") 
@JsonInclude(Include.NON_NULL)	
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usu")
	private Long idUsuario;
	
	@ManyToOne
    @JoinColumn(name = "tipo_usu")
    private TiposUsuarios tipoUsuario;
	
	@Column(name="fecha_crea")
	private Date fechaCreacion;
	
	@Column(name="fecha_act")
	private Date fechaActualizacion;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="photo")
	public String photo;
	
	@Transient
	private String token;
	
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
    

}