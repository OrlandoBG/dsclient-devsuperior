package com.devsuperior.client.dsclient.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientResources {
	
	@RequestMapping(value = "/clients")
	
	public ResponseEntity findAll() {
		return null;
	}

}
