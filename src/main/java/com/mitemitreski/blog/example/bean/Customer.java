package com.mitemitreski.blog.example.bean;

import com.google.common.base.Objects;

public class Customer {

  private Integer id;
  private String name;

  public Customer(Integer id, String name) {
    this.id = id;
    this.name = name;
  }


  public Customer() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public int hashCode() {
    return Objects.hashCode(id, name);
  }


  @Override
  public String toString() {
    return name + " (id " + id + ")";
  }


  public Integer getId() {
    return id;
  }

  public boolean isSick() {
    return false;
  }

  public String getAddress() {
    return null;
  }

  public String getName() {
    return name;
  }
}
