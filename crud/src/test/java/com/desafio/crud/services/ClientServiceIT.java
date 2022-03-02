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

	@BeforeEach
	void setUp() throws Exception {

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

}
