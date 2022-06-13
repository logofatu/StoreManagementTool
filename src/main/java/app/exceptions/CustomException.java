package app.exceptions;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class CustomException extends Exception {
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private Throwable previousException;

    public CustomException(HttpStatus httpStatus, String message) {
    	this(httpStatus, message, null);
    }
    
    public CustomException(HttpStatus httpStatus, Throwable e) {
    	this(httpStatus, e != null ? e.getMessage() : null, e);
    }
    
    public CustomException(HttpStatus httpStatus, String message, Throwable e) {
    	super(message);
    	this.httpStatus = httpStatus;
    	previousException = e;
    }
    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


	public Throwable getPreviousException() {
		return previousException;
	}

}