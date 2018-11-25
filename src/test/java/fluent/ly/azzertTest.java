package fluent.ly;

import java.util.*;

import org.junit.*;

import fluent.ly.azzert;

@SuppressWarnings("static-method") public class azzertTest {
  @Test public void azzertCollectionEqualTest() {
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    ArrayList<Integer> l2 = new ArrayList<>(); // 1,4,9
    Integer[] arr = new Integer[3];
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
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertCollectionsEqual(l1, l2);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest2() {
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertCollectionsEqual(l2, l1);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest3() {
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    Integer[] arr = new Integer[3]; // 1,4,8
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    arr[0] = box.it(1);
    arr[1] = box.it(4);
    arr[2] = box.it(8);
    azzert.assertCollectionsEqual(l1, arr);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest4() {
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    ArrayList<Integer> l2 = new ArrayList<>(); // 1,4
    l1.add(box.it(1));
    l2.add(box.it(1));
    l1.add(box.it(4));
    l2.add(box.it(4));
    l1.add(box.it(9));
    azzert.assertCollectionsEqual("fail", l1, l2);
  }

  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest5() {
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    Integer[] arr = new Integer[2]; // 1,4
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    arr[0] = box.it(1);
    arr[1] = box.it(4);
    azzert.assertCollectionsEqual("fail", arr, l1);
  }
  
  @Test(expected = AssertionError.class) public void azzertCollectionNotEqualTest6() {
    ArrayList<Integer> l1 = new ArrayList<>(); // 1,4,9
    Integer[] arr = new Integer[4]; // 1,4,5,6
    l1.add(box.it(1));
    l1.add(box.it(4));
    l1.add(box.it(9));
    arr[0] = box.it(1);
    arr[1] = box.it(4);
    arr[2] = box.it(5);
    arr[3] = box.it(6);
    azzert.assertCollectionsEqual("fail", l1, arr);
  }
}