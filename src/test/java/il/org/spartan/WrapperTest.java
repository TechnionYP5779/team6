package il.org.spartan;

import org.junit.*;

import static fluent.ly.azzert.*;

import fluent.ly.*;

@SuppressWarnings("null") public class WrapperTest {
  private Wrapper<Integer> nullWrap = new Wrapper<>();
  private Wrapper<Integer> oneWrap = new Wrapper<>(box.boxThis(1));
  private Wrapper<Integer> twoWrap = new Wrapper<>(box.boxThis(2));

  @Test public void testEquals() {
    assert nullWrap.equals(new Wrapper<>());
    assert !nullWrap.equals(oneWrap);
    assert oneWrap.equals(new Wrapper<>(box.boxThis(1)));
    assert !oneWrap.equals(twoWrap);
    assert !oneWrap.equals(nullWrap);
    assert !oneWrap.equals(new Wrapper<>(null));
    assert !oneWrap.equals(new Wrapper<>("hello"));
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
