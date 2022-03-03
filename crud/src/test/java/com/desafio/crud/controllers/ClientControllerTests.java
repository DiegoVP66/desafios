package com.desafio.crud.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.desafio.crud.services.exceptions.ResourceNotFoundException;
import com.desafio.crud.tests.ClientFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Autowired
	private ObjectMapper objectMapper;

	private Long existingId;
	private Long nonExistingId;

	@BeforeEach
	void setUp() throws Exception {

		existingId = 1L;
		nonExistingId = 50L;

		page = new PageImpl<>(List.of(clientDTO));

		when(service.findAllPaged(any())).thenReturn(page);
		when(service.findById(existingId)).thenReturn(clientDTO);
		when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		when(service.update(any(), eq(existingId))).thenReturn(clientDTO);
		when(service.update(any(), eq(nonExistingId))).thenThrow(ResourceNotFoundException.class);
		when(service.insert(any())).thenReturn(clientDTO);

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

	@Test
	public void findByIdShouldReturnResourceNotFoundExceptionWhenIdDoesNotExist() throws Exception {
		ResultActions result = mockMvc.perform(get("/clients/{id}", nonExistingId).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}

	@Test
	public void updateShouldReturnClientDTOWhenIdExists() throws Exception {

		String jsonBody = objectMapper.writeValueAsString(clientDTO);

		ResultActions result = mockMvc.perform(put("/clients/{id}", existingId).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.name").exists());
		result.andExpect(jsonPath("$.cpf").exists());
		result.andExpect(jsonPath("$.income").exists());
		result.andExpect(jsonPath("$.birthDate").exists());
		result.andExpect(jsonPath("$.children").exists());
	}

	@Test
	public void updateShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(clientDTO);

		ResultActions result = mockMvc.perform(put("/clients/{id}", nonExistingId).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}

	@Test
	public void insertShouldReturnCreatedObjAndClientDTO() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(clientDTO);

		ResultActions result = mockMvc.perform(post("/clients").content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isCreated());
	}

	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {

		ResultActions result = mockMvc.perform(delete("/clients/{id}", existingId).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNoContent());
	}

}
