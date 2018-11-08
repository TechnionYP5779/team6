package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class PairTest {
  @SuppressWarnings("static-method") @Test public void testEqualPairs() {
    // make (1,1) twice, then make (1,2) and (2,1)
    final Pair<Integer, Integer> p1 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p2 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p3 = new Pair<>(Integer.valueOf(1), Integer.valueOf(2));
    final Pair<Integer, Integer> p4 = new Pair<>(Integer.valueOf(2), Integer.valueOf(1));
    assertTrue(p1.equals(p2));
    assertFalse(p1.equals(p3));
    assertFalse(p1.equals(p4));
    assertFalse(p3.equals(p4));
  }

  @SuppressWarnings("static-method") @Test public void testHashCode() {
    final Pair<String, String> ps1 = new Pair<>("abcd", "abcd");
    final Pair<String, String> ps2 = new Pair<>("abcd", "abcd");
    final Pair<String, String> ps3 = new Pair<>("defg", "abcd");
    final Pair<String, String> ps4 = new Pair<>("abcd", "defg");
    assertTrue(ps1.equals(ps2));
    assertFalse(ps1.equals(ps3));
    assertFalse(ps1.equals(ps4));
    assertFalse(ps3.equals(ps4));
    assertTrue(ps1.hashCode() == ps2.hashCode());
    assertFalse(ps1.hashCode() == ps3.hashCode());
    assertFalse(ps1.hashCode() == ps4.hashCode());
    assertFalse(ps3.hashCode() == ps4.hashCode());
    final Pair<Integer, Integer> p1 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p2 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p3 = new Pair<>(Integer.valueOf(1), Integer.valueOf(2));
    final Pair<Integer, Integer> p4 = new Pair<>(Integer.valueOf(2), Integer.valueOf(1));
    assertTrue(p1.hashCode() == p2.hashCode());
    assertFalse(p1.hashCode() == p3.hashCode());
    assertFalse(p1.hashCode() == p4.hashCode());
    assertFalse(p3.hashCode() == p4.hashCode());
  }

  @SuppressWarnings("static-method") @Test public void testToString() {
    final Pair<Integer, Integer> p1 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p2 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p3 = new Pair<>(Integer.valueOf(1), Integer.valueOf(2));
    final Pair<Integer, Integer> p4 = new Pair<>(Integer.valueOf(2), Integer.valueOf(1));
    assertTrue(p1.toString().equals(p2.toString()));
    assertFalse(p1.toString().equals(p3.toString()));
    assertFalse(p1.toString().equals(p4.toString()));
    assertFalse(p3.toString().equals(p4.toString()));
  }

  @SuppressWarnings("static-method") @Test public void testPairArrays() {
    // two empty arrays:
    final Pair<Integer, Integer> size_two[] = Pair.makePairs(2);
    final Pair<Integer, Integer> size_two_also[] = Pair.makePairs(2);
    final Pair<Integer, Integer> p1 = new Pair<>(Integer.valueOf(1), Integer.valueOf(1));
    final Pair<Integer, Integer> p2 = new Pair<>(Integer.valueOf(1), Integer.valueOf(2));
    // comparing to empty - doesn't spit out an error
    assertFalse(p1.equals(size_two[0]));
    size_two[0] = p1;
    size_two[1] = p1;
    size_two_also[0] = p2;
    assertTrue(size_two[0].equals(size_two[0]));
    assertFalse(size_two_also[0].equals(size_two[0]));
  }
}
