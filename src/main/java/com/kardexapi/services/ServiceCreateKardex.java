package com.kardexapi.services;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kardexapi.dto.KardexMainCreate;
import com.kardexapi.utils.GenericRestTemplate;

public class ServiceCreateKardex {
	private static final Logger log = LoggerFactory.getLogger(ServiceGetAllKardex.class);
	private RestTemplate restTemplate;
	private ResponseEntity<KardexMainCreate> restTemplateResult;
	
	public RestTemplate consume(String url, Map<String, String> map) {
		log.info("ingresando al método consume() de la clase ServiceCreateKardex");
		try {
			HttpEntity<Map<String, String>> request = new HttpEntity<>(map);
			restTemplate = GenericRestTemplate.restTemplate();
			setRestTemplateResult(restTemplate.postForEntity(url, request, KardexMainCreate.class));
		} catch (Exception e) {
			log.error("Ha ocurrido un error al consumir el servicio del endpoint http://localhost:8090/kardex");
		}
		return restTemplate;
	}

	public ResponseEntity<KardexMainCreate> getRestTemplateResult() {
		return restTemplateResult;
	}

	public void setRestTemplateResult(ResponseEntity<KardexMainCreate> restTemplateResult) {
		this.restTemplateResult = restTemplateResult;
	}
}
