package br.com.babypet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.babypet.domain.Cliente;
import br.com.babypet.dtos.comannds.ClienteInsertCommand;
import br.com.babypet.dtos.comannds.ClienteUpDateCommand;
import br.com.babypet.repositories.ClienteRepository;
import br.com.babypet.utils.NotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente incluir(ClienteInsertCommand command) {
		
		Cliente cliente = new Cliente(command);
		
		return clienteRepository.save(cliente);
		
	}
	
	public List<Cliente> listar(){
		
		return clienteRepository.findAll();
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

}
