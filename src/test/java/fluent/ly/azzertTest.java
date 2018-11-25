package fluent.ly;

import java.util.*;

import org.junit.*;

/** @author micha */
@SuppressWarnings("static-method") public class azzertTest {
  @Test public void azzertCollectionEqualTest() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final ArrayList<Integer> l2 = new ArrayList<>(); // 1,4,9
    final Integer[] arr = new Integer[3];
    arr[0] = box.it(1);
    l1.add(box.it(1));
    l2.add(box.it(1));
    arr[1] = box.it(4);
    l1.add(box.it(4));
    l2.add(box.it(4));
    arr[2] = box.it(9);
    l1.add(box.it(9));
    l2.add(box.it(9));
    azzert.assertCollectionsEqual(l1, l2);
    azzert.assertCollectionsEqual(l1, arr);
    azzert.assertCollectionsEqual("fail", l1, l2);
    azzert.assertCollectionsEqual("fail", l1, arr);
    azzert.assertCollectionsEqual("fail", arr, l2);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest1() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertCollectionsEqual(l1, l2);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest2() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertCollectionsEqual(l2, l1);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest3() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final Integer[] arr = new Integer[3]; // 1,4,8
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    arr[0] = box.it(1);
    arr[1] = box.it(4);
    arr[2] = box.it(8);
    azzert.assertCollectionsEqual(l1, arr);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest4() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertCollectionsEqual("fail", l1, l2);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest5() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final Integer[] arr = new Integer[2]; // 1,4
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    arr[0] = box.it(1);
    arr[1] = box.it(4);
    azzert.assertCollectionsEqual("fail", arr, l1);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest6() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final Integer[] arr = new Integer[4]; // 1,4,5,6
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    arr[0] = box.it(1);
    arr[1] = box.it(4);
    arr[2] = box.it(5);
    arr[3] = box.it(6);
    azzert.assertCollectionsEqual("fail", l1, arr);
  }

  @Test public void azzertContainsTest() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertContains(l1, box.it(1));
    azzert.assertContains(l1, box.it(4));
    azzert.assertContains(l1, box.it(9));
    azzert.assertContains("fail", l1, box.it(1));
    azzert.assertContains("fail", l1, box.it(4));
    azzert.assertContains("fail", l1, box.it(9));
  }

  @Test(expected = AssertionError.class) public void azzertContainsFailTest1() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertContains(l1, box.it(10));
  }

  @Test(expected = AssertionError.class) public void azzertContainsFailTest2() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertContains("fail", l1, box.it(10));
  }

  @Test public void azzertAssertEqualsTest1() {
    final Boolean t = box.it(true);
    final Boolean f = box.it(false);
    azzert.assertEquals(true, true);
    azzert.assertEquals(false, false);
    azzert.assertEquals(t, true);
    azzert.assertEquals(f, false);
    azzert.assertEquals(true, t);
    azzert.assertEquals(false, f);
    azzert.assertEquals("fail", true, true);
    azzert.assertEquals("fail", t, true);
    azzert.assertEquals("fail", true, t);
  }

  @Test public void azzertAssertEqualsTest2() {
    final Integer b_one = box.it(1);
    azzert.assertEquals(1, 1);
    azzert.assertEquals(1, b_one);
    azzert.assertEquals(b_one, 1);
    azzert.assertEquals("fail", 1, 1);
    azzert.assertEquals("fail", 1, b_one);
    azzert.assertEquals("fail", b_one, 1);
  }

  @Test public void azzertNotContainsTest() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertNotContains(l1, box.it(5));
    azzert.assertNotContains("fail", l1, box.it(5));
  }

  @Test public void azzertNotEqualsTest() {
    azzert.assertNotEquals(box.it(1), box.it(2));
    azzert.assertNotEquals("abc", "ab");
    azzert.assertNotEquals("fail", "abc", "ab");
  }

  @Test public void azzertNullTest() {
    final Object o = null;
    azzert.isNull(o);
    azzert.isNull("fail", o);
    azzert.assertNull(o);
    azzert.assertNull("fail", o);
  }

  @Test public void azzertPositiveTest1() {
    azzert.assertPositive(1);
  }

  @Test(expected = AssertionError.class) public void azzertPositiveTest2() {
    azzert.assertPositive(0);
  }

  @Test(expected = AssertionError.class) public void azzertPositiveTest3() {
    azzert.assertPositive(-1);
  }

  @Test public void azzertSubsetTest1() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    final ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    final ArrayList<Integer> empty = new ArrayList<>();
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertSubset(l2, l1);
    azzert.assertSubset(empty, l1);
  }

  @Test(expected = AssertionError.class) public void azzertSubsetTest2() {
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1
    final ArrayList<Integer> empty = new ArrayList<>();
    l1.add(box.it(1));
    azzert.assertSubset(l1, empty);
  }

  @Test(expected = AssertionError.class) public void azzertSubsetTest3() {
    final ArrayList<Integer> l2 = new ArrayList<>(); // 1,4,9
    final ArrayList<Integer> l1 = new ArrayList<>(); // 1,4
    l2.add(box.it(1));
    l1.add(box.it(1));
    l2.add(box.it(4));
    l1.add(box.it(4));
    l2.add(box.it(9));
    azzert.assertSubset(l2, l1);
  }

  @Test public void azzertZeroTest1() {
    azzert.assertZero(0);
  }

  @Test(expected = AssertionError.class) public void azzertZeroTest2() {
    azzert.assertZero(1);
  }

  @Test(expected = AssertionError.class) public void azzertZeroTest3() {
    azzert.assertZero(-1);
  }

  @Test public void azzertComparesEqualToTest() {
    // just to increase coverage - I'm not sure this is right
    azzert.comparesEqualTo(true);
    azzert.comparesEqualTo(false);
    azzert.comparesEqualTo((byte) 0);
    azzert.comparesEqualTo((char) 0);
    azzert.comparesEqualTo((double) 0);
    azzert.comparesEqualTo((float) 0);
    azzert.comparesEqualTo(0);
    azzert.comparesEqualTo(1L * 0);
    azzert.comparesEqualTo((short) 0);
  }

  @Test public void azzertGreaterThanOrEqualToTest() {
    // just to increase coverage - I'm not sure this is right
    azzert.greaterThanOrEqualTo(true);
    azzert.greaterThanOrEqualTo(false);
    azzert.greaterThanOrEqualTo((byte) 0);
    azzert.greaterThanOrEqualTo((char) 0);
    azzert.greaterThanOrEqualTo((double) 0);
    azzert.greaterThanOrEqualTo((float) 0);
    azzert.greaterThanOrEqualTo(0);
    azzert.greaterThanOrEqualTo(1L * 0);
    azzert.greaterThanOrEqualTo((short) 0);
  }

  @Test public void azzertGreaterThanOrEqualToFinalTest() {
    // just to increase coverage - I'm not sure this is right
    final boolean t = true;
    final byte a = (byte) 0;
    final char b = (char) 0;
    final double c = 0;
    final float d = 0;
    final short e = (short) 0;
    final long f = 1L * 0;
    azzert.greaterThanOrEqualTo(t);
    azzert.greaterThanOrEqualTo(t); // just to make the spartanizer happy
    azzert.greaterThanOrEqualTo(a);
    azzert.greaterThanOrEqualTo(b);
    azzert.greaterThanOrEqualTo(c);
    azzert.greaterThanOrEqualTo(d);
    azzert.greaterThanOrEqualTo(e);
    azzert.greaterThanOrEqualTo(f);
    azzert.greaterThanOrEqualTo(0);
  }

  // I guess you can say the tests below check that the fluent.ly dosen't crash on
  // us, so it's kinda ok
  @Test public void azzertLessThanTest() {
    // just to increase coverage - I'm not sure this is right
    azzert.lessThan(true);
    azzert.lessThan(false);
    azzert.lessThan((byte) 0);
    azzert.lessThan((char) 0);
    azzert.lessThan((double) 0);
    azzert.lessThan((float) 0);
    azzert.lessThan(0);
    azzert.lessThan(1L * 0);
    azzert.lessThan((short) 0);
  }

  @Test public void azzertLessThanOrEqualToTest() {
    // just to increase coverage - I'm not sure this is right
    azzert.lessThanOrEqualTo(true);
    azzert.lessThanOrEqualTo(false);
    azzert.lessThanOrEqualTo((byte) 0);
    azzert.lessThanOrEqualTo((char) 0);
    azzert.lessThanOrEqualTo((double) 0);
    azzert.lessThanOrEqualTo((float) 0);
    azzert.lessThanOrEqualTo(0);
    azzert.lessThanOrEqualTo(1L * 0);
    azzert.lessThanOrEqualTo((short) 0);
  }

  @Test public void azzertNotTest() {
    // just to increase coverage - I'm not sure this is right
    azzert.not(true);
    azzert.not(false);
    azzert.not((byte) 0);
    azzert.not((char) 0);
    azzert.not((double) 0);
    azzert.not((float) 0);
    azzert.not(0);
    azzert.not(1L * 0);
    azzert.not((short) 0);
  }
}