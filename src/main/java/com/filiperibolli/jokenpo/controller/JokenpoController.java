package com.filiperibolli.jokenpo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filiperibolli.jokenpo.dto.input.JokenpoInputDto;
import com.filiperibolli.jokenpo.model.JokenpoAct;
import com.filiperibolli.jokenpo.service.JokenpoService;
import com.filiperibolli.jokenpo.util.JokenpoCalculator;


@RestController
@RequestMapping("/api/v1")
public class JokenpoController {
	
	@Autowired
	private JokenpoService jokenpoService;
	
	@GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
	public String health() {
		if(jokenpoService.servidorOpen()) {
			return "Im healthy :)";
		}else {
			return "Im not ok :(";
		}
	}
	
	@PostMapping(value = "/playJokenpo", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> playJokenpo(@RequestBody @Valid JokenpoInputDto newJokenpoInputDto) {

		Optional<JokenpoAct> jokenpoOutputDto = JokenpoCalculator.calculateJokenpoWinner(newJokenpoInputDto);

		if(jokenpoOutputDto.isEmpty()) {
			return ResponseEntity.ok().body(" Empate.");
		}else {
			return ResponseEntity.ok().body(jokenpoOutputDto.get().getPlayerId() + " Vitoria.");
		}
        
	}
	
	@GetMapping(path = {"/findPlayer/{id}"})
	public ResponseEntity<?> findById(@PathVariable String id){
	   return jokenpoService.findById(id)
	           .map(player -> ResponseEntity.ok().body(player.getPlayerId()))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String create(@RequestBody String player){
	   return jokenpoService.save(player);
	}

	@DeleteMapping(path ={"/deletePlayer/{id}"})
	public ResponseEntity<?> delete(@PathVariable String id) {
	   return jokenpoService.findById(id)
	           .map(record -> {
	        	   jokenpoService.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
