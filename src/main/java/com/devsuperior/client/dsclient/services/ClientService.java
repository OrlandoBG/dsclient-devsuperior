package com.devsuperior.client.dsclient.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.client.dsclient.dto.ClientDTO;
import com.devsuperior.client.dsclient.entities.Client;
import com.devsuperior.client.dsclient.repositories.ClientRepository;
import com.devsuperior.client.dsclient.services.exception.ResourceNotFound;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));	
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFound("Entity not found"));
		return new ClientDTO(client);	
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		copyClientDTOToClient(client,dto);
		
		repository.save(client);
		
		return new ClientDTO(client);
		
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		Client client = repository.getOne(id);
		
		copyClientDTOToClient(client,dto);
		
		repository.save(client);
		
		return new ClientDTO(client);
	}

	public Void delete(Long id) {
		repository.deleteById(id);
		return null;
	}
	
	public void copyClientDTOToClient(Client client,ClientDTO dto) {
		client.setName(dto.getName());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		
	}
	
	

	
	

}
