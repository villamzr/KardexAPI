package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexCreate {
	@JsonProperty("Message")
	private String Message;
	@JsonProperty("HttpStatus")
	private String HttpStatus;

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
}
