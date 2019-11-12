package com.cooperativismo.ApiRest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
public class Pauta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo título é obrigatório")
	@NotBlank(message = "Campo título não pode estar vazio")
	@Size(max = 45, message = "Campo título excedeu limite de caracteres")
	@Column(length = 45, nullable = false)
	private String titulo;
	
	@Min(1)
	private Integer tempo;	
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date data_inicio;
		
	private Boolean resultado;
	
	public Pauta() {}
	
    @PrePersist
    public void onPrePesist() {
    	
    	if (this.tempo == null) {
    		this.tempo = 1;
    	}
    	
//    	if (this.data_inicio == null) {
//    		this.data_inicio = new Date();
//    	}
    }
	
	public Long getId() {
		return this.id;
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
