package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMainPut {
	@JsonProperty("Message")
	private String message;
	@JsonProperty("HttpStatus")
	private String httpStatus;
	@JsonProperty("kardexIdUpdated")
	private String kardexIdUpdated;

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

	public String getKardexIdUpdated() {
		return kardexIdUpdated;
	}

	public void setKardexIdUpdated(String kardexIdUpdated) {
		this.kardexIdUpdated = kardexIdUpdated;
	}
}
