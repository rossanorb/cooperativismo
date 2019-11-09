package com.cooperativismo.ApiRest.resources.v1;

import java.util.List;
import java.util.stream.Collectors;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativismo.ApiRest.models.Associado;
import com.cooperativismo.ApiRest.services.AssociadoService;


@RestController
@RequestMapping("/v1/associados")
public class AssociadoResource {
	
	
	@Autowired
	private AssociadoService associadoService; 
	
	public AssociadoResource(AssociadoService associadoService){
		this.associadoService = associadoService;
	}
	
	@GetMapping
	@ResponseBody
	public List<Associado> findAll(){
		return this.associadoService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody	
	public Associado find(@PathVariable(value = "id") Long id) {
		return null;
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Associado associado, Errors errors) {
		if(!errors.hasErrors()) {
			Associado associadoCreated = this.associadoService.create(associado);
			return new ResponseEntity<Associado>(associadoCreated, HttpStatus.CREATED);
		}
		
		return ResponseEntity
				.badRequest()
				.body(errors 
						.getAllErrors()
						.stream()
						.map(msg -> msg.getDefaultMessage())
						.collect(Collectors.joining("\n")));	
		
	}	
	
}
