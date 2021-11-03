package com.murilonerdx.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundBook.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ApiError handle(Exception ex){
        return new ApiError(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAllExceptions(Exception ex){
        ApiError exceptionResponse =
                new ApiError(
                        ex.getMessage(),
                        LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
