package com.desafio.crud.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.crud.dto.ClientDTO;
import com.desafio.crud.repositories.ClientRepository;

/*
 * Load application context
 * Integration test
 * 
 * */

@SpringBootTest
@Transactional
public class ClientServiceIT {

	@Autowired
	private ClientService service;

	@Autowired
	private ClientRepository repository;

	private Long countTotalClients;
	private Long existingId;

	@BeforeEach
	void setUp() throws Exception {
		countTotalClients = 25L;
		existingId = 1L;
	}

	@Test
	public void findAllPagedShouldReturnPageWhenPageZeroSizeTen() {
		PageRequest pageRequest = PageRequest.of(0, 10);

		Page<ClientDTO> result = service.findAllPaged(pageRequest);

		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals(0, result.getNumber());
		Assertions.assertEquals(10, result.getSize());
		Assertions.assertEquals(countTotalClients, result.getTotalElements());
	}

	@Test
	public void findAllPagedShouldReturnEmptyWhenPageDoesNotExist() {
		PageRequest pageRequest = PageRequest.of(100, 20);

		Page<ClientDTO> result = service.findAllPaged(pageRequest);

		Assertions.assertTrue(result.isEmpty());
	}

	@Test
	public void findAllPagedShouldReturnSortedPageWhenSortByName() {
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));

		Page<ClientDTO> result = service.findAllPaged(pageRequest);

		Assertions.assertFalse(result.isEmpty());
		Assertions.assertEquals("Alan Broke", result.getContent().get(0).getName());
		Assertions.assertEquals("Albert Tesla", result.getContent().get(1).getName());
		Assertions.assertEquals("Alice Beauty", result.getContent().get(2).getName());
	}

	@Test
	public void deleteShouldDeleteResourceWhenIdExists() {

		service.delete(existingId);

		Assertions.assertEquals(countTotalClients - 1, repository.count());
	}

}
