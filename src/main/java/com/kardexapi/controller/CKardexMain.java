package com.kardexapi.controller;

import java.util.Map;

import javax.validation.Valid;

import com.kardexapi.dto.KardexMainCreate;
import com.kardexapi.dto.KardexMainList;
import com.kardexapi.impl.ImplCreateKardex;
import com.kardexapi.impl.ImplGetAllKardex;
import com.kardexapi.impl.ImplGetByIdKardex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CKardexMain
{
	private static final Logger log = LoggerFactory.getLogger(CKardexMain.class);
	@Autowired
	ImplGetAllKardex ImplGetAllKardex;

	@Autowired
	ImplCreateKardex implCreateKardex;

	@Autowired
	ImplGetByIdKardex implGetByIdKardex;

	@GetMapping("/kardex")
	public Map<String, Object> getAllKardexMain()
	{
		log.info("Ingresando al método getAllKardexMain() del controlador CKardexMain");
		log.info("Invocando la clase ImplGetAllKardex que implementa el consumo del servicio /kardex");
		return ImplGetAllKardex.executeGetAllKardex();
	}

	@PostMapping("/kardex")
	public ResponseEntity<KardexMainCreate> createKardexMain(@Valid @RequestBody KardexMainList kardexMainList)
	{
		log.info("Ingresando al método createKardexMain() del controlador CKardexMain");
		log.info("Invocando la clase ImplCreateKardex que implementa el consumo del servicio /kardex");
		return implCreateKardex.executeCreateKardex(kardexMainList);
	}

	@GetMapping("/kardex/{id}")
	public Map<String, Object> getByIdKardexMain(
			@PathVariable(value = "id") Long KardexMainId)
	{
		return implGetByIdKardex.executeGetByIdKardex(KardexMainId.toString());
	}
	//
	// /**
	// * This method expose the end point that update kardex by id.
	// *
	// * @param KardexMainId
	// * id contain kardex to be updated.
	// * @param kardexMainBody
	// * containt the body with the kardex information.
	// * @return responseEntity response OK or Server Error.
	// **/
	// @PutMapping("/kardex/{id}")
	// public ResponseEntity<Map<String, String>> updateKardex(@PathVariable(value = "id") Long KardexMainId,
	// @Valid @RequestBody KardexMainList kardexMainBody)
	// {
	// try
	// {
	//
	// }
	// catch (Exception e)
	// {
	//
	// }
	//
	// return null;
	// }
	//
	// /**
	// * This method expose the end point that delete kardex by id.
	// *
	// * @param KardexMainId
	// * id contain kardex to be deleted.
	// * @return responseEntity response OK or Server Error.
	// **/
	// @DeleteMapping("/kardex/{id}")
	// public ResponseEntity<?> deleteByIdKardexMain(@PathVariable(value = "id") Long KardexMainId)
	// {
	// try
	// {
	//
	// }
	// catch (Exception e)
	// {
	//
	// }
	//
	// return null;
	// }
}