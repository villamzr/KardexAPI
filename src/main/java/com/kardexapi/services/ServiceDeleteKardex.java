package com.kardexapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kardexapi.dto.KardexMainDelete;
import com.kardexapi.utils.GenericRestTemplate;

@Service
public class ServiceDeleteKardex {
	private static final Logger log = LoggerFactory.getLogger(ServiceGetAllKardex.class);
	private RestTemplate restTemplate;
	private ResponseEntity<KardexMainDelete> restTemplateResult;
	
	public RestTemplate consume(String url) {
		log.info("ingresando al método consume() de la clase ServiceDeleteKardex");
		try {
			restTemplate = GenericRestTemplate.restTemplate();
			setRestTemplateResult(restTemplate.exchange(url,HttpMethod.DELETE, null, KardexMainDelete.class)); 
		} catch (Exception e) {
			log.error("Ha ocurrido un error al consumir el servicio del endpoint "+url);
		}
		return restTemplate;
	}

	public ResponseEntity<KardexMainDelete> getRestTemplateResult() {
		return restTemplateResult;
	}

	public void setRestTemplateResult(ResponseEntity<KardexMainDelete> restTemplateResult) {
		this.restTemplateResult = restTemplateResult;
	}
}
