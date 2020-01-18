package br.com.babypet.dtos.comannds;

import javax.validation.constraints.NotBlank;

public class ClienteUpDateCommand {

	@NotBlank(message = "Nome deve ser informado")
	private String nome;
	@NotBlank(message = "E-mail deve ser informado")
	private String email;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

}
