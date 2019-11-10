package com.cooperativismo.ApiRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativismo.ApiRest.models.Pauta;
import com.cooperativismo.ApiRest.repository.PautaRepository;


@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	public PautaServiceImpl(PautaRepository pautaRepository) {
		this.pautaRepository = pautaRepository;
	}

	@Override
	public Pauta create(Pauta pauta) {
		this.pautaRepository.save(pauta);
		return pauta;
	}
		
	@Override
	public Pauta update(Long id, Pauta pauta) {
		Pauta pautaExists = this.pautaRepository.getOne(id);
		
		if(pautaExists != null) {			
			pauta.setId(pautaExists.getId());
			this.pautaRepository.save(pauta);
			return pauta;			
		}
		

		return pauta;
	}

	@Override
	public Pauta find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
