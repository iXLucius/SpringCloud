package org.lucius.commons.utils.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lucius.commons.utils.JsonUtils;
import org.lucius.commons.utils.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ServiceException.class)
    public void serviceException(HttpServletRequest request,HttpServletResponse response, Exception e) throws Exception {
		toJson(new Result<Object>((ServiceException)e),response);
	}
	
	@ExceptionHandler(value = Throwable.class)
    public void defaultErrorHandler(HttpServletRequest request,HttpServletResponse response, Exception e) throws Exception {
		toJson(new Result<Object>(ServiceException.FAILURE,"系统内部错误"),response);
    }
	
    private void toJson(Object result, HttpServletResponse response) throws IOException {
    	render("application/json", JsonUtils.toJson(result), response);
    }
    
    private void render(String type, String result, HttpServletResponse response) throws IOException {
        response.setContentType(type + ";charset=UTF-8;");
        response.getWriter().write(result);
    }

}
