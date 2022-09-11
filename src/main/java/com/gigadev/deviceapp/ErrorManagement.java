package com.gigadev.deviceapp;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorManagement extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> gestisciEntityNotFoundException(EntityNotFoundException e) {
		log.info("------------- errore gestito da ErrorManagement");
		return new ResponseEntity<String>(e.getMessage() + " --- da ErrorManagement", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityExistsException.class)
	protected ResponseEntity<String> gestisciEntityExistsException(EntityExistsException e) {
		log.info("------------- errore gestito da ErrorManagement");
		return new ResponseEntity<String>(e.getMessage() + " --- da ErrorManagement", HttpStatus.FOUND);
	}
}
