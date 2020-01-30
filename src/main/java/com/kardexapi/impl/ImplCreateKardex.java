package com.kardexapi.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kardexapi.dto.KardexMainCreate;
import com.kardexapi.dto.KardexMainList;
import com.kardexapi.services.ServiceCreateKardex;

@Configuration
public class ImplCreateKardex
{
	private static final Logger log = LoggerFactory.getLogger(ImplCreateKardex.class);
	@Autowired
	private ServiceCreateKardex serviceCreateKardex;
	private String url = "http://localhost:8090/kardex";
	private ResponseEntity<KardexMainCreate> responseKardexCreated;

	public ResponseEntity<KardexMainCreate> executeCreateKardex(KardexMainList map)
	{
		log.info("Ingresando al método executeCreateKardex(KardexMainList map) de la clase ImplCreateKardex");
		try
		{
			log.info("Consumiendo servicio de /kardex con método POST para crear un nuevo Kardex");
			serviceCreateKardex.consume(url, map);
			log.info("Servicio /kardex consumido correctamente");
			log.info("Obteniendo respuesta del servicio /kardex");
			responseKardexCreated = serviceCreateKardex.getRestTemplateResult();
			log.info("Obtenido correctamente");
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		log.info("Retornando respuesta al controlador");
		log.info("Saliendo del método executeCreateKardex(KardexMainList map) de la clase ImplCreateKardex");
		return responseKardexCreated;
	}
}
