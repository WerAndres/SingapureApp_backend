package com.singapure.app.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "users", schema = "prin") 
@JsonInclude(Include.NON_NULL)	
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prin.user_id_seq")
    @SequenceGenerator(name="prin.user_id_seq", sequenceName="prin.user_id_seq", allocationSize=1)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Transient
	private String token;
	
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
    

}