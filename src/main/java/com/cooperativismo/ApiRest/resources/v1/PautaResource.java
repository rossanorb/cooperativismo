package com.cooperativismo.ApiRest.resources.v1;

import java.util.stream.Collectors;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativismo.ApiRest.models.Pauta;
import com.cooperativismo.ApiRest.services.PautaService;

@RestController
@RequestMapping("/v1/pautas")
public class PautaResource {
	
	@Autowired
	private PautaService pautaService;
	
	public PautaResource(PautaService pautaService)
	{
		this.pautaService = pautaService;
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Pauta pauta, Errors errors) {
		if(!errors.hasErrors()) {
			Pauta pautaCreated = this.pautaService.create(pauta);
			return new ResponseEntity<Pauta>(pautaCreated, HttpStatus.CREATED);
		}
		
		return this.getErrors(errors);
				
				
	}
	
	@PutMapping( value = "/{id}" )
	@ResponseBody	
	public ResponseEntity<?> update( @PathVariable( value="id" ) Long id, @Valid @RequestBody Pauta pauta, Errors errors ) {
		if (!errors.hasErrors()) {
			Pauta pautaUpdated = this.pautaService.update(id, pauta);			
			return new ResponseEntity<Pauta>(pautaUpdated, HttpStatus.OK);
		}
		
		return this.getErrors(errors);
	
	}
	
	private ResponseEntity<?> getErrors(Errors errors) {
		return ResponseEntity
				.badRequest()
				.body(errors
						.getAllErrors()
						.stream()
						.map(msg -> msg.getDefaultMessage())
						.collect(Collectors.joining(",")));			
	}
	

}
