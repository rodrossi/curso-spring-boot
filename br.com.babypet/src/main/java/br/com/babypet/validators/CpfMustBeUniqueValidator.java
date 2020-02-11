package br.com.babypet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.babypet.repositories.ClienteRepository;

public class CpfMustBeUniqueValidator implements ConstraintValidator<CpfMustBeUnique, String> {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {

		return !clienteRepository.existsByCpf(cpf);
	}
	
	

}
