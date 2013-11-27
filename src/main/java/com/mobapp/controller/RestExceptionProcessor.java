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
		
		String errorMessage = localizeErrorMessage("error.no.smartphone.id");
		
		errorMessage += ex.getSmartphoneId();
		String errorURL = req.getRequestURL().toString();
		
		return new ErrorInfo(errorURL, errorMessage);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorFormInfo handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
		
		String errorMessage = localizeErrorMessage("error.bad.arguments");
		String errorURL = req.getRequestURL().toString();
		
		ErrorFormInfo errorInfo = new ErrorFormInfo(errorURL, errorMessage);
		
		BindingResult result = ex.getBindingResult();		
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		errorInfo.getFieldErrors().addAll(populateFieldErrors(fieldErrors));
		
		return errorInfo;
	}
	
	/**
	 * Method populates {@link List} of {@link FieldErrorDTO} objects. Each list item contains
	 * localized error message and name of a form field which caused the exception.
	 * Use the {@link #localizeErrorMessage(String) localizeErrorMessage} method.
	 * 
	 * @param fieldErrorList - {@link List} of {@link FieldError} items
	 * @return {@link List} of {@link FieldErrorDTO} items
	 */
	public List<FieldErrorDTO> populateFieldErrors(List<FieldError> fieldErrorList) {
		List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();
		StringBuilder errorMessage = new StringBuilder("");
		
		for (FieldError fieldError : fieldErrorList) {
			
			errorMessage.append(fieldError.getCode()).append(".");
			errorMessage.append(fieldError.getObjectName()).append(".");
			errorMessage.append(fieldError.getField());
			
			String localizedErrorMsg = localizeErrorMessage(errorMessage.toString());
			
			fieldErrors.add(new FieldErrorDTO(fieldError.getField(), localizedErrorMsg));
			errorMessage.delete(0, errorMessage.capacity());
		}
		return fieldErrors;
	}
	
	/**
	 * Method retrieves appropriate localized error message from the {@link MessageSource}.
	 * 
	 * @param errorCode - key of the error message
	 * @return {@link String} localized error message 
	 */
	public String localizeErrorMessage(String errorCode) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage(errorCode, null, locale);
		return errorMessage;
	}

}
