package com.tanujit;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.StringJoiner;

@RegisterForReflection
public class ApiUser {

  public Long userId;

  public String userName;

  public String address;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ApiUser withUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ApiUser.class.getSimpleName() + "[", "]")
        .add("userId='" + userId + "'")
        .add("userName='" + userName + "'")
        .add("address='" + address + "'")
        .toString();
  }
}
