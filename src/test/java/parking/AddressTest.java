package parking;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/**
 * 
 * @fluent.ly.Package parking
 * @fluent.ly.Since Dec 8, 2018
 * @fluent.ly.Author Or
 */

@SuppressWarnings("static-method") public class AddressTest {
  @Test public void addressFuncsTest() {
    Address a = new Address("Tel-Aviv", "Rotchild", 9);
    azzert.that(a.getBuilding(), is(9));
    azzert.that(a.getCity(), is("Tel-Aviv"));
    azzert.that(a.getCity(), is("Tel-Aviv"));
  }
}
