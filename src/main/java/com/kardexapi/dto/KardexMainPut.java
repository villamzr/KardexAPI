package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMainPut {
	@JsonProperty("Message")
	private String Message;
	@JsonProperty("HttpStatus")
	private String HttpStatus;
	@JsonProperty("kardexIdUpdated")
	private String kardexIdUpdated;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getHttpStatus() {
		return HttpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		HttpStatus = httpStatus;
	}

	public String getKardexIdUpdated() {
		return kardexIdUpdated;
	}

	public void setKardexIdUpdated(String kardexIdUpdated) {
		this.kardexIdUpdated = kardexIdUpdated;
	}
}
