package org.lucius.commons.utils.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.lucius.commons.utils.exception.ServiceException;

@XmlRootElement
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 7237821738979926948L;
    
	private static final String RESULT_SUCCESS = "00000000";

    private String resultCode = RESULT_SUCCESS;

    private String resultMsg = "SUCCESS";

    private T data;

    public Result() {
    }

    public Result(T data) {
    	this.data = data;
    }
    
    public Result(String statusCode, String message) {
        this(statusCode, message, null);
    }
    
    public Result(ServiceException e) {
    	this(e.getStatusCode(),e.getMessage());
    }

    public Result(String resultCode, String resultMsg, T data) {
        this.data = data;
        this.resultMsg = resultMsg;
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasError() {
        return !StringUtils.equalsIgnoreCase(this.getResultCode(), RESULT_SUCCESS);
    }
}
