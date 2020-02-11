package br.com.babypet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.babypet.domain.Cliente;
import br.com.babypet.dtos.comannds.AnimalPetInsertCommand;
import br.com.babypet.dtos.comannds.ClienteInsertCommand;
import br.com.babypet.dtos.comannds.ClienteUpDateCommand;
import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.exceptions.NotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente incluir(ClienteInsertCommand command) {
		Cliente cliente = Cliente.criar(command);
		
		return clienteRepository.save(cliente);
		
	}
	
	public Page<Cliente> listar(Pageable pageable){
		
		return clienteRepository.findAll(pageable);
	}
	
	public List<Cliente> filtrar (String nome, String email){
		if(email == null) {
			return clienteRepository.findByNomeContainsIgnoreCase(nome);
		}else {
			return clienteRepository.findByArgumentos(nome, email);
		}
		
	}
	
	public Cliente consultar (String id) {
		
		return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public Cliente alterar (String id, ClienteUpDateCommand command) {
		Cliente cliente = consultar(id);
		cliente.editar(command);
		return clienteRepository.save(cliente);
	}
	
	public void excluir (String id) {
		Cliente cliente = consultar(id);
		clienteRepository.delete(cliente);
	}
	
	public void adicionarAnimal(AnimalPetInsertCommand command) {
		Cliente cliente = consultar(command.getIdCliente());
		cliente.adicionarAnimal(command);
		clienteRepository.save(cliente);
	}

}
