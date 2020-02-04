package com.kardexapi.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kardexapi.dto.KardexMain;
import com.kardexapi.utils.GenericRestTemplate;

@Service
public class ServiceGetAllKardex
{
	private static final Logger log = LoggerFactory.getLogger(ServiceGetAllKardex.class);
	private RestTemplate restTemplate;
	private KardexMain KardexMain;
	private ResponseEntity<KardexMain> restTemplateResult;
	private ResponseEntity<Map<String, Object>> response;
	private Map<String, Object> stringAndObjectMap = new HashMap<>();
	private Map<String, Object> stringAndAllObjectMap = new HashMap<>();
	private Map<String, Object> stringAndString = new HashMap<>();

	public ResponseEntity<Map<String, Object>> consume(String url)
	{
		log.info("ingresando al método consume() de la clase ServiceGetAllKardex");
		try
		{
			restTemplate = GenericRestTemplate.restTemplate();
			restTemplateResult = restTemplate.getForEntity(url, KardexMain.class);
			KardexMain = restTemplateResult.getBody();
			stringAndString.clear();
			stringAndString.put("HttpStatus", "200");
			stringAndString.put("Message", "Kardex Info has be found");
			stringAndAllObjectMap.put("Data", KardexMain);
			stringAndObjectMap.putAll(stringAndString);
			stringAndObjectMap.putAll(stringAndAllObjectMap);	
			response = ResponseEntity.status(HttpStatus.OK).body(stringAndObjectMap);
		}
		catch (Exception e)
		{
			log.error("Ha ocurrido un error al consumir el servicio del endpoint http://localhost:8090/kardex");
			stringAndString.clear();
			stringAndString.put("HttpStatus", "200");
			stringAndString.put("Message", "Kardex Info hasn't be found");
			stringAndAllObjectMap.put("Data", null);
			stringAndObjectMap.putAll(stringAndString);
			stringAndObjectMap.putAll(stringAndAllObjectMap);	
			response = ResponseEntity.status(HttpStatus.OK).body(stringAndObjectMap);
		}
		return response;
	}

	public ResponseEntity<KardexMain> getRestTemplateResult()
	{
		return restTemplateResult;
	}

	public void setRestTemplateResult(ResponseEntity<KardexMain> restTemplateResult)
	{
		this.restTemplateResult = restTemplateResult;
	}
}
