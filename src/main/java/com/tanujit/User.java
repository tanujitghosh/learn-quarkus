package com.tanujit;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "user_tbl")
public class User extends PanacheEntity {

  public String userName;

  public String address;

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
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("userName='" + userName + "'")
        .add("address='" + address + "'")
        .toString();
  }
}
