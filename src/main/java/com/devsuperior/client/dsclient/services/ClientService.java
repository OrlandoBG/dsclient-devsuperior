package com.devsuperior.client.dsclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.client.dsclient.dto.ClientDTO;
import com.devsuperior.client.dsclient.entities.Client;
import com.devsuperior.client.dsclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));
		
		
	}
	
	
	

}
