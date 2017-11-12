package com.sintec.rc.erro;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class DemoApiValidationException extends Exception {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String message;
  private List<FieldError> fieldErrors = new ArrayList<>();

  public DemoApiValidationException(String message) {
    super(message);
  }

  public DemoApiValidationException(List<FieldError> fieldErrors) {
    this.fieldErrors = fieldErrors;
  }

  public List<FieldError> getValidationErrors() {
    return fieldErrors;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
