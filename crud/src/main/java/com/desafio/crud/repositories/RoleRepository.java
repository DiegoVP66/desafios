package com.desafio.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.crud.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
