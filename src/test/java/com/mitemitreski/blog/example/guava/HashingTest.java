package com.mitemitreski.blog.example.guava;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.hash.*;
import com.mitemitreski.blog.example.bean.Customer;
import org.junit.Test;

import java.util.List;

public class HashingTest {

  @Test
  public void simple() {
    HashFunction hf = Hashing.md5();

    Customer c = new Customer();
    Funnel<? super Customer> customerFunnel = (from, into) -> {
      into.putString(MoreObjects.firstNonNull(from.getName(), ""), Charsets.UTF_8);
      into.putString(MoreObjects.firstNonNull(from.getUrl(), ""), Charsets.UTF_8);
      into.putInt(MoreObjects.firstNonNull(from.getId(), 1));
    };


    HashCode hc = hf.newHasher()
        .putLong(2)
        .putString("Mite", Charsets.UTF_8)
        .putObject(c, customerFunnel)
        .hash();


  }


  public void bloomFilter() {
    Funnel<? super Customer> customerFunnel = (from, into) -> {
      into.putString(from.getName(), Charsets.UTF_8);
      into.putString(from.getUrl(), Charsets.UTF_8);
      into.putInt(from.getId());
    };

    BloomFilter<Customer> awesomeCusumers = BloomFilter.create(customerFunnel, 500, 0.01);
    List<Customer> friendsList = Lists.newArrayList(new Customer(), new Customer());
    for (Customer friend : friendsList) {
      awesomeCusumers.put(friend);
    }
    Customer thatStrangeGuy = new Customer();
    if (awesomeCusumers.mightContain(thatStrangeGuy)) {
      //that strange guy is not a  cusumer and we have reachet this line
      //probablility 0.01
    }

  }

}
