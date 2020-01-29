package com.kardexapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kardexapi.dto.KardexMainById;
import com.kardexapi.utils.GenericRestTemplate;

public class ServiceGetByIdKardex {
	private static final Logger log = LoggerFactory.getLogger(ServiceGetAllKardex.class);
	private RestTemplate restTemplate;
	private ResponseEntity<KardexMainById> restTemplateResult;

	@Autowired
	KardexMainById kardexMainById;
	
	public RestTemplate consume(String url) {
		log.info("ingresando al método consume() de la clase ServiceGetAllKardex");
		try {
			restTemplate = GenericRestTemplate.restTemplate();
			setRestTemplateResult(restTemplate.getForEntity(url, KardexMainById.class));
			log.info(getRestTemplateResult().getBody().getKardexInfo().getObject());
		} catch (Exception e) {
			log.error("Ha ocurrido un error al consumir el servicio del endpoint http://localhost:8090/kardex/id");
		}
		return restTemplate;
	}

	public ResponseEntity<KardexMainById> getRestTemplateResult() {
		return restTemplateResult;
	}

	public void setRestTemplateResult(ResponseEntity<KardexMainById> responseEntity) {
		this.restTemplateResult = responseEntity;
	}
}
