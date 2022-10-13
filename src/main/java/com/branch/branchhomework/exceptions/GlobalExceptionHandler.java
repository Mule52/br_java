package com.branch.branchhomework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.branch.branchhomework.domain.RestErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<RestErrorResponse> badRequestHandler(Exception ex, WebRequest request) {

    RestErrorResponse error = new RestErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<RestErrorResponse> userNotFoundHandler(Exception ex, WebRequest request) {

    RestErrorResponse error = new RestErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserRepoNotFoundException.class)
  public ResponseEntity<RestErrorResponse> userRepoNotFoundHandler(Exception ex, WebRequest request) {

    RestErrorResponse error = new RestErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
