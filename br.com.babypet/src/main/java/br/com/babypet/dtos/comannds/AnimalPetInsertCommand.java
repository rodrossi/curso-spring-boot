package br.com.babypet.dtos.comannds;

import javax.validation.constraints.NotBlank;

import br.com.babypet.utils.validators.CommandValidator;
import lombok.Getter;

@Getter
public class AnimalPetInsertCommand {
 
	@NotBlank
	private String idCliente;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String especie;
	
	public void validate() {
		
		CommandValidator<AnimalPetInsertCommand> validator = new CommandValidator<>();
		
		validator.validate(this);
	}
}
