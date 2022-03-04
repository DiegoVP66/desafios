package com.desafio.crud.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import com.desafio.crud.entities.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	
	@NotBlank(message = "Campo requerido!")
	private String name;
	
	@NotBlank(message = "Campo requerido!")
	private String cpf;
	
	@Positive(message = "A renda deve  ser um valor positivo!")
	private Double income;
	
	@Past(message ="A data nascimento não pode ser futura!")
	private Instant birthDate;
	private Integer children;

	public ClientDTO() {
	}

	public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

}
