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
	@Column(name = "associado_id", nullable = false)
	private Long associadoId;
	
	@NotNull(message = "Campo pauta é obrigatório")
	@Column(name = "pauta_id", nullable = false)
	private Long pautaId;
	
	@NotNull(message = "Voto não pode ser nulo")
	private Boolean voto;

	public Voto() {}
	
	public Long getId()
	{
		return this.id;
	}

	public Long getAssociado_id() {
		return associadoId;
	}

	public void setAssociado_id(Long associado_id) {
		this.associadoId = associado_id;
	}

	public Long getPauta_id() {
		return pautaId;
	}

	public void setPauta_id(Long pauta_id) {
		this.pautaId = pauta_id;
	}

	public Boolean getVoto() {
		return voto;
	}

	public void Boolean(Boolean voto) {
		this.voto = voto;
	}
	
}
