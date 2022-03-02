package com.desafio.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.crud.dto.ClientDTO;
import com.desafio.crud.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> dto = service.findAll();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/pages")
	public ResponseEntity<Page<ClientDTO>> findAllPaged(Pageable pageable) {
		Page<ClientDTO> dto = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(dto);
	}
}
