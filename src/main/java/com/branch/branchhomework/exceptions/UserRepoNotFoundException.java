package com.branch.branchhomework.exceptions;

public class UserRepoNotFoundException extends RuntimeException {
  public UserRepoNotFoundException(String userName) {
    super("No Github repo was for this user name: " + userName);
  }
}
