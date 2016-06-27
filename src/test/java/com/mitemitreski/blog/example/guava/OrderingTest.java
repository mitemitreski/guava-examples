package com.mitemitreski.blog.example.guava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.mitemitreski.blog.example.bean.Customer;
import org.junit.Test;

public class OrderingTest {

  @Test
  public void ordering() {
    Ordering<Customer> ordering = Ordering
        .natural()
        .nullsFirst().onResultOf(
            new Function<Customer, Comparable>() {
              @Override
              public Comparable apply(Customer customer) {
                return customer.getName();
              }
            }
        );

  }
}
