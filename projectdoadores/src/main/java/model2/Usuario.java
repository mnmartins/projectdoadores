package model2;
// Generated 07/06/2020 20:37:23 by Hibernate Tools 5.4.3.Final

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private int id;
	private String login;
	private String senha;
	private String roleUser;

	public Usuario() {
	}

	public Usuario(int id) {
		this.id = id;
	}

	public Usuario(int id, String login, String senha, String roleUser) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.roleUser = roleUser;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

}
