package com.desafio.crud.services;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.desafio.crud.dto.ClientDTO;
import com.desafio.crud.entities.Client;
import com.desafio.crud.repositories.ClientRepository;
import com.desafio.crud.services.exceptions.ResourceNotFoundException;

/*
 *  Does not load context, but allows using Spring features with JUnit
 *  Unitary test: service/component
 *  
 * */
@ExtendWith(SpringExtension.class)
public class ClientServiceTests {

	private Long existingId;
	private Long nonExistingId;
	private Client client;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 60L;

		client = new Client(existingId, "Alice", "05944853", 4000.0, Instant.now(), 0);

		when(repository.findById(existingId)).thenReturn(Optional.of(client));

	}

	@Mock
	private ClientRepository repository;

	@InjectMocks
	private ClientService service;

	@Test
	public void findByIdShouldReturnClientDTOWhenIdExists() {
		ClientDTO dto = service.findById(existingId);

		Assertions.assertNotNull(dto);

		verify(repository, times(1)).findById(existingId);
	}
	
	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
		});
		
		verify(repository, times(1)).findById(nonExistingId);
	}

}
