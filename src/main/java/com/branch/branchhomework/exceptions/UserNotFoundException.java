package com.branch.branchhomework.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String userName) {
    super("No Github user was found with this user name: " + userName);
  }
}
