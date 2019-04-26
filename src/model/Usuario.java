package model;

/**
 * 
 * @author grupo01
 * @param Clase usuario que tiene como parámetros los campos que tiene la tabla
 *              usuarios de la BD
 *
 */
public class Usuario {
	private String username, mail;
	private int password;

	public Usuario() {
		super();
	}

	public Usuario(String username, String mail, int password) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
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

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", mail=" + mail + ", password=" + password + "]";
	}

}
