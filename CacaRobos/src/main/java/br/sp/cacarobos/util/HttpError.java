package br.sp.cacarobos.util;

import org.springframework.http.HttpStatus;

public class HttpError {
	private HttpStatus httpStatus;
	private String description;
	
	public HttpError(HttpStatus httpStatus, String description) {
		this.httpStatus=httpStatus;
		this.description=description;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "HttpError [httpStatus=" + httpStatus + ", description=" + description + "]";
	}
	
}
