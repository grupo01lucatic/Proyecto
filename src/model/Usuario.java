package model;

import java.io.Serializable;

/**
 * Clase usuario que tiene como parametros los campos que tiene la tabla
 * usuarios de la BD
 *
 */
public class Usuario implements Serializable {
	private String username, mail;

	public Usuario() {
		super();
	}

	public Usuario(String username, String mail) {
		super();
		this.username = username;
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", mail=" + mail + "]";
	}

}
