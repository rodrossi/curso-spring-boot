package br.com.babypet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.babypet.domain.Cliente;
import br.com.babypet.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("clientes")
	public ResponseEntity<?> inserir() {
		
		Cliente cliente = clienteService.incluir("Rodrigo Rossi", "318129898-06", "rodrigoormonde@gmail.com");
		
		return ResponseEntity.ok(cliente);
		
	}

}
