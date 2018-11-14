package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

public class RangeTest {
  @Test @SuppressWarnings("static-method") public void RangeEqualTest() {
    final Range r1 = new Range(1, 4), r3 = new Range(2, 4), r4 = new Range(1, 5);
    assert r1.equals(new Range(1, 4));
    assert !r1.equals(r3);
    assert !r1.equals(r4);
    assert !r3.equals(r4);
  }

  @Test @SuppressWarnings("static-method") public void RangeIncludenInTest() {
    final Range r1 = new Range(1, 4), r3 = new Range(0, 4), r4 = new Range(1, 5), r5 = new Range(2, 4), r6 = new Range(1, 3);
    assert r1.includedIn(new Range(1, 4));
    assert !r3.includedIn(r1);
    assert !r4.includedIn(r1);
    assert r5.includedIn(r1);
    assert r6.includedIn(r1);
  }

  @Test @SuppressWarnings("static-method") public void HashCodeTest() {
    final Range r1 = new Range(1, 4), r3 = new Range(2, 4), r4 = new Range(1, 5);
    assert r1.hashCode() == new Range(1, 4).hashCode();
    assert r1.hashCode() != r3.hashCode();
    assert r1.hashCode() != r4.hashCode();
    assert r3.hashCode() != r4.hashCode();
  }

  @Test @SuppressWarnings("static-method") public void SizeAndEmptyTest() {
    final Range r1 = new Range(1, 4), r2 = new Range(4, 1), r3 = new Range(1, 1);
    assert r1.size() == 3;
    // assert r2.size()==-3;
    assert r3.isEmpty();
    assert !r1.isEmpty();
    assert r2.isEmpty();
    assert r3.isEmpty();
  }

  @Test @SuppressWarnings("static-method") public void FindIncludedInTest() {
    final Range r1 = new Range(1, 4), r2 = new Range(1, 4), r3 = new Range(2, 4), r4 = new Range(1, 3), r5 = new Range(0, 4), r6 = new Range(1, 5);
    assert r1.findIncludedIn(null) == null;
    final ArrayList<Range> notIncluded = new ArrayList<>(), included = new ArrayList<>();
    notIncluded.add(r3);
    notIncluded.add(r4);
    assert r1.findIncludedIn(notIncluded) == null;
    included.add(r2);
    included.add(r5);
    included.add(r6);
    assert r2.equals(r1.findIncludedIn(included));
    assert included.remove(r2);
    assert r5.equals(r1.findIncludedIn(included));
    assert included.remove(r5);
    assert r6.equals(r1.findIncludedIn(included));
    assert included.remove(r6);
    assert r1.findIncludedIn(included) == null;
  }

  @Test @SuppressWarnings("static-method") public void OverlappingTest() {
    final Range r1 = new Range(1, 100), r3 = new Range(0, 101), r4 = new Range(0, 99), r5 = new Range(2, 101), r6 = new Range(2, 99);
    assert r1.overlapping(new Range(1, 100));
    assert r1.overlapping(r3);
    assert r1.overlapping(r4);
    assert r1.overlapping(r5);
    assert !r1.overlapping(r6);
  }

  @Test @SuppressWarnings("static-method") public void PruneIncludersTest() {
    final Range r1 = new Range(1, 4), r2 = new Range(1, 4), r3 = new Range(2, 4), r4 = new Range(1, 3), r5 = new Range(0, 4), r6 = new Range(1, 5);
    final ArrayList<Range> testList = new ArrayList<>();
    testList.add(r2);
    testList.add(r3);
    testList.add(r4);
    testList.add(r5);
    testList.add(r6);
    assert testList.contains(r2);
    assert testList.contains(r5);
    assert testList.contains(r6);
    r1.pruneIncluders(testList);
    assert !testList.contains(r2);
    assert !testList.contains(r5);
    assert !testList.contains(r6);
    assert testList.contains(r3);
    assert testList.contains(r4);
  }

  @Test @SuppressWarnings("static-method") public void ToStringTest() {
    final Range r2 = new Range(1, 1), r3 = new Range(-1, -1), r4 = new Range(-1, 5), r5 = new Range(5, -1);
    assert "[1, 4]".equals(new Range(1, 4) + "");
    assert "[1, 1]".equals(r2 + "");
    assert "[-1, -1]".equals(r3 + "");
    assert "[-1, 5]".equals(r4 + "");
    assert "[5, -1]".equals(r5 + "");
  }
}
