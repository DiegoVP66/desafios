package com.desafio.crud.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ClientControllerIT {

	@Autowired
	private MockMvc mockMvc;

	private Long countTotalClients;

	@BeforeEach
	void setUp() {
		countTotalClients = 25L;
	}

	@Test
	public void findAllPagedShouldReturnSortedPageWhenSortByName() throws Exception {
		ResultActions result = mockMvc
				.perform(get("/clients/pages?page=0&size=3&sort=name,asc").accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.totalElements").value(countTotalClients));
		result.andExpect(jsonPath("$.content").exists());
		result.andExpect(jsonPath("$.content[0].name").value("Alan Broke"));
		result.andExpect(jsonPath("$.content[1].name").value("Albert Tesla"));
		result.andExpect(jsonPath("$.content[2].name").value("Alice Beauty"));
	}
}
