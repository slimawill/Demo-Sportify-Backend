package com.example.sportifyBackendNovo.demo.controller;

import com.example.sportifyBackendNovo.demo.exceptions.NotFoundException;
import com.example.sportifyBackendNovo.demo.exceptions.RegistrationFailedException;
import com.example.sportifyBackendNovo.demo.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String combinedErrorMessage = ex.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    if (error instanceof FieldError fieldError) {
                        return fieldError.getField() + ": " + fieldError.getDefaultMessage();
                    } else {
                        return error.getDefaultMessage();
                    }
                })
                .collect(Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse(combinedErrorMessage);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);}

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RegistrationFailedException.class)
    public ResponseEntity<ErrorResponse> handleRegistrationFailedException(RegistrationFailedException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(RegistrationFailedException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        ErrorResponse error = new ErrorResponse("Internal Server Error");

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }



class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}}