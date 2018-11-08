package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class isTest {
  @Test public void in() {
    // T=int:
    assertFalse(is.in(0, (Integer) null));
    assertFalse(is.in(0));
    assertFalse(is.in(0, 1));
    assertFalse(is.in(0, 1, 2, 3, 4));
    assertTrue(is.in(0, 0));
    assertTrue(is.in(0, 0, 1, 2));
    assertTrue(is.in(0, 7, 8, 9, 0, 6, 5, 4));
    // T=string:
    assertFalse(is.in("a", (String) null));
    assertFalse(is.in("a"));
    assertFalse(is.in("a", "A"));
    assertFalse(is.in("a", "A", null, "C"));
    assertTrue(is.in("a", "a"));
    assertTrue(is.in("a", "z", "x", "a"));
    assertTrue(is.in("a", "A", "B", null, "B", "a", "A", "B"));
    // T=int[]
    final int[] arr1 = new int[] { 1 };
    final int[] arr23 = new int[] { 2, 3 };
    final int[] arr123 = new int[] { 1, 2, 3 };
    final int[] arr1234 = new int[] { 1, 2, 3, 4 };
    assertFalse(is.in(arr123, (int[]) null));
    assertFalse(is.in(arr123));
    assertFalse(is.in(arr123, arr1234));
    assertFalse(is.in(arr123, arr1, arr23));
    assertTrue(is.in(arr123, null, arr123));
    assertTrue(is.in(arr123, arr1, arr123, arr1, arr123));
  }

  @Test public void intIsIn() {
    try {
      assertFalse(is.intIsIn(0, null));
      fail();
    } catch (@SuppressWarnings("unused") final NullPointerException ignored) {
      // do nothing
    }
    assertFalse(is.intIsIn(0));
    assertFalse(is.intIsIn(0, 1));
    assertFalse(is.intIsIn(0, 1, 2, 3, 4));
    assertTrue(is.intIsIn(0, 0));
    assertTrue(is.intIsIn(0, 0, 1, 2));
    assertTrue(is.intIsIn(0, 7, 8, 9, 0, 6, 5, 4));
  }

  @Test public void not_in() {
    // T=int:
    assertTrue(is.not.in(0, (Integer) null));
    assertTrue(is.not.in(0));
    assertTrue(is.not.in(0, 1));
    assertTrue(is.not.in(0, 1, 2, 3, 4));
    assertFalse(is.not.in(0, 0));
    assertFalse(is.not.in(0, 0, 1, 2));
    assertFalse(is.not.in(0, 7, 8, 9, 0, 6, 5, 4));
    // T=string:
    assertTrue(is.not.in("a", (String) null));
    assertTrue(is.not.in("a"));
    assertTrue(is.not.in("a", "A"));
    assertTrue(is.not.in("a", "A", null, "C"));
    assertFalse(is.not.in("a", "a"));
    assertFalse(is.not.in("a", "z", "x", "a"));
    assertFalse(is.not.in("a", "A", "B", null, "B", "a", "A", "B"));
    // T=int[]
    final int[] arr1 = new int[] { 1 };
    final int[] arr23 = new int[] { 2, 3 };
    final int[] arr123 = new int[] { 1, 2, 3 };
    final int[] arr1234 = new int[] { 1, 2, 3, 4 };
    assertTrue(is.not.in(arr123, (int[]) null));
    assertTrue(is.not.in(arr123));
    assertTrue(is.not.in(arr123, arr1234));
    assertTrue(is.not.in(arr123, arr1, arr23));
    assertFalse(is.not.in(arr123, null, arr123));
    assertFalse(is.not.in(arr123, arr1, arr123, arr1, arr123));
  }

  @Test public void out() {
    // T=int:
    assertTrue(is.out(0, (Integer) null));
    assertTrue(is.out(0));
    assertTrue(is.out(0, 1));
    assertTrue(is.out(0, 1, 2, 3, 4));
    assertFalse(is.out(0, 0));
    assertFalse(is.out(0, 0, 1, 2));
    assertFalse(is.out(0, 7, 8, 9, 0, 6, 5, 4));
    // T=string:
    assertTrue(is.out("a", (String) null));
    assertTrue(is.out("a"));
    assertTrue(is.out("a", "A"));
    assertTrue(is.out("a", "A", null, "C"));
    assertFalse(is.out("a", "a"));
    assertFalse(is.out("a", "z", "x", "a"));
    assertFalse(is.out("a", "A", "B", null, "B", "a", "A", "B"));
    // T=int[]
    final int[] arr1 = new int[] { 1 };
    final int[] arr23 = new int[] { 2, 3 };
    final int[] arr123 = new int[] { 1, 2, 3 };
    final int[] arr1234 = new int[] { 1, 2, 3, 4 };
    assertTrue(is.out(arr123, (int[]) null));
    assertTrue(is.out(arr123));
    assertTrue(is.out(arr123, arr1234));
    assertTrue(is.out(arr123, arr1, arr23));
    assertFalse(is.out(arr123, null, arr123));
    assertFalse(is.out(arr123, arr1, arr123, arr1, arr123));
  }

  @Test public void empty_string() {
    assertTrue(is.empty((String) null));
    assertTrue(is.empty(""));
    assertFalse(is.empty("a"));
  }

  @Test public void empty_array() {
    // T=Boolean
    Boolean[] booleans = null;
    assertTrue(is.empty(booleans));
    booleans = new Boolean[2];
    assertFalse(is.empty(booleans));
    booleans[0] = true;
    booleans[1] = true;
    assertFalse(is.empty(booleans));
    // T=Integer
    Integer[] integers = null;
    assertTrue(is.empty(integers));
    integers = new Integer[0];
    assertTrue(is.empty(integers));
    integers = new Integer[1];
    assertFalse(is.empty(integers));
  }

  @Test public void empty_iterable() {
    // T=Integer
    Iterable<Integer> integers = null;
    assertTrue(is.empty(integers));
    integers = new ArrayList<>();
    assertTrue(is.empty(integers));
    ((ArrayList<Integer>) integers).add(0);
    assertFalse(is.empty(integers));
    ((ArrayList<Integer>) integers).add(1);
    assertFalse(is.empty(integers));
    ((ArrayList<Integer>) integers).remove(0);
    assertFalse(is.empty(integers));
    ((ArrayList<Integer>) integers).remove(0);
    assertTrue(is.empty(integers));
    // T=Character
    final Map<Character, Character> map = new HashMap<>();
    assertTrue(is.empty((Iterable<Character>) map.keySet()));
    map.put('a', 'z');
    map.put('b', 'y');
    map.put('c', 'x');
    assertFalse(is.empty((Iterable<Character>) map.keySet()));
  }

  @Test public void empty_collection() {
    // T=Integer
    final ArrayList<Integer> listInteger = new ArrayList<>();
    assertTrue(is.empty(listInteger));
    listInteger.add(1);
    assertFalse(is.empty(listInteger));
    listInteger.add(2);
    listInteger.add(3);
    assertFalse(is.empty(listInteger));
    // T=String
    final ArrayList<String> listString = new ArrayList<>();
    assertTrue(is.empty(listString));
    listString.add("A");
    listString.add("B");
    assertFalse(is.empty(listInteger));
    listString.clear();
    assertTrue(is.empty(listString));
  }
}
