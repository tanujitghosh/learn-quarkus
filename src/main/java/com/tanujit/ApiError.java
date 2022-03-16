package com.tanujit;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.StringJoiner;

@RegisterForReflection
public class ApiError {

  String exceptionType;
  String exceptionMessage;

  public String getExceptionType() {
    return exceptionType;
  }

  public void setExceptionType(String exceptionType) {
    this.exceptionType = exceptionType;
  }

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ApiError.class.getSimpleName() + "[", "]")
        .add("exceptionType='" + exceptionType + "'")
        .add("exceptionMessage='" + exceptionMessage + "'")
        .toString();
  }
}
