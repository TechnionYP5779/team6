package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class AccumulatorTest {
  @Test public void booleanAddsLast() {
    final @NotNull Accumulator.Last c = new Accumulator.Last();
    azzert.that(as.bit(false), is(0));
    azzert.that(c.value(), is(0));
    c.add(true);
    azzert.that(c.value(), is(1));
    azzert.that(as.bit(false), is(0));
    c.add(false);
    azzert.that(c.value(), is(0));
    c.add(false);
    azzert.that(c.value(), is(0));
    c.add(true);
    azzert.that(c.value(), is(1));
    c.add(true);
    azzert.that(c.value(), is(1));
  }

  @Test public void emptyAddsLast() {
    final @NotNull Accumulator.Last c = new Accumulator.Last();
    for (int ¢ = 0; ¢ < 19; ++¢)
      c.add(¢);
    c.add(11);
    azzert.that(c.value(), is(11));
  }

  @Test public void booleanAddsCounter() {
    final @NotNull Accumulator.Counter c = new Accumulator.Counter();
    azzert.that(c.value(), is(0));
    c.add(true);
    azzert.that(c.value(), is(1));
    c.add(false);
    azzert.that(c.value(), is(1));
    c.add(false);
    azzert.that(c.value(), is(1));
    c.add(true);
    azzert.that(c.value(), is(2));
    c.add(true);
    azzert.that(c.value(), is(3));
  }

  @Test public void emptyAddsCounter() {
    final @NotNull Accumulator.Counter c = new Accumulator.Counter();
    for (int ¢ = 0; ¢ < 19; ++¢)
      c.add();
    azzert.that(c.value(), is(19));
  }
}
