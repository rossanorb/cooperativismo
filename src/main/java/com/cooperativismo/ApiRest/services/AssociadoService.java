package com.cooperativismo.ApiRest.services;
import java.util.List;

import com.cooperativismo.ApiRest.models.Associado;

public interface AssociadoService {
	public List<Associado> findAll();	
	public Associado create(Associado associado);
}
