package com.desafio.crud.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.crud.dto.ClientDTO;
import com.desafio.crud.entities.Client;
import com.desafio.crud.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());

	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable){
		Page<Client> page = repository.findAll(pageable);
		return page.map(x -> new ClientDTO(x));
	}
}
