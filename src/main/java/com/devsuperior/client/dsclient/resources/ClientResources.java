package com.devsuperior.client.dsclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.client.dsclient.dto.ClientDTO;
import com.devsuperior.client.dsclient.services.ClientService;

@RestController
public class ClientResources {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping(value = "/clients")
	
	public ResponseEntity<Page<ClientDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			 ){
		
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
		Page<ClientDTO> dto = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(dto);
		
		
	}

}
