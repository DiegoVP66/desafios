package com.desafio.crud.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.desafio.crud.entities.Client;

@DataJpaTest
public class ClientRepositoryTests {

	@Autowired
	private ClientRepository repository;

	private Long existingId;
	private Long nonExistingId;
	private Long countTotalClients;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 30L;
		countTotalClients = 25L;
	}

	@Test
	public void findByIdShouldReturnOptionalNotEmptyWhenIdExists() {

		Optional<Client> result = repository.findById(existingId);

		Assertions.assertTrue(!result.isEmpty());
		Assertions.assertTrue(result != null);
	}

}
