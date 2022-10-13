package com.branch.branchhomework.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserResponse {

  public boolean successful;

  public String message;

  public UserDto user;

  public UserResponse(boolean successful, String message) {
    this.successful = successful;
    this.message = message;
  }

  public UserResponse(UserDto user) {
    this.successful = true;
    this.user = user;
  }
}
