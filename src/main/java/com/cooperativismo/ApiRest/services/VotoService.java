package com.cooperativismo.ApiRest.services;


import com.cooperativismo.ApiRest.models.Voto;

public interface VotoService {
	public Voto create(Voto voto);
	public Voto find(Long id);	
	public Boolean jaVotou(Voto voto);
}
