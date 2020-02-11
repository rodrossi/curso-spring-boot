package br.com.babypet.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.babypet.dtos.comannds.AnimalPetInsertCommand;
import br.com.babypet.dtos.comannds.ClienteInsertCommand;
import br.com.babypet.dtos.comannds.ClienteUpDateCommand;
import lombok.Getter;

@Document(collection = "cliente")
@Getter

public class Cliente {

	@Id
	private String id;
	private String nome;
	private String cpf;
	private String email;
	@DBRef
	private List<AnimalPet> animais;
	
	protected Cliente() {
		
	}

	private Cliente(ClienteInsertCommand command) {

		this.nome = command.getNome();
		this.cpf = command.getCpf();
		this.email = command.getEmail();
	}
	
	public void editar (ClienteUpDateCommand command) {
		this.nome = command.getNome();
		this.email = command.getEmail();
	}
	
	public static Cliente criar(ClienteInsertCommand command) {
		command.validate();
		return new Cliente(command);
	}
	
	public void adicionarAnimal(AnimalPetInsertCommand command) {
		
		AnimalPet animalPet = AnimalPet.criar(command);
		if(animais == null) animais = new ArrayList<>();
		animais.add(animalPet);
		
	}
}
