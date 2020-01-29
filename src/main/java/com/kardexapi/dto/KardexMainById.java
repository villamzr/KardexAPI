package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMainById {
	@JsonProperty("kardexInfo")
	private KardexMainInfo kardexInfo;

	public KardexMainInfo getKardexInfo() {
		return kardexInfo;
	}

	public void setKardexInfo(KardexMainInfo kardexInfo) {
		this.kardexInfo = kardexInfo;
	}
}
