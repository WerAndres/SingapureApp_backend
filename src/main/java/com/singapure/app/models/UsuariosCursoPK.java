package com.singapure.app.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class UsuariosCursoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario")
	private Long idUsuario;

	@Column(name="id_curso")
	private Long idCurso;
	
	@Column(name="id_materia")
	private Long idMateria;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosCursoPK)) {
			return false;
		}
		UsuariosCursoPK castOther = (UsuariosCursoPK)other;
		return 
			this.idUsuario.equals(castOther.idUsuario)
			&& this.idCurso.equals(castOther.idCurso)
			&& this.idCurso.equals(castOther.idMateria);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario.hashCode();
		hash = hash * prime + this.idCurso.hashCode();
		hash = hash * prime + this.idMateria.hashCode();
		
		return hash;
	}
}