package com.cooperativismo.ApiRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativismo.ApiRest.models.Voto;
import com.cooperativismo.ApiRest.repository.VotoRepository;

@Service
public class VotoServiceImpl implements VotoService {
	
	@Autowired
	private VotoRepository votoRepository;
	
	public VotoServiceImpl(VotoRepository votoRepository) {
		this.votoRepository = votoRepository;
	}

	@Override
	public Voto create(Voto voto) {
		this.votoRepository.save(voto);
		return voto;
	}

}
