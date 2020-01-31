package com.kardexapi.impl;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.kardexapi.dto.KardexMainDelete;
import com.kardexapi.services.ServiceDeleteKardex;

@Configuration
public class ImplDeleteByIdKardex
{
	private static final Logger log = LoggerFactory.getLogger(ImplDeleteByIdKardex.class);
	@Autowired
	private ServiceDeleteKardex serviceDeleteKardex;
	private String url = "http://localhost:8090/kardex/";
	private ResponseEntity<KardexMainDelete> restServiceDeleteByIdKardex;
	private Map<String, Object> mapDeleteByIdKardex = new TreeMap<>();

	public Map<String, Object> executeDeleteByIdKardex(String id)
	{
		log.info("Ingresando al método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		log.info("Concatenando id '" + id + "' al endopint /kardex");
		try
		{
			log.info("Invocando la clase que realiza el consumo del servicio  de /kardex por método DELETE");
			serviceDeleteKardex.consume(url, id);
			log.info("Obteniendo respuesta del servicio");
			restServiceDeleteByIdKardex = serviceDeleteKardex.getRestTemplateResult();
			log.info("Ingresando resultados en el mapa de respuesta");
			mapDeleteByIdKardex.put("response", restServiceDeleteByIdKardex.getBody());
			log.info("Mapa resultante: " + mapDeleteByIdKardex);
		}
		catch (Exception e)
		{
			log.error("Ha ocurrido un error al momento de consumir el servicio /kardex");
			log.error("Retornando resultado al controlador CKardexMain");
			e.printStackTrace();
		}
		log.error("Saliendo del método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		return mapDeleteByIdKardex;
	}
}
