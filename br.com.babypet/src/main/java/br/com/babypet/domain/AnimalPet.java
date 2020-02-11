package br.com.babypet.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.babypet.dtos.comannds.AnimalPetInsertCommand;
import lombok.Getter;

@Document(collection = "animal_pet")
@Getter
public class AnimalPet {
	
	@Id
	private String id;
	private String nome;
	private String especie;
	
	protected AnimalPet() {
		
	}
	
	private AnimalPet(AnimalPetInsertCommand command) {
		this.id = UUID.randomUUID().toString();
		this.nome = command.getNome();
		this.especie = command.getEspecie();
	}
	
	public static AnimalPet criar(AnimalPetInsertCommand command) {
		command.validate();
		return new AnimalPet(command);
	}

}
