package com.kardexapi.impl;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.kardexapi.dto.KardexMainById;
import com.kardexapi.services.ServiceGetByIdKardex;

@Configuration
public class ImplGetByIdKardex
{
	private static final Logger log = LoggerFactory.getLogger(ImplGetByIdKardex.class);
	@Autowired
	private ServiceGetByIdKardex serviceGetByIdKardex;
	private String url = "http://localhost:8090/kardex/";
	private ResponseEntity<KardexMainById> restServiceGetByIdKardex;
	private Map<String, Object> mapGetByIdKardex = new TreeMap<>();

	public Map<String, Object> executeGetByIdKardex(String id)
	{
		log.info("Ingresando al método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		log.info("Concatenando id '" + id + "' al endopint /kardex");
		url = url + id;
		try
		{
			log.info("Invocando la clase que realiza el consumo del servicio  de /kardex por método GET");
			serviceGetByIdKardex.consume(url);
			log.info("Obteniendo respuesta del servicio");
			restServiceGetByIdKardex = serviceGetByIdKardex.getRestTemplateResult();
			log.info("Ingresando resultados en el mapa de respuesta");
			mapGetByIdKardex.put("Data", restServiceGetByIdKardex.getBody().getKardexInfo());
			log.info("Mapa resultante: " + mapGetByIdKardex);
		}
		catch (Exception e)
		{
			log.error("Ha ocurrido un error al momento de consumir el servicio /kardex");
			log.error("Retornando resultado al controlador CKardexMain");
			
			
		}
		log.error("Saliendo del método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		return mapGetByIdKardex;
	}
}
