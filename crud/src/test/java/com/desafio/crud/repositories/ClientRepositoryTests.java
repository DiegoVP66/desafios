package com.desafio.crud.repositories;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.desafio.crud.entities.Client;

/*
 * Loads only Spring Data JPA related components. 
 * Each test is transactional and rollback at the end.
 * Unitary test: repository
 */
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
	public void findAllShoudReturnClientListNotEmpty() {
		List<Client> result = repository.findAll();

		Assertions.assertTrue(!result.isEmpty());
	}

	@Test
	public void findByIdShouldReturnOptionalNotEmptyWhenIdExists() {

		Optional<Client> result = repository.findById(existingId);

		Assertions.assertTrue(!result.isEmpty());
		Assertions.assertTrue(result != null);
	}

	@Test
	public void findByIdShouldReturnOptionalWhenIdDoesNotExist() {
		Optional<Client> result = repository.findById(nonExistingId);

		Assertions.assertTrue(result.isEmpty());
		Assertions.assertFalse(result.isPresent());
	}

	@Test
	public void saveShouldPersistWhitAutoIncrementWhenIdIsNull() {
		Client client = new Client(null, "Alice", "05988734", 4000.0, Instant.now(), 0);

		client = repository.save(client);

		Assertions.assertNotNull(client.getId());
		Assertions.assertEquals(countTotalClients + 1, client.getId());
	}

	@Test
	public void deleteByIdShouldDeleteObjectWhenIdExists() {
		repository.deleteById(existingId);

		Optional<Client> result = repository.findById(existingId);

		Assertions.assertFalse(result.isPresent());
	}

	@Test
	public void deleteShouldThrowEmptyResultNotFoundExceptionWhenIdDoesNotExist() {
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}

}
