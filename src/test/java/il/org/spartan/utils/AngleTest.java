package il.org.spartan.utils;

import fluent.ly.azzert;

import org.junit.*;

public class AngleTest {
 @SuppressWarnings("static-method") @Test public void AngleTDDTest() {
    angle d20 = angle.degrees(20);
    azzert.that(d20.degrees(), azzert.is(20.0));
    
    
  }
}
