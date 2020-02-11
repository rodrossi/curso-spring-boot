package br.com.babypet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.babypet.repositories.AnimalPetRepository;

@Service
public class AnimalPetService {
	@Autowired
	private AnimalPetRepository animalPetRepository;
	
	//public AnimalPet incluir (AnimalPetInsertCommand command) {
	//	AnimalPet animalPet = AnimalPet.criar(command);
	//	return animalPetRepository.save(animalPet);
	//}
}
