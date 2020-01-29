package com.kardexapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KardexDelete {
	@JsonProperty("Message")
	private String Message;
	@JsonProperty("HttpStatus")
	private String HttpStatus;
	@JsonProperty("KardexIdDeleted")
	private String KardexIdDeleted;

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

	public String getKardexIdDeleted() {
		return KardexIdDeleted;
	}

	public void setKardexIdDeleted(String KardexIdDeleted) {
		this.KardexIdDeleted = KardexIdDeleted;
	}
}
