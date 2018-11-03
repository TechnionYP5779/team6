package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class RangeTest {
  @SuppressWarnings("static-method") @Test public void RangeEqualTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(1,4);
    Range r3 = new Range(2,4);
    Range r4 = new Range(1,5);
    assertTrue(r1.equals(r2));
    assertFalse(r1.equals(r3));
    assertFalse(r1.equals(r4));
    assertFalse(r3.equals(r4));
  }
}
