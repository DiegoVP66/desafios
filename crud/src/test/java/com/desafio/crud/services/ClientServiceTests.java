package com.desafio.crud.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	private ClientDTO clientDTO;

	private PageImpl<Client> page;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 60L;

		client = new Client(existingId, "Alice", "05944853", 4000.0, Instant.now(), 0);
		clientDTO = new ClientDTO(client);
		page = new PageImpl<>(List.of(client));

		when(repository.findById(existingId)).thenReturn(Optional.of(client));
		when(repository.findAll((Pageable) any())).thenReturn(page);
		when(repository.save(any())).thenReturn(client);
		when(repository.getById(existingId)).thenReturn(client);
		when(repository.getById(nonExistingId)).thenThrow(EntityNotFoundException.class);

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

	@Test
	public void findAllPagedShouldReturnPage() {

		Pageable pageable = PageRequest.of(0, 5);

		Page<ClientDTO> result = service.findAllPaged(pageable);

		Assertions.assertNotNull(result);
		verify(repository, times(1)).findAll(pageable);
	}

	@Test
	public void insertShouldReturnClientDTO() {
		ClientDTO dto = service.insert(clientDTO);
		Assertions.assertNotNull(dto);
	}

	@Test
	public void updateShouldReturnClientDTOWhenIdExists() {
		ClientDTO dto = service.update(clientDTO, existingId);

		Assertions.assertNotNull(dto);
	}

	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(clientDTO, nonExistingId);
		});
	}

}
