package com.desafio.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.crud.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
