package com.cooperativismo.ApiRest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String nome;

	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Associado() {
	}

	public Associado(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "{id: " + this.id + ",name: " + this.nome + ", cpf: " + this.cpf + "}";
	}

}
