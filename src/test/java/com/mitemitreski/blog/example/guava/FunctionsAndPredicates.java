/*
 * Copyright (C) 2012 by Netcetera AG.
 * All rights reserved.
 *
 * The copyright to the computer program(s) herein is the property of Netcetera AG, Switzerland.
 * The program(s) may be used and/or copied only with the written permission of Netcetera AG or
 * in accordance with the terms and conditions stipulated in the agreement/contract under which 
 * the program(s) have been supplied.
 */
package com.mitemitreski.blog.example.guava;


import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class FunctionsAndPredicates {


  @Test
  public void simpleTest() {
    Function<String, Integer> lengthFunction = new Function<String, Integer>() {

      public Integer apply(String string) {
        return string.length();
      }
    };
    Predicate<String> allCaps = new Predicate<String>() {

      public boolean apply(String string) {
        return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(string);
      }
    };

  }


  @Test
  public void simpleTestJava8() {
    Function<String, Integer> lengthFunction = String::length;
    Predicate<String> allCaps = CharMatcher.JAVA_UPPER_CASE::matchesAllOf;

  }


  @Test
  public void filterAwayNullMapValues() {
    SortedMap<String, String> map = new TreeMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", null);
    map.put("4", "four");
    SortedMap<String, String> filtered = Maps.filterValues(map, Predicates.notNull());
    assertThat(filtered.size(), is(3)); // null entry for "3" is gone!
  }

}
