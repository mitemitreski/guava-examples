package com.mitemitreski.blog.example.bean;

import com.google.common.base.Objects;

public class Customer {

  private Integer id;
  private String name;
  private String address;
  private String url;

  public Customer(Integer id, String name) {
    this.id = id;
    this.name = name;
  }


  public Customer() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public int hashCode() {
    return Objects.hashCode(name, address, url);
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Customer)) {
      return false;
    }
    Customer other = (Customer) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (url == null) {
      if (other.url != null) {
        return false;
      }
    } else if (!url.equals(other.url)) {
      return false;
    }
    return true;
  }


  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("x", 1).toString();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setName(String name) {
    this.name = name;
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
