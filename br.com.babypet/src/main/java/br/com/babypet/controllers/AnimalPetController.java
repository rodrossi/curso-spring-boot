package br.com.babypet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.babypet.dtos.comannds.AnimalPetInsertCommand;
import br.com.babypet.services.AnimalPetService;
import br.com.babypet.services.ClienteService;

@RestController
@RequestMapping("animais")
public class AnimalPetController {
	@Autowired
	private AnimalPetService animalPetService;
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<?> inserir (@RequestBody AnimalPetInsertCommand command){
			
		clienteService.adicionarAnimal(command);
			
			return ResponseEntity.ok().build();
			
		}
	}

