package com.stockflow.stockflow_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stockflow.stockflow_backend.dtos.ErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ErrorDto> handleProductNotFound(
    ProductNotFoundException ex
  ) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body(new ErrorDto(
        404,
        ex.getMessage())
      );
  }
}
