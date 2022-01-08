package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
public class UfDTO {
	private Integer id;
	private String sigla;
	private String nome;
}
