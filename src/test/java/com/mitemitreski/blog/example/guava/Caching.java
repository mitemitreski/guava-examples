package com.mitemitreski.blog.example.guava;

import com.google.common.cache.*;
import com.mitemitreski.blog.example.bean.Customer;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by mite on 5/26/15.
 */
public class Caching {


  @Test
  public void testCacheBasic() {
    Cache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(10, TimeUnit.MINUTES).build();

  }

  @Test
  public void testCacheAllowGC() {
    Cache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .weakKeys()
            .maximumSize(10000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();


  }


  @Test
  public void evictonAfterWrite() {
    Cache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.MINUTES)
            .build();


  }


  @Test
  public void evictonAfterAccess() {
    Cache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .expireAfterAccess(2, TimeUnit.MINUTES)
            .build();


  }

  @Test
  public void evictonWeight() {
    Cache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .weigher(new Weigher<Integer, Customer>() {
              @Override
              public int weigh(Integer key, Customer value) {
                return value.getName().length(); //Have we maxed out
              }
            }).maximumWeight(20) //0 remove right away 20 stay some more
            .build();


  }

  @Test
  public void stats() {
    Cache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .recordStats()
            .build();
    CacheStats stats = cache.stats();
    stats.hitRate();
    stats.averageLoadPenalty();
    stats.missCount();
    stats.missRate();

  }

  @Test
  public void async() {

  }


  @Test
  public void testCache() {
    LoadingCache<Integer, Customer> cache =
        CacheBuilder.newBuilder()
            .weakKeys()
            .maximumSize(10000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, Customer>() {
              @Override
              public Customer load(Integer key) throws
                  Exception {
                return retrieveCustomerForKey(key);
              }
            });


  }

  private Customer retrieveCustomerForKey(Integer key) {
    //SOME loading mechanism
    return new Customer();
  }
}
