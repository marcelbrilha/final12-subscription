package com.final12.final12subscription.web.rest.errors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.final12.final12subscription.exceptions.ObjectNotFoundException;
import com.final12.final12subscription.web.rest.vm.ErrorVM;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorVM handleObjectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
		ErrorVM vm = new ErrorVM(HttpStatus.NOT_FOUND);
		vm.setMessage(ex.getMessage());
		vm.setPath(request.getRequestURI());
		vm.setTrace(ex.toString());
		
		return vm;
	}
}
