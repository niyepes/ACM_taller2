package com.acm.taller2.exception;

public class UserNotAuthenticatedException extends RuntimeException {

  public UserNotAuthenticatedException() {
    super();
  }

  public UserNotAuthenticatedException(String message) {
    super(message);
  }
}
