package com.cooperativismo.ApiRest.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cooperativismo.ApiRest.models.Associado;
import com.cooperativismo.ApiRest.models.Pauta;
import com.cooperativismo.ApiRest.models.Voto;
import com.cooperativismo.ApiRest.repository.AssociadoRepository;
import com.cooperativismo.ApiRest.repository.PautaRepository;
import com.cooperativismo.ApiRest.repository.VotoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Calendar;
import java.util.Date;



@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	public PautaServiceImpl(
			PautaRepository pautaRepository,
			VotoRepository votoRepository,
			AssociadoRepository associadoRepository
	)
	{
		this.pautaRepository = pautaRepository;
		this.votoRepository = votoRepository;
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
	
	public String autorizaCFP(Long id)
	{
		Associado associado = this.associadoRepository.getOne(id);
		
		String acpf = associado.getCpf();
		String cpf = acpf.replace(".","").replace("-","");
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("https://user-info.herokuapp.com/users/{cpf}", String.class , cpf);	
				
		return result;
	}
	
	public void Contabiliza(Pauta pauta) {
		List<Voto> s = this.votoRepository.findByVotoAndPautaId( true, pauta.getId() );
		Integer total_sim = s.size();
		
		List<Voto> n = this.votoRepository.findByVotoAndPautaId( false, pauta.getId() );
		Integer total_nao = n.size();
		
		if(total_sim > total_nao ) {			
			pauta.setResultado(true);
		}else if(total_nao > total_sim){			
			pauta.setResultado(false);
		}else {
			pauta.setResultado(null);
		}
		
		this.update(pauta.getId(), pauta);
		
		this.mensageria(pauta);
		
	}
	
	private void mensageria(Pauta pauta)
	{
		List<Associado> associados = this.associadoRepository.findAll();
		
		associados.forEach(a ->{
			System.out.println(a.getNome() +" -> " + a.getEmail() );
		});
		
		
	}

}
