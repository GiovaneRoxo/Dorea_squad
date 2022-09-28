package model;

public class Projetos {

	private int id_projeto;
	private String nome;
	private Double objetivo;
	private Double arrecadado;
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
