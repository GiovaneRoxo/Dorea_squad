package model;

public class Projetos {

	private int id_projeto;
	private int fk_Organizador_Id_organizador;
	private String nome;
	private Double objetivo;
	private Double arrecadado;
	
	public int getFk_Organizador_Id_organizador() {
		return fk_Organizador_Id_organizador;
	}
	public void setFk_Organizador_Id_organizador(int fk_Organizador_Id_organizador) {
		this.fk_Organizador_Id_organizador = fk_Organizador_Id_organizador;
	}
	public int getId_projeto() {
		return id_projeto;
	}
	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Double objetivo) {
		this.objetivo = objetivo;
	}
	public Double getArrecadado() {
		return arrecadado;
	}
	public void setArrecadado(Double arrecadado) {
		this.arrecadado = arrecadado;
	}	
}
