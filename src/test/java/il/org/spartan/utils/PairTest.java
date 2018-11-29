package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

/** For tested class please see {@link il.org.spartan.utils.Pair} . */
@SuppressWarnings("static-method") public class PairTest {
  @Test public void testEqualPairs() {
    final Pair<Integer, Integer> p1 = new Pair<>(box.it(1), box.it(1)), p3 = new Pair<>(box.it(1), box.it(2)), p4 = new Pair<>(box.it(2), box.it(1));
    assert p1.equals(new Pair<>(box.it(1), box.it(1)));
    assert !p1.equals(p3);
    assert !p1.equals(p4);
    assert !p3.equals(p4);
  }

  @Test public void testHashCode() {
    final Pair<String, String> ps1 = new Pair<>("abcd", "abcd"), ps2 = new Pair<>("abcd", "abcd"), ps3 = new Pair<>("defg", "abcd"),
        ps4 = new Pair<>("abcd", "defg");
    assert ps1.equals(ps2);
    assert !ps1.equals(ps3);
    assert !ps1.equals(ps4);
    assert !ps3.equals(ps4);
    assert ps1.hashCode() == ps2.hashCode();
    assert ps1.hashCode() != ps3.hashCode();
    assert ps1.hashCode() != ps4.hashCode();
    assert ps3.hashCode() != ps4.hashCode();
    final Pair<Integer, Integer> p1 = new Pair<>(box.it(1), box.it(1)), p3 = new Pair<>(box.it(1), box.it(2)), p4 = new Pair<>(box.it(2), box.it(1));
    assert p1.hashCode() == new Pair<>(box.it(1), box.it(1)).hashCode();
    assert p1.hashCode() != p3.hashCode();
    assert p1.hashCode() != p4.hashCode();
    assert p3.hashCode() != p4.hashCode();
  }

  @Test public void testToString() {
    final Pair<Integer, Integer> p1 = new Pair<>(box.it(1), box.it(1)), p3 = new Pair<>(box.it(1), box.it(2)), p4 = new Pair<>(box.it(2), box.it(1));
    assert (p1 + "").equals(new Pair<>(box.it(1), box.it(1)) + "");
    assert !(p1 + "").equals(p3 + "");
    assert !(p1 + "").equals(p4 + "");
    assert !(p3 + "").equals(p4 + "");
  }

  @Test public void testPairArrays() {
    final Pair<Integer, Integer> size_two[] = Pair.makePairs(2), size_two_also[] = Pair.makePairs(2), p1 = new Pair<>(box.it(1), box.it(1)),
        p2 = new Pair<>(box.it(1), box.it(2));
    assert !p1.equals(size_two[0]);
    size_two[1] = size_two[0] = p1;
    size_two_also[0] = p2;
    assert size_two[0].equals(size_two[0]);
    assert !size_two_also[0].equals(size_two[0]);
  }
}
