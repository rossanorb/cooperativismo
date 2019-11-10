package com.cooperativismo.ApiRest.services;

import java.util.List;


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

	@Override
	public Voto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public Boolean jaVotou(Voto voto) {
		
		List<Voto> votos = this.votoRepository.findByPautaIdAndAssociadoId( voto.getPauta_id(),  voto.getAssociado_id() );
		
		if( votos.isEmpty() ) {
			System.out.println("Não votou:  " + votos.size() );
			return false;
		}		
		
		System.out.println("Já votou:  " + votos.size() );
			return true;
		
	}

}
