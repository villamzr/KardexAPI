package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMainDelete {
	@JsonProperty("Message")
	private String message;
	@JsonProperty("HttpStatus")
	private String httpStatus;
	@JsonProperty("KardexId")
	private String KardexId;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHttpStatus() {
		return this.httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getKardexIdDeleted() {
		return this.KardexId;
	}

	public void setKardexIdDeleted(String KardexId) {
		this.KardexId = KardexId;
	}
}
