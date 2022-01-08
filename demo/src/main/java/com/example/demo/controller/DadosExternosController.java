package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CidadeDTO;
import com.example.demo.dto.UfDTO;
import com.example.demo.services.DadosExternosService;

@Controller
public class DadosExternosController {
	
	@Autowired
	private DadosExternosService dadosExternosService;
	
	@GetMapping("/dadosUF")
	@ResponseBody
	public List<UfDTO> carregarDadosUF() {
		return dadosExternosService.obterUF();
	}
	
	@GetMapping("/dadosCidade/{id}")
	@ResponseBody
	public List<CidadeDTO> carregarDadosCidade(@PathVariable Integer id) {
		return dadosExternosService.obterCidades(id);
	}
}
