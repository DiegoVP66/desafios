package com.desafio.crud.tests;

import java.time.Instant;

import com.desafio.crud.dto.ClientDTO;
import com.desafio.crud.entities.Client;

public class ClientFactory {

	public static Client createClient() {
		Client client = new Client(1L, "Alice", "059448752", 5000.0, Instant.now(), 0);
		return client;
	}

	public static ClientDTO createClientDTO() {
		Client client = createClient();
		return new ClientDTO(client);
	}

}
