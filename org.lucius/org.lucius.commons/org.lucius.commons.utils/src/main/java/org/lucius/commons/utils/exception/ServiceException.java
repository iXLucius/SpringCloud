package org.lucius.commons.utils.exception;

import org.lucius.commons.utils.model.Result;

public class ServiceException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
	public static final String SUCCESS = "00000000";
	public static final String FAILURE = "99999999";
	
	private String statusCode;
    private String message;
    
    
    public ServiceException() {
        super();
    }
    
    public ServiceException(String statusCode,String message) {        
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

