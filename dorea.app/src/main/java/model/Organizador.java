package model;

public class Organizador {
	
	private int id_organizador;
	private String nome;
	private String cnpj;
	private String email;
	private String telefone;
	private String senha;
	public int getId_organizador() {
		return id_organizador;
	}
	public void setId_organizador(int id_organizador) {
		this.id_organizador = id_organizador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
