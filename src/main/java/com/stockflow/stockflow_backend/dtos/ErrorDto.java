package com.stockflow.stockflow_backend.dtos;

public class ErrorDto {
  int status;
  String message;

  public ErrorDto(int status, String message) {
    this.status = status;
    this.message = message;
  }
}