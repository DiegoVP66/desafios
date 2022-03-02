package com.desafio.crud.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.desafio.crud.dto.ClientDTO;
import com.desafio.crud.services.ClientService;
import com.desafio.crud.tests.ClientFactory;

/*
 *  Load application context (integration & web testing)
 *	Handles requests without uploading the server
 * 
 * */

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClientService service;

	private PageImpl<ClientDTO> page;

	private ClientDTO clientDTO = ClientFactory.createClientDTO();

	private Long existingId;

	@BeforeEach
	void setUp() throws Exception {

		existingId = 1L;

		page = new PageImpl<>(List.of(clientDTO));

		when(service.findAllPaged(any())).thenReturn(page);
		when(service.findById(existingId)).thenReturn(clientDTO);

	}

	@Test
	public void findAllPagedShouldReturnPage() throws Exception {
		ResultActions result = mockMvc.perform(get("/clients/pages").accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());

	}

	@Test
	public void findAllShouldReturnList() throws Exception {
		ResultActions result = mockMvc.perform(get("/clients").accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
	}

	@Test
	public void findByIdShouldReturnClientWhenIdExists() throws Exception {
		ResultActions result = mockMvc.perform(get("/clients/{id}", existingId).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.name").exists());
		result.andExpect(jsonPath("$.cpf").exists());
		result.andExpect(jsonPath("$.income").exists());
		result.andExpect(jsonPath("$.birthDate").exists());
		result.andExpect(jsonPath("$.children").exists());

	}

}
