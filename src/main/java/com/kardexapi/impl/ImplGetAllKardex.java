package com.kardexapi.impl;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.kardexapi.dto.KardexMain;
import com.kardexapi.services.ServiceGetAllKardex;

@Configuration
public class ImplGetAllKardex
{
	private static final Logger log = LoggerFactory.getLogger(ImplGetAllKardex.class);
	@Autowired
	private ServiceGetAllKardex serviceGetAllKardex;
	private String url = "http://localhost:8090/kardex";
	private ResponseEntity<KardexMain> restServiceGetAllKardex;
	private Map<String, Object> mapGetAllKardex = new TreeMap<>();

	public Map<String, Object> executeGetAllKardex()
	{
		log.info("Ingresando al método executeGetAllKardex() de la clase");
		try
		{
			log.info("Invocando la clase que realiza el consumo del servicio  de /kardex por método GET");
			serviceGetAllKardex.consume(url);
			log.info("Obteniendo respuesta del servicio");
			restServiceGetAllKardex = serviceGetAllKardex.getRestTemplateResult();
			log.info("Ingresando resultados en el mapa de respuesta");
			mapGetAllKardex.put("Data", restServiceGetAllKardex.getBody().getKardexMainList());
			log.info("Mapa resultante: "+mapGetAllKardex);
		}
		catch (Exception e)
		{
			log.error("Ha ocurrido un error al momwnto de consumir el servicio");
			log.error("Retornando resultado al controlador CKardexMain");
		}
		log.error("Saliendo del método executeGetAllKardex() de la clase ImplGetAllKardex");
		return mapGetAllKardex;
	}
}
