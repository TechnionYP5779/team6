package fluent.ly;

import java.util.*;

import org.junit.*;

/** For tested interface please see {@link fluent.ly.is} . */
@SuppressWarnings("static-method") public class isTest {
  @Test public void in() {
    assert !is.in(box.it(0), (Integer) null);
    assert !is.in(box.it(0));
    assert !is.in(box.it(0), box.it(1));
    assert !is.in(box.it(0), box.it(1), box.it(2), box.it(3), box.it(4));
    assert is.in(box.it(0), box.it(0));
    assert is.in(box.it(0), box.it(0), box.it(1), box.it(2));
    assert !is.out(box.it(0), box.it(7), box.it(8), box.it(9), box.it(0), box.it(6), box.it(5), box.it(4));
    assert !is.in("a", (String) null);
    assert !is.in("a");
    assert !is.in("a", "A");
    assert !is.in("a", "A", null, "C");
    assert is.in("a", "a");
    assert is.in("a", "z", "x", "a");
    assert is.in("a", "A", "B", null, "B", "a", "A", "B");
    final int[] arr1 = new int[] { 1 }, arr23 = new int[] { 2, 3 }, arr123 = new int[] { 1, 2, 3 }, arr1234 = new int[] { 1, 2, 3, 4 };
    assert !is.in(arr123, (int[]) null);
    assert !is.in(arr123);
    assert !is.in(arr123, arr1234);
    assert !is.in(arr123, arr1, arr23);
    assert is.in(arr123, null, arr123);
    assert is.in(arr123, arr1, arr123, arr1, arr123);
  }

  @Test public void intIsIn() {
    try {
      assert !is.intIsIn(0, null);
      azzert.fail();
    } catch (@SuppressWarnings("unused") final NullPointerException ignored) {
      // do nothing
    }
    assert !is.intIsIn(0);
    assert !is.intIsIn(0, 1);
    assert !is.intIsIn(0, 1, 2, 3, 4);
    assert is.intIsIn(0, 0);
    assert is.intIsIn(0, 0, 1, 2);
    assert is.intIsIn(0, 7, 8, 9, 0, 6, 5, 4);
  }

  @Test public void not_in() {
    assert is.not.in(box.it(0), (Integer) null);
    assert is.not.in(box.it(0));
    assert is.not.in(box.it(0), box.it(1));
    assert is.not.in(box.it(0), box.it(1), box.it(2), box.it(3), box.it(4));
    assert !is.not.in(box.it(0), box.it(0));
    assert !is.not.in(box.it(0), box.it(0), box.it(1), box.it(2));
    assert !is.out(box.it(0), box.it(7), box.it(8), box.it(9), box.it(0), box.it(6), box.it(5), box.it(4));
    assert is.not.in("a", (String) null);
    assert is.not.in("a");
    assert is.not.in("a", "A");
    assert is.not.in("a", "A", null, "C");
    assert !is.not.in("a", "a");
    assert !is.not.in("a", "z", "x", "a");
    assert !is.not.in("a", "A", "B", null, "B", "a", "A", "B");
    final int[] arr1 = new int[] { 1 }, arr23 = new int[] { 2, 3 }, arr123 = new int[] { 1, 2, 3 }, arr1234 = new int[] { 1, 2, 3, 4 };
    assert is.not.in(arr123, (int[]) null);
    assert is.not.in(arr123);
    assert is.not.in(arr123, arr1234);
    assert is.not.in(arr123, arr1, arr23);
    assert !is.not.in(arr123, null, arr123);
    assert !is.not.in(arr123, arr1, arr123, arr1, arr123);
  }

  @Test public void out() {
    assert is.out(box.it(0), (Integer) null);
    assert is.out(box.it(0));
    assert is.out(box.it(0), box.it(1));
    assert is.out(box.it(0), box.it(1), box.it(2), box.it(3), box.it(4));
    assert !is.out(box.it(0), box.it(0));
    assert !is.out(box.it(0), box.it(0), box.it(1), box.it(2));
    assert !is.out(box.it(0), box.it(7), box.it(8), box.it(9), box.it(0), box.it(6), box.it(5), box.it(4));
    assert is.out("a", (String) null);
    assert is.out("a");
    assert is.out("a", "A");
    assert is.out("a", "A", null, "C");
    assert !is.out("a", "a");
    assert !is.out("a", "z", "x", "a");
    assert !is.out("a", "A", "B", null, "B", "a", "A", "B");
    final int[] arr1 = new int[] { 1 }, arr23 = new int[] { 2, 3 }, arr123 = new int[] { 1, 2, 3 }, arr1234 = new int[] { 1, 2, 3, 4 };
    assert is.out(arr123, (int[]) null);
    assert is.out(arr123);
    assert is.out(arr123, arr1234);
    assert is.out(arr123, arr1, arr23);
    assert !is.out(arr123, null, arr123);
    assert !is.out(arr123, arr1, arr123, arr1, arr123);
  }

  @Test public void empty_string() {
    assert is.empty((String) null);
    assert is.empty("");
    assert !is.empty("a");
  }

  @Test public void empty_array() {
    // T=Boolean
    Boolean[] booleans = null;
    assert is.empty(booleans);
    booleans = new Boolean[2];
    assert !is.empty(booleans);
    booleans[1] = booleans[0] = box.it(true);
    assert !is.empty(booleans);
    // T=Integer
    Integer[] integers = null;
    assert is.empty(integers);
    integers = new Integer[0];
    assert is.empty(integers);
    integers = new Integer[1];
    assert !is.empty(integers);
  }

  @Test public void empty_iterable() {
    // T=Integer
    Iterable<Integer> integers = null;
    assert is.empty(integers);
    integers = new ArrayList<>();
    assert is.empty(integers);
    ((ArrayList<Integer>) integers).add(box.it(0));
    assert !is.empty(integers);
    ((ArrayList<Integer>) integers).add(box.it(1));
    assert !is.empty(integers);
    ((ArrayList<Integer>) integers).remove(0);
    assert !is.empty(integers);
    ((ArrayList<Integer>) integers).remove(0);
    assert is.empty(integers);
    // T=Character
    final Map<Character, Character> map = new HashMap<>();
    assert is.empty((Iterable<Character>) map.keySet());
    map.put(box.it('a'), box.it('z'));
    map.put(box.it('b'), box.it('y'));
    map.put(box.it('c'), box.it('x'));
    assert !is.empty((Iterable<Character>) map.keySet());
  }

  @Test public void empty_collection() {
    // T=Integer
    final ArrayList<Integer> listInteger = new ArrayList<>();
    assert is.empty(listInteger);
    listInteger.add(box.it(1));
    assert !is.empty(listInteger);
    listInteger.add(box.it(2));
    listInteger.add(box.it(3));
    assert !is.empty(listInteger);
    // T=String
    final ArrayList<String> listString = new ArrayList<>();
    assert is.empty(listString);
    listString.add("A");
    listString.add("B");
    assert !is.empty(listInteger);
    listString.clear();
    assert is.empty(listString);
  }
}
