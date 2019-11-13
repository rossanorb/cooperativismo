package com.cooperativismo.ApiRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativismo.ApiRest.models.Associado;
import com.cooperativismo.ApiRest.repository.AssociadoRepository;

@Service
public class AssociadoServiceImpl implements AssociadoService{

	@Autowired
	private AssociadoRepository associadoRepository;
	
	public AssociadoServiceImpl(AssociadoRepository asssociadoRepository) {
		this.associadoRepository = asssociadoRepository;
	}
	
	@Override
	public List<Associado> findAll() { 
		return this.associadoRepository.findAll();
	}

	@Override
	public Associado create(Associado associado) { 
		this.associadoRepository.save(associado);
		return associado;
	}

	@Override
	public Boolean ExistsCpf(String cpf) {
		Associado associado = this.associadoRepository.findByCpf(cpf);
		
		if( associado instanceof Associado  ) {
			return true;
		}
				
		return false;
	}

}
