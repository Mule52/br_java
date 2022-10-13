package com.branch.branchhomework.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestErrorResponse {

  public int statusCode;

  public String error;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  public LocalDateTime timestamp;

  public RestErrorResponse(int statusCode, String error) {
    this.statusCode = statusCode;
    this.error = error;
    this.timestamp = LocalDateTime.now();
  }
}
