package com.cooperativismo.ApiRest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
public class Pauta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo título é obrigatório")
	@NotBlank(message = "Campo título não pode estar vazio")	
	private String titulo;
	
	@NotEmpty(message = "Campo tempo é obrigatório")
	@NotBlank(message = "Campo tempo não pode estar vazio")
	@Min(value=1, message="Valor do campo tempo deve ser igual ou maior que 1")  	
	private Integer tempo;
	
	private Date data_inicio;
		
	private Boolean resultado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

}
