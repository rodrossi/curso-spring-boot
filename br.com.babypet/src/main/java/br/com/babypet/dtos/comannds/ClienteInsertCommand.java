package br.com.babypet.dtos.comannds;

import javax.validation.constraints.NotBlank;

public class ClienteInsertCommand {
	
	@NotBlank(message = "Nome deve ser informado")
	private String nome;
	@NotBlank(message = "Cpf deve ser informado")
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

}
