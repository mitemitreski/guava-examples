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

import java.net.URL;

import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.io.Resources;


public class Others {

  @Test
  private void loadResources() {
    Resources.getResource("com/tfnico/examples/guava/BaseTest.class");
    // instead of this:
    String location = "com/tfnico/examples/guava/BaseTest.class";
    URL resource2 = this.getClass().getClassLoader().getResource(location);
    Preconditions.checkArgument(resource2 != null, "resource %s not found", location);

  }

}
