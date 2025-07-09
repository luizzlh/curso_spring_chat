package com.cursochat.cursospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handle(MethodArgumentNotValidException ex){
        var erros = ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(
                erro -> erro.getField(),
                erro -> erro.getDefaultMessage()
        ));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}