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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.mitemitreski.blog.example.bean.Customer;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CollectiionsExamples {

  private Customer retreveCustomerForKey(Integer key) {
    // TODO Auto-generated method stub
    return null;
  }

  public void variuosGoodies() {
    // list
    ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
    // Same one for map
    ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
    //list of ints
    List<Integer> theList = Ints.asList(1, 2, 3, 4, 522, 5, 6);

  }

  @Test
  public void name() {
    // oldway
    Map<String, Map<Long, List<String>>> mapOld = new HashMap<String, Map<Long, List<String>>>();
    // the guava way
    Map<String, Map<Long, List<String>>> map = Maps.newHashMap();
    map.get("asd");
  }


  @Test
  public void var() {
    // oldway
    Map<String, Map<Long, List<String>>> mapOld = new HashMap<String, Map<Long, List<String>>>();
    // the guava way
    Map<String, Map<Long, List<String>>> map = Maps.newHashMap();
    // list
    ImmutableList<String> of = ImmutableList.of("a", "b", "c");
    // Same one for map
    ImmutableMap<String, String> theMap = ImmutableMap.of("key1", "value1", "key2", "value2");
    //list of ints
    List<Integer> theList = Ints.asList(1, 2, 3, 4, 522, 5, 6);
  }

}
