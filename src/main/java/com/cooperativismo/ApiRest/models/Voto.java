package com.cooperativismo.ApiRest.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotEmpty
	private Long associado_id;

	@NotBlank
	@NotEmpty
	private Long pauta_id;

	private boolean voto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssociadoId() {
		return this.associado_id;
	}

	public void setAssociadoId(Long associado_id) {
		this.associado_id = associado_id;
	}

	public Long getPautaId() {
		return this.associado_id;
	}

	public void setPautaId(Long pauta_id) {
		this.associado_id = pauta_id;
	}

	public boolean getVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}

}
