package il.org.spartan.utils;


import static org.junit.Assert.*;

import org.junit.*;

public class PairTest {
  @SuppressWarnings("static-method") @Test public void testEqualPairs() {
    // make (1,1) twice, then make (1,2) and (2,1)
    Pair<Integer, Integer> p1 = new Pair<>(Integer.valueOf(1),Integer.valueOf(1));
    Pair<Integer, Integer> p2 = new Pair<>(Integer.valueOf(1),Integer.valueOf(1));
    Pair<Integer, Integer> p3 = new Pair<>(Integer.valueOf(1),Integer.valueOf(2));
    Pair<Integer, Integer> p4 = new Pair<>(Integer.valueOf(2),Integer.valueOf(1));
    assertTrue(p1.equals(p2));
    assertFalse(p3.equals(p4));
  }
}
