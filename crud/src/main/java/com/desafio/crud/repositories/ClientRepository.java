package com.desafio.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.crud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
