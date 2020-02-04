package com.kardexapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kardexapi.dto.KardexMainDelete;
import com.kardexapi.services.ServiceDeleteKardex;

@Configuration
public class ImplDeleteByIdKardex
{
	private static final Logger log = LoggerFactory.getLogger(ImplDeleteByIdKardex.class);
	@Autowired
	private ServiceDeleteKardex serviceDeleteKardex;
	private KardexMainDelete kardexMainDeleteEdit = new KardexMainDelete();
	private KardexMainDelete kardexMainDelete;
	private Map<String, Object> bodyMap = new HashMap<>();
	private ResponseEntity<?> responseEntity;
	private String url = "http://localhost:8090/kardex/";
	
	public ResponseEntity<?> executeDeleteByIdKardex(String id)
	{
		log.info("Ingresando al método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		log.info("Concatenando id '" + id + "' al endopint /kardex");
		try
		{
			log.info("Invocando la clase que realiza el consumo del servicio  de /kardex por método DELETE");
			serviceDeleteKardex.consume(url+id);
			log.info("Obteniendo respuesta del servicio");
			kardexMainDelete = serviceDeleteKardex.getRestTemplateResult().getBody();
			bodyMap.put("Response", kardexMainDelete);
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(bodyMap);
		}
		catch (Exception e)
		{
			log.error("Ha ocurrido un error al momento de consumir el servicio /kardex");
			log.error("Retornando resultado al controlador CKardexMain");
			kardexMainDeleteEdit.setHttpStatus("500");
			kardexMainDeleteEdit.setMessage("Kardex couldn't be deleted");
			kardexMainDeleteEdit.setKardexIdDeleted(id);
			bodyMap.put("Response", kardexMainDeleteEdit);
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyMap);
			return responseEntity;
		}
		log.error("Saliendo del método executeGetByIdKardex() de la clase ImplGetByIdKardex");
		return responseEntity;
	}
}
