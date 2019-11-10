package com.cooperativismo.ApiRest.resources.v1;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativismo.ApiRest.models.Voto;
import com.cooperativismo.ApiRest.services.VotoService;

@RestController
@RequestMapping("/v1/votos")
public class VotoResource {
	
	@Autowired
	private VotoService votoService;
	
	public VotoResource(VotoService votoService)
	{
		this.votoService = votoService;
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Voto voto, Errors errors) {
		if(!errors.hasErrors()) {
			Voto votoCreated = this.votoService.create(voto);
			return new ResponseEntity<Voto>(votoCreated, HttpStatus.CREATED);
			
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
						.collect(Collectors.joining("\n")));			
	}	
	
	
}
