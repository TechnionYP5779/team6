package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

public class AngleTest {
  @SuppressWarnings("static-method") @Test public void AngleTDDTest() {
    angle d20 = angle.degrees(20);
    azzert.that(d20.degrees(), is(20.0));
    angle r1 = angle.radians(1);
    azzert.that(r1.radians(), is(1.0));
    angle pi = angle.pi;
    azzert.that(pi.degrees(), is(180.00)); // 180 degrees is pi radians
    angle halfPi = angle.halfPi;
    azzert.that(halfPi.radians(), is(Math.PI / 2));
    angle halfPi_20degrees = angle.halfPi.add(angle.degrees(20));
    azzert.that(halfPi_20degrees.radians(), is(Math.PI / 2 + 20));
    angle halfPi_20 = angle.halfPi.add(20);
    azzert.that(halfPi_20.degrees(), is(90.0 + 20));
    azzert.that(pi.degrees(), is(180.0));
    angle of20 = angle.of(20);
    azzert.that(of20.degrees(), is(180.0));
    azzert.that(pi.radians(), is(Math.PI / 2));
  }
}
