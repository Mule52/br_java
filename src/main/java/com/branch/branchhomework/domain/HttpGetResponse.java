package com.branch.branchhomework.domain;

public class HttpGetResponse {

  public int statusCode;

  public String message;

  public String response;

  public HttpGetResponse(int statusCode, String message, String response) {
    this.statusCode = statusCode;
    this.message = message;
    this.response = response;
  }

  public HttpGetResponse(int statusCode, String message) {
    this(statusCode, message, null);
  }
}
