package il.org.spartan;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Outer.*;

/** Unit tests for class Wrapper
 * @author Nitzan
 * @see Wrapper */
@SuppressWarnings("null") public class WrapperTest {
  private final Wrapper<Integer> nullWrap = new Wrapper<>();
  private final Wrapper<Integer> oneWrap = new Wrapper<>(box.boxThis(1));
  private final Wrapper<Integer> twoWrap = new Wrapper<>(box.boxThis(2));

  @Test public void testEquals() {
    azzert.that(nullWrap, is(new Wrapper<>()));
    azzert.that(nullWrap, not(oneWrap));
    azzert.that(oneWrap, is(new Wrapper<>(box.boxThis(1))));
    azzert.that(oneWrap, not(twoWrap));
    azzert.that(oneWrap, not(nullWrap));
    azzert.that(oneWrap, not(new Wrapper<>(null)));
    azzert.that(oneWrap, not(new Wrapper<>("hello")));
  }

  @Test public void testHash() {
    azzert.that(nullWrap.hashCode(), is(0));
    azzert.that(oneWrap.hashCode(), is(1));
    azzert.that(twoWrap.hashCode(), is(2));
  }

  @Test public void testSet() {
    oneWrap.set(box.boxThis(5));
    azzert.that(oneWrap.get(), is(5));
  }

  @Test public void testToString() {
    azzert.that(nullWrap + "", is("null"));
    azzert.that(oneWrap + "", is("1"));
  }
}
