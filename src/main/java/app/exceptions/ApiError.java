package app.exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	private int statusCode;
	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		statusCode = status.value();
		this.message = message;
		this.errors = errors;
	}

	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		statusCode = status.value();
		this.message = message;
		errors = Arrays.asList(error);
	}
	
	public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
		statusCode = status.value();
		this.message = message;
	}
	
	public ApiError(HttpStatus status) {
		super();
		this.status = status;
		statusCode = status.value();
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getErrors() {
		return errors;
	}
	
}