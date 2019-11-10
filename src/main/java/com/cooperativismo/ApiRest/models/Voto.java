package com.cooperativismo.ApiRest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotNull(message = "Campo associado é obrigatório ")
	private Long associado_id;
	
	@NotNull(message = "Campo pauta é obrigatório")
	private Long pauta_id;
	
	@NotNull(message = "Voto não pode ser nulo")
	private Boolean voto;

	public Voto() {}

	public Long getAssociado_id() {
		return associado_id;
	}

	public void setAssociado_id(Long associado_id) {
		this.associado_id = associado_id;
	}

	public Long getPauta_id() {
		return pauta_id;
	}

	public void setPauta_id(Long pauta_id) {
		this.pauta_id = pauta_id;
	}

	public Boolean getVoto() {
		return voto;
	}

	public void Boolean(Boolean voto) {
		this.voto = voto;
	}
	
}
