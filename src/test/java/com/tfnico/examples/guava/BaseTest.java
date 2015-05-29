package com.tfnico.examples.guava;

import com.google.common.base.*;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.mitemitreski.blog.example.bean.Customer;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BaseTest {

  @Test
  public void charSetsAndDefaults() {
    // Here's some charsets
    Charset utf8 = Charsets.UTF_8;
    assertTrue(utf8.canEncode());

    // Primitive defaults:
    Integer defaultValue = Defaults.defaultValue(int.class);
    assertEquals(0, defaultValue.intValue());
  }


  @Test
  public void moreFunWithStrings() {
    assertNull(Strings.emptyToNull(""));
    assertEquals("", Strings.nullToEmpty(null));
    assertTrue(Strings.isNullOrEmpty("")); // About the only thing we ever
    // used in commons-lang? :)
    assertEquals("oioioi", Strings.repeat("oi", 3));
    assertEquals("Too short      ", Strings.padEnd("Too short", 15, ' '));
  }


  // Some customers
  Customer bob = new Customer(1, "Bob");
  Customer lisa = new Customer(2, "Lisa");
  Customer stephen = new Customer(3, "Stephen");
  Customer ken = new Customer(null, "Ken");

  @Test
  public void toStringsAndHashcodes() {
    Object[] bobAndLisa = new Object[]{bob, lisa};

    // Make some hashcode!
    int hashCode = Objects.hashCode(bob, lisa);

    assertEquals(Arrays.hashCode(bobAndLisa), hashCode);

    // Build toString method
    String string = Objects.toStringHelper(bob)
        .add("name", bob.getName())
        .add("id", bob.getId())
        .toString();
    assertEquals("Customer{name=Bob, id=1}", string);
  }

  @Test(expected = NullPointerException.class)
  public void needAnIntegerWhichIsNeverNull() {
    Integer defaultId = null;
    Integer kensId = ken.getId() != null ? ken.getId() : defaultId;
    // this one does not throw!

    int kensId2 = Objects.firstNonNull(ken.getId(), defaultId);
    assertEquals(0, kensId2);
    // But the above does!
  }

  @Test(expected = IllegalArgumentException.class)
  public void somePreconditions() {
    // Pretend this is a constructor:
    Preconditions.checkNotNull(lisa.getId()); // Will throw NPE
    Preconditions.checkState(!lisa.isSick()); // Will throw IllegalStateException
    Preconditions.checkArgument(lisa.getAddress() != null,
        "We couldn't find the description for customer with id %s", lisa.getId());
  }


  @Test
  public void fancierFunctions() {
    Function<Customer, Boolean> isCustomerWithOddId = new Function<Customer, Boolean>() {

      public Boolean apply(Customer customer) {
        return customer.getId().intValue() % 2 != 0;
      }
    };

    assertTrue(isCustomerWithOddId.apply(bob));
    assertFalse(isCustomerWithOddId.apply(lisa));

    // Functions are great for higher-order functions, like
    // project/transform, and fold
  }

  @Test
  public void somePredicates() {
    ImmutableSet<Customer> customers = ImmutableSet.of(bob, lisa, stephen);

    Predicate<Customer> itsBob = Predicates.equalTo(bob);
    Predicate<Customer> itsLisa = Predicates.equalTo(lisa);
    Predicate<Customer> bobOrLisa = Predicates.or(itsBob, itsLisa);

    // Predicates are great to pass in to higher-order functions like filter/search
    Iterable<Customer> filtered = Iterables.filter(customers, bobOrLisa);
    assertEquals(2, ImmutableSet.copyOf(filtered).size());
  }

  @Test
  public void someSuppliers() {
    // Imagine we have Supplier that produces ingredients
    IngredientsFactory ingredientsFactory = new IngredientsFactory();

    // A function 'bake' that transforms ingredients into cakes
    bake();

    // Then it's pretty easy to get a Factory that bakes cakes :)
    Supplier<Cake> cakeFactory = Suppliers.compose(bake(), ingredientsFactory);
    cakeFactory.get();
    cakeFactory.get();
    cakeFactory.get();

    assertEquals(3, ingredientsFactory.getNumberOfIngredientsUsed());

  }


  private Function<Ingredients, Cake> bake() {
    return new Function<Ingredients, Cake>() {

      public Cake apply(Ingredients ingredients) {
        return new Cake(ingredients);
      }
    };
  }


}


class Ingredients {

}

class Cake {

  Cake(Ingredients ingredients) {

  }
}

class IngredientsFactory implements Supplier<Ingredients> {

  private int counter;

  public Ingredients get() {
    counter++;
    return new Ingredients();
  }

  int getNumberOfIngredientsUsed() {
    return counter;
  }

}
