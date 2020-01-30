package com.kardexapi.impl;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.kardexapi.dto.KardexMainPut;
import com.kardexapi.services.ServicePutKardex;

@Configuration
public class ImplPutByIdKardex
{
	private static final Logger log = LoggerFactory.getLogger(ImplPutByIdKardex.class);
	@Autowired
	private ServicePutKardex servicePutKardex;
	private String url = "http://localhost:8090/kardex/";
	private ResponseEntity<KardexMainPut> restServiceGetByIdKardex;
	private Map<String, Object> mapPutByIdKardex = new TreeMap<>();

	public Map<String, Object> executePutByIdKardex(String id, Object map)
	{
		log.info("Ingresando al método executePutByIdKardex() de la clase ImplPutByIdKardex");
		log.info("Concatenando id '" + id + "' al endopint /kardex");
		url = url + id;
		try
		{
			log.info("Invocando la clase que realiza el consumo del servicio  de /kardex por método PUT");
			servicePutKardex.consume(url, map);
			log.info("Obteniendo respuesta del servicio");
			restServiceGetByIdKardex = servicePutKardex.getRestTemplateResult();
			log.info("Ingresando resultados en el mapa de respuesta");
			mapPutByIdKardex.put("Response", restServiceGetByIdKardex.getBody());
			log.info("Mapa resultante: " + mapPutByIdKardex);
		}
		catch (Exception e)
		{
			log.error("Ha ocurrido un error al momento de consumir el servicio /kardex");
			log.error("Retornando resultado al controlador CKardexMain");
		}
		log.error("Saliendo del método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		return mapPutByIdKardex;
	}
}
