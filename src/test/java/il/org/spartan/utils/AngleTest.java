package il.org.spartan.utils;

import fluent.ly.azzert;

import org.junit.*;

public class AngleTest {
 @Test @SuppressWarnings("static-method") public void AngleTDDTest() {
  azzert.that(angle.degrees(20).degrees(), azzert.is(20.0));
  azzert.that(angle.radians(1).radians(), azzert.is(1.0));
  angle pi = angle.pi;
  azzert.that(pi.degrees(), azzert.is(180.00));
  angle halfPi = angle.halfPi;
  azzert.that(halfPi.radians(), azzert.is(Math.PI / 2));
  azzert.that(angle.halfPi.add(angle.degrees(20)).radians(), azzert.is(Math.PI / 2 + 20));
  azzert.that(angle.halfPi.add(20).degrees(), azzert.is(110.0));
  azzert.that(pi.degrees(), azzert.is(180.0));
  azzert.that(angle.of(20).degrees(), azzert.is(180.0));
  azzert.that(pi.radians(), azzert.is(Math.PI / 2));
}
}
