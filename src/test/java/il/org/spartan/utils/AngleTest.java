package il.org.spartan.utils;

import fluent.ly.azzert;

import org.junit.*;

public class AngleTest {
 @SuppressWarnings("static-method") @Test public void AngleTDDTest() {
    angle d20 = angle.degrees(20);
    azzert.that(d20.degrees(), azzert.is(20.0));
    
    angle r1 = angle.radians(1);
    azzert.that(r1.radians(), azzert.is(1.0));
    
    angle pi = angle.pi;
    azzert.that(pi.radians(), azzert.is(Math.PI));
  }
}
