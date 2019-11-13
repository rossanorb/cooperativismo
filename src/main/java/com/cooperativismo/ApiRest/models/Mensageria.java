package com.cooperativismo.ApiRest.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Mensageria.class)
public class Mensageria {

	private String titulo;
	
	private Boolean resultado;

	private String email;
	
	private String nome;

	public String getTitulo() {
		return titulo;
	}
	
	

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
