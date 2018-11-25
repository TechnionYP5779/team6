package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. **/
@SuppressWarnings({ "null", "static-method" }) public class asTest {
  @Test public void asTestEmptyIterator() {
    assert !as.asIterable().iterator().hasNext();
  }

  @Test public void asTestNotEmptyIterator() {
    final Iterator<Integer> resIter = as.asIterable(box.it(1), box.it(2), box.it(3)).iterator();
    assert resIter.hasNext();
    azzert.that(box.it(1), is(resIter.next()));
    assert resIter.hasNext();
    azzert.that(box.it(2), is(resIter.next()));
    assert resIter.hasNext();
    azzert.that(box.it(3), is(resIter.next()));
    assert !resIter.hasNext();
  }

  @Test public void asTestbit() {
    azzert.that(1, is(as.bit(true)));
    azzert.that(0, is(as.bit(false)));
  }

  @Test public void asTestEmptyIntegerList() {
    azzert.that(new ArrayList<Integer>(), is(as.ingeterList()));
  }

  @Test public void asTestNotEmptyIntegerList() {
    final List<Integer> res = as.ingeterList(1, 2, 3), list = new ArrayList<>();
    list.add(box.it(1));
    list.add(box.it(2));
    list.add(box.it(3));
    azzert.that(list, is(res));
  }

  @Test public void asTestIntArray() {
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, as.intArray(1, 2, 3, 4));
  }

  @Test public void asTestIterator() {
    final Iterator<Integer> resIter = as.iterator(box.it(1), box.it(2), box.it(3));
    assert resIter.hasNext();
    azzert.that(box.it(1), is(resIter.next()));
    assert resIter.hasNext();
    azzert.that(box.it(2), is(resIter.next()));
    assert resIter.hasNext();
    azzert.that(box.it(3), is(resIter.next()));
    assert !resIter.hasNext();
  }

  @Test public void asTestlist() {
    azzert.that(Arrays.asList("A", "B", "C"), is(as.list("A", "B", "C")));
  }

  @Test public void asTestSet() {
    final Set<Integer> set = new HashSet<>();
    set.add(box.it(1));
    set.add(box.it(2));
    set.add(box.it(3));
    azzert.that(set, is(as.set(box.it(1), box.it(1), box.it(2), box.it(3), box.it(2), box.it(3), box.it(1), box.it(2), box.it(3))));
  }

  @Test public void asTestString() {
    String res = as.string(null);
    azzert.that("null", is(res));
    res = as.string("test");
    azzert.that("test", is(res));
    res = as.string('b');
    azzert.that("b", is(res));
    final Object obj = new Object();
    res = as.string(obj);
    azzert.that(obj + "", is(res));
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
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }
}
