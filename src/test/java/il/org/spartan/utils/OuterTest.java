package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

/** For tested class please see {@link il.org.spartan.utils.Outer} . */
@SuppressWarnings({ "static-method", "null" }) public class OuterTest {
  @Test(expected = IllegalArgumentException.class) public void consExceTest() {
    new Outer<>(null).inner = box.boxThis(5);
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void equalsTest() {
    final Outer<Integer> iout1a = new Outer<>(box.boxThis(1));
    assert iout1a.equals((Object) iout1a);
    assert !iout1a.equals(box.boxThis(1));
    assert !iout1a.equals(new Outer<>(box.boxThis(1.0)));
    assert !iout1a.equals(new Outer<>(box.boxThis(6.0)));
    assert !iout1a.equals(new Outer<>(box.boxThis(2)));
    assert iout1a.equals(new Outer<>(box.boxThis(1)));
    final Outer<Integer> ioutna = new Outer<>(box.boxThis(4));
    ioutna.inner = null;
    final Outer<Integer> ioutnb = new Outer<>(box.boxThis(5));
    assert !ioutna.equals(ioutnb);
    ioutnb.inner = null;
    assert ioutna.equals(ioutnb);
  }

  @Test public void cloneTest() throws CloneNotSupportedException {
    new Outer<>(box.boxThis(1)).clone();
  }

  @Test public void getTest() {
    azzert.that(new Outer<>(box.boxThis(1)).get(), is(1));
  }

  @Test public void hashTest() {
    assert new Outer<>(box.boxThis(1)).hashCode() != new Outer<>(box.boxThis(2)).hashCode();
  }

  @Test(expected = IllegalArgumentException.class) public void setTest() {
    final Outer<Integer> iout1 = new Outer<>(box.boxThis(1));
    iout1.set(box.boxThis(2));
    azzert.that(iout1.inner, is(2));
    iout1.set(null);
  }

  @Test public void stringTest() {
    azzert.that(new Outer<>(box.boxThis(1)) + "", is("1"));
  }

  @Test public void wrappterTest() {
    final Outer.Wrapper<Integer> wr = new Outer.Wrapper<>();
    azzert.isNull(wr.inner);
    azzert.isNull(wr.inner);
    azzert.that(wr + "", is("null"));
    azzert.that(wr.hashCode(), is(0));
    azzert.isNull(wr.get());
    assert wr.equals(new Outer.Wrapper<>());
    final Outer.Wrapper<Integer> wr2 = new Outer.Wrapper<>(box.boxThis(2));
    assert !wr.equals(wr2);
    wr.set(box.boxThis(1));
    azzert.that(wr + "", is("1"));
    azzert.that(wr.hashCode(), is(box.boxThis(1).hashCode()));
    final Outer.Wrapper<Integer> wr1 = new Outer.Wrapper<>(box.boxThis(1));
    assert wr1.equals(wr);
    assert !wr1.equals(new Outer.Wrapper<>());
    assert !wr1.equals(wr2);
  }

  @Test(expected = CloneNotSupportedException.class) public void wrpCloneTest() throws CloneNotSupportedException {
    azzert.that(new Outer.Wrapper<>(box.boxThis(5)).clone().inner, is(box.boxThis(5)));
    azzert.isNull(new Outer.Wrapper<Integer>().clone().inner);
  }
}
