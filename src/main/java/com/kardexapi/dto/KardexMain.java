package com.kardexapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that receive object list injection as of the consuming kardexAll
 * service. That service get all Kardex there are in database.
 * 
 * @author Alejandro Villamizar.
 * @since 1.0.0
 * @version 1.0.0
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMain {

	@JsonProperty("kardexMainList")
	private List<KardexMainList> kardexMainList;

	public List<KardexMainList> getKardexMainList() {
		return kardexMainList;
	}

	public void setKardexMainList(List<KardexMainList> kardexMainList) {
		this.kardexMainList = kardexMainList;
	}
}
