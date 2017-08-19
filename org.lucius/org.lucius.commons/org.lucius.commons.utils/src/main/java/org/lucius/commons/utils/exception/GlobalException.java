package org.lucius.commons.utils.exception;

import org.lucius.commons.utils.model.Result;

public class GlobalException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
    private String message;
    
    
    public GlobalException() {
        super();
    }

    public <T> GlobalException(Result<T> result) {        
        this(result.getResultCode(),result.getResultMsg());
    }

    public GlobalException(String statusCode,String message) {        
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

