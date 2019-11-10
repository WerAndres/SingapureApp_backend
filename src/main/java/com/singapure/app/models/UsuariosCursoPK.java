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

	@Column(name="id_usu")
	private Long idUsu;

	@Column(name="id_curso")
	private Long idCurso;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosCursoPK)) {
			return false;
		}
		UsuariosCursoPK castOther = (UsuariosCursoPK)other;
		return 
			this.idUsu.equals(castOther.idUsu)
			&& this.idCurso.equals(castOther.idCurso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsu.hashCode();
		hash = hash * prime + this.idCurso.hashCode();
		
		return hash;
	}
}