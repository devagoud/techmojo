package com.tech.mojo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;



/**
 * @author devagoud
 */
@ControllerAdvice
@RestController
@Slf4j
public class ExceptionHandlerAdvice {


    /***
     * Handling Custom related exceptions.
     * @exception MojoException
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(MojoException.class)
    public final ResponseEntity handleCustomException(MojoException exception, WebRequest request) {
        log.error("Error {}", exception);
        Response error = new  Response( HttpStatus.NOT_ACCEPTABLE,false,exception.getMessage());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);

    }


    /***
     * Handling all type of exceptions.
     * @exception
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllExceptions(Exception exception, WebRequest request) {
        log.error("Error {}", exception);
        Response error = new  Response( HttpStatus.INTERNAL_SERVER_ERROR,false,exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }
}
