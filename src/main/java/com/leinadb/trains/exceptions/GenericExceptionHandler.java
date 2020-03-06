package com.leinadb.trains.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TrainNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundExceptions(TrainNotFoundException exception, WebRequest request) {
        return new ResponseEntity(new ExceptionResponse("Provided train does not exist " + exception.getMessage(),
                new Date()),
                HttpStatus.NOT_FOUND);
    }
}
