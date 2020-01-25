package br.com.babypet.dtos.comannds;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.babypet.utils.validators.CommandValidator;
import br.com.babypet.validators.CpfMustBeUnique;
import br.com.babypet.validators.CpfMustBeValid;

public class ClienteInsertCommand {
	
	@NotBlank(message = "Nome deve ser informado")
	@Size(min = 3, max = 50, message = "Tamanho Maximo deve ser entre 3 e 50")
	private String nome;
	
	
	@NotBlank(message = "Cpf deve ser informado")
	@CpfMustBeValid(message = "Cpf deve ser valido")
	@CpfMustBeUnique(message = "Cpf já cadastrado")
	private String cpf;
	
	@NotBlank(message = "Email deve ser informado")
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void validate() {
		
		CommandValidator<ClienteInsertCommand> commandValidator = new CommandValidator<>();
		
		commandValidator.validate(this);
	}

}
