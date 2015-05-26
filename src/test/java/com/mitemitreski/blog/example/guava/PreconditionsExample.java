package com.mitemitreski.blog.example.guava;

import com.mitemitreski.blog.example.bean.Customer;
import org.junit.Test;

import static com.google.common.base.Preconditions.*;

public class PreconditionsExample {

  private Customer theUnknowMan = new Customer();

  @Test(expected = IllegalArgumentException.class)
  public void somePreconditions() {
    checkNotNull(theUnknowMan.getId()); // Will throw NPE
    checkState(!theUnknowMan.isSick()); // Will throw IllegalStateException
    checkArgument(theUnknowMan.getAddress() != null,
        "We couldn't find the description for customer with id %s", theUnknowMan.getId());
  }
}
