package com.mitemitreski.blog.example.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JoinerSplitterExamples {

  @Test
  public void joinSomeStrings() {
    ImmutableSet<String> strings = ImmutableSet.of("A", "B", "C");
    String joined = Joiner.on(":").join(strings);
    assertEquals("A:B:C", joined);
  }

  @Test
  public void splitSomeStrings() {
    String string = "A:B:C";

    String[] parts = string.split(":"); // the old way
    String backTogether = Joiner.on(":").join(parts);
    assertEquals(string, backTogether);

    String gorbleString = ": A::: B : C :::";
    Iterable<String> gorbleParts = Splitter.on(":")
        .omitEmptyStrings()
        .trimResults()
        .split(gorbleString);
    String gorbleBackTogether = Joiner.on(":").join(gorbleParts);
    assertEquals(string, gorbleBackTogether); // A:B:C
  }
}
