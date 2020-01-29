package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMainById {
	@JsonProperty("kardexInfo")
	private KardexInfo kardexInfo;

	public KardexInfo getKardexInfo() {
		return kardexInfo;
	}

	public void setKardexInfo(KardexInfo kardexInfo) {
		this.kardexInfo = kardexInfo;
	}
}
