package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
public class CidadeDTO {
	private Integer id;
	private String nome;
}
