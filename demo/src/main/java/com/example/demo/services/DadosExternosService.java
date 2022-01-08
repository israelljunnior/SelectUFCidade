package com.example.demo.services;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.CidadeDTO;
import com.example.demo.dto.UfDTO;

@Service
public class DadosExternosService {
	
	
	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(20);

    private final WebClient localApiClient;

    @Autowired
    public DadosExternosService(WebClient.Builder webClientBuilder) {
    	localApiClient = webClientBuilder.baseUrl("https://servicodados.ibge.gov.br/api/v1").build();
    }

   public List<UfDTO> obterUF() {
	   UfDTO[] lista =
	        localApiClient
                .get()
                .uri("/localidades/estados/")
                .retrieve()
                .bodyToMono(UfDTO[].class)
                .block(REQUEST_TIMEOUT);
	   
	   return Arrays.asList(lista);
   }
   
   public List<CidadeDTO> obterCidades(Integer id) {
	   CidadeDTO[] lista =
	        localApiClient
                .get()
                .uri("/localidades/estados/"+ id + "/distritos")
                .retrieve()
                .bodyToMono(CidadeDTO[].class)
                .block(REQUEST_TIMEOUT);
	   
	   return Arrays.asList(lista);
    }

}
