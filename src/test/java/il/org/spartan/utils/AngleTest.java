package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;
public class AngleTest {
  @Test @SuppressWarnings("static-method") public void AngleTDDTest() {
    azzert.that(angle.degrees(20).degrees(), is(20.0));
    azzert.that(angle.radians(1).radians(), is(1.0));
    angle pi = angle.pi;
    azzert.that(pi.degrees(), is(180.00));
    angle halfPi = angle.halfPi;
    azzert.that(halfPi.radians(), is(Math.PI / 2));
    azzert.that(angle.halfPi.add(angle.degrees(20)).radians(), is(Math.PI / 2 + 20));
    azzert.that(angle.halfPi.add(20).degrees(), is(110.0));
    azzert.that(pi.degrees(), is(180.0));
    azzert.that(angle.of(20).degrees(), is(180.0));
    azzert.that(pi.radians(), is(Math.PI / 2));
  }
}
