package com.mitemitreski.blog.example.guava;

import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.mitemitreski.blog.example.bean.Customer;

import static org.junit.Assert.assertEquals;


public class DontYouNullMe {

  private Customer ana = new Customer(123, "Ana ");
  private Customer theUnknowMan = new Customer();
  private Customer theNullMan = null;

  @Test
  public void optionalExample() {
    Optional<Integer> possible = Optional.of(3);// Make optional of given type
    possible.isPresent(); // returns true if nonNull
    possible.or(10); // returns this possible value or default
    possible.get(); // returns 3
  }

  @Test
  public void firstNotNull() {
    Integer a = Objects.firstNonNull(null, 3);// will return 3
    Integer b = Objects.firstNonNull(9, 3);// //will return 9
    System.out.println(a + " " + b);
  }

  @Test
  public void nullInStrings() {
    String res = Strings.emptyToNull("");
    System.out.println(res);
    res = Strings.nullToEmpty(res);
    System.out.println(res);
    boolean isIt = Strings.isNullOrEmpty(res);
    System.out.println(isIt);
  }

  // TODO add obj test

  @Test
  public void testNeverNullWithoutGuava() {
    Integer defaultId = null;
    Integer id = theUnknowMan.getId() != null ? theUnknowMan.getId() : defaultId;
  }

  @Test(expected = NullPointerException.class)
  public void testNeverNullWithGuava() {
    Integer defaultId = null;
    int id = Objects.firstNonNull(theUnknowMan.getId(), defaultId);
    assertEquals(0, id);

  }
}
