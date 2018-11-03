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
  
  @SuppressWarnings("static-method") @Test public void RangeIncludenInTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(1,4);
    Range r3 = new Range(0,4);
    Range r4 = new Range(1,5);
    Range r5 = new Range(2,4);
    Range r6 = new Range(1,3);
    assertTrue(r1.includedIn(r2));
    assertFalse(r3.includedIn(r1));
    assertFalse(r4.includedIn(r1));
    assertTrue(r5.includedIn(r1));
    assertTrue(r6.includedIn(r1));
  }
}
