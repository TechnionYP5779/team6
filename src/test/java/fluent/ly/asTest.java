package fluent.ly;

import static fluent.ly.azzert.is;
import static org.junit.Assert.*;

import java.util.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.*;

/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class.
 **/

@SuppressWarnings({"null" ,"static-method", "boxing"})public class asTest {
  @Test public void asTestEmptyIterator() {
    assert !as.asIterable().iterator().hasNext();
  }

  @Test public void asTestNotEmptyIterator() {
    final Iterator<Integer> resIter = as.asIterable(1, 2, 3).iterator();
    assert resIter.hasNext();
    assertEquals(Integer.valueOf(1), resIter.next());
    assert resIter.hasNext();
    assertEquals(Integer.valueOf(2), resIter.next());
    assert resIter.hasNext();
    assertEquals(Integer.valueOf(3), resIter.next());
    assert !resIter.hasNext();
  }

  @Test public void asTestbit() {
    assertEquals(1, as.bit(true));
    assertEquals(0, as.bit(false));
  }

  @Test public void asTestEmptyIntegerList() {
    assertEquals(new ArrayList<Integer>(), as.ingeterList());
  }

  @Test public void asTestNotEmptyIntegerList() {
    final List<Integer> res = as.ingeterList(1, 2, 3), list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(list, res);
  }

  @Test public void asTestIntArray() {
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, as.intArray(1, 2, 3, 4));
  }

  @Test public void asTestIterator() {
    final Iterator<Integer> resIter = as.iterator(1, 2, 3);
    assert resIter.hasNext();
    assertEquals(Integer.valueOf(1), resIter.next());
    assert resIter.hasNext();
    assertEquals(Integer.valueOf(2), resIter.next());
    assert resIter.hasNext();
    assertEquals(Integer.valueOf(3), resIter.next());
    assert !resIter.hasNext();
  }

  @Test public void asTestlist() {
    assertEquals(Arrays.asList("A", "B", "C"), as.list("A", "B", "C"));
  }

  @Test public void asTestSet() {
    final Set<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(3);
    assertEquals(set, as.set(1, 1, 2, 3, 2, 3, 1, 2, 3));
  }

  @Test public void asTestString() {
    String res = as.string(null);
    assertEquals("null", res);
    res = as.string("test");
    assertEquals("test", res);
    res = as.string('b');
    assertEquals("b", res);
    final Object obj = new Object();
    res = as.string(obj);
    assertEquals(obj + "", res);
  }

  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNull() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable
      public String toString() {
        return null;
      }
    }), is("null"));
  }
}
