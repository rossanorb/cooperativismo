package com.cooperativismo.ApiRest.services;

import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooperativismo.ApiRest.models.Pauta;
import com.cooperativismo.ApiRest.repository.PautaRepository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

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
		return this.pautaRepository.getOne(id);
	}

	@Override
	public List<Pauta> findAll() {
		return this.pautaRepository.findAll();
	}
	
	public Boolean secaoBloqueada(Long id)
	{
		Pauta pauta = this.find(id);	
		
		if( pauta.getData_inicio() == null || pauta.getTempo() == null ) {
			System.out.println("Seção bloqueada");
			return true;
		}
					
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		
		Date date = new Date(pauta.getData_inicio().toGMTString() );
		calendar.setTime(date);		
		calendar.add(Calendar.MINUTE, pauta.getTempo());
		
        if (currentDate.after(calendar.getTime())) {
            System.out.println("Seção Encerrada");
            return true;
        }			
			
		return false;
	}

}
