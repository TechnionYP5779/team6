package fluent.ly;

import java.util.*;

import org.junit.*;

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
}