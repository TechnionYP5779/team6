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
    
    angle halfPi = angle.halfPi;
    azzert.that(halfPi.radians(), azzert.is(Math.PI/2));
    
    angle halfPi_20degrees = angle.halfPi.add(angle.degrees(20));
    azzert.that(halfPi_20degrees.radians(), azzert.is(Math.PI/2 + 20));
    
    angle halfPi_20 = angle.halfPi.add(20);
    azzert.that(halfPi_20.degrees(), azzert.is(90.0 + 20));
    
    azzert.that(pi.degrees(), azzert.is(180.0));
  }
}
