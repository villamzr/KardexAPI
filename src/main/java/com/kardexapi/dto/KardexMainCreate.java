package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexMainCreate {
	@JsonProperty("Message")
	private String message;
	@JsonProperty("HttpStatus")
	private String httpStatus;

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
}
