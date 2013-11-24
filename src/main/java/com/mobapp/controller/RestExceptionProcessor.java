package com.mobapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mobapp.exception.SmartphoneNotFoundException;
import com.mobapp.exception.helper.ErrorFormInfo;
import com.mobapp.exception.helper.ErrorInfo;
import com.mobapp.exception.helper.FieldErrorDTO;

@ControllerAdvice
public class RestExceptionProcessor {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(SmartphoneNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo smartphoneNotFound(HttpServletRequest req, SmartphoneNotFoundException ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage("error.no.smartphone.id", null, locale);
		
		errorMessage += ex.getSmartphoneId();
		String errorURL = req.getRequestURL().toString();
		
		return new ErrorInfo(errorURL, errorMessage);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorFormInfo handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = new ArrayList<FieldError>();
		
		ErrorFormInfo errorInfo = new ErrorFormInfo(req.getRequestURL().toString(), "Bad arguments");
		
		BindingResult result = ex.getBindingResult();
		
		fieldErrors.addAll(result.getFieldErrors());
		
		for (FieldError fieldError : fieldErrors) {
			errorInfo.getFieldErrors().add(new FieldErrorDTO(fieldError.getField(), fieldError.getCode()));
		}
		
		return errorInfo;
	}

}
