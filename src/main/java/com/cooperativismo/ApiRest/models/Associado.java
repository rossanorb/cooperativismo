package com.cooperativismo.ApiRest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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

	@NotEmpty(message = "Campo nome é obrigatório")
	@NotBlank(message = "Campo nome não pode estar vazio")
	@Size(max = 45, message = "Campo título excedeu limite de 45 caracteres")
	@Column(length = 45, nullable = false)
	private String nome;
	
	@NotEmpty(message = "Campo cpf é obrigatório")
	@NotBlank(message = "Campo cpf não pode estar vazio")
	@CPF(message = "CPF é invalido")
	@Size(max = 20, message = "Campo cpf excedeu limite de 20 caracteres")
	@Column(length = 20, nullable = false)
	private String cpf;
	
	@Size(max = 40, message = "Campo email excedeu limite de 40 caracteres")
	@Email
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
