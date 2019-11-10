package com.cooperativismo.ApiRest.services;

import com.cooperativismo.ApiRest.models.Pauta;

public interface PautaService {
	
	public Pauta create(Pauta pauta);
	public Pauta find(Long id);
	public Pauta update(Long id, Pauta pauta);
}
