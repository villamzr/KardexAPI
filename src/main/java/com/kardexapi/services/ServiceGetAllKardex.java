package com.kardexapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kardexapi.dto.KardexMain;
import com.kardexapi.utils.GenericRestTemplate;

public class ServiceGetAllKardex {
	private static final Logger log = LoggerFactory.getLogger(ServiceGetAllKardex.class);
	private RestTemplate restTemplate;
	private ResponseEntity<KardexMain> restTemplateResult;

	public RestTemplate consume(String url) {
		log.info("ingresando al método consume() de la clase ServiceGetAllKardex");
		try {
			restTemplate = GenericRestTemplate.restTemplate();
			setRestTemplateResult(restTemplate.getForEntity(url, KardexMain.class));
		} catch (Exception e) {
			log.error("Ha ocurrido un error al consumir el servicio del endpoint http://localhost:8090/kardex");
		}
		return restTemplate;
	}

	public ResponseEntity<KardexMain> getRestTemplateResult() {
		return restTemplateResult;
	}

	public void setRestTemplateResult(ResponseEntity<KardexMain> restTemplateResult) {
		this.restTemplateResult = restTemplateResult;
	}
}
