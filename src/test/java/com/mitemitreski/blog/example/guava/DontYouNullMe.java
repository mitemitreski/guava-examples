package com.mitemitreski.blog.example.guava;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.mitemitreski.blog.example.bean.Customer;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;


public class DontYouNullMe {

  private Customer ana = new Customer(123, "Ana ");
  private Customer theUnknowMan = new Customer();
  private Customer theNullMan = null;

  @Test
  public void optionalExample() {
    Optional<Integer> possible = Optional.of(3);// Make optional of given type
    possible.isPresent(); // evaluate to true if nonNull
    possible.or(10); // evaluate to possible's value or default
    possible.get(); // evaluate to 3
  }

  @Test
  public void firstNotNull() {
    Integer a = Objects.firstNonNull(null, 3);// will evaluate to 3
    Integer b = Objects.firstNonNull(9, 3);// //will evaluate to 9
    assertEquals(Integer.valueOf(3), a);
    assertEquals(Integer.valueOf(9), b);
  }


  @Test
  public void testNeverNullWithoutGuava() {
    Integer defaultId = null;
    Integer id = theUnknowMan.getId() != null ? theUnknowMan.getId() : defaultId;
    assertNotNull(id);
  }

  @Test(expected = NullPointerException.class)
  public void testNeverNullWithGuava() {
    Integer defaultId = null;
    int id = Objects.firstNonNull(theUnknowMan.getId(), defaultId);
    assertNotNull(id);
  }

  @Test
  public void nullInStrings() {
    String res = Strings.emptyToNull("");// res will be null
    res = Strings.nullToEmpty(res);// res will be ""
    boolean isIt = false;
    if (res == null || "".equals(res)) {
      isIt = true;
    }
    boolean isItWithG = Strings.isNullOrEmpty(res);
    assertTrue(isIt);
    assertTrue(isItWithG);
  }
}
