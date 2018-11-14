package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;
import static il.org.spartan.iterables.iterables.*;

import java.util.*;

import org.junit.*;

import an.*;
import fluent.ly.*;

@SuppressWarnings("static-method") public class iterablesTest {
  @Test public void containsDegenerate() {
    azzert.nay(contains("Hello"));
  }

  @Test public void containseturnsFalseTypical() {
    azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
  }

  @Test public void containsSimple() {
    azzert.aye("", contains("Hello", "e"));
  }

  @Test public void containsTypical() {
    azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
  }

  @Test public void containsWithNulls() {
    azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
  }

  @Test public void countNullParmeter() {
    azzert.assertEquals(0, count(null));
  }

  @Test public void countDoesNotIncludeNull() {
    azzert.assertEquals(3, count(iterable.over(null, "One", null, "Two", null, "Three")));
  }

  @Test public void countEmpty() {
    azzert.assertEquals(0, count(iterables.<String> empty()));
  }

  @Test public void countSingleton() {
    azzert.assertEquals(1, count(iterable.singleton(new Object())));
  }

  @Test public void countThree() {
    azzert.assertEquals(3, count(iterable.over("One", "Two", "Three")));
  }

  @Test(expected = NullPointerException.class) public void isEmptyNullParmeter() {
    iterables.isEmpty(null);
  }

  @Test public void isEmpty() {
    azzert.assertTrue(iterables.isEmpty(iterables.<String> empty()));
    azzert.assertFalse(iterables.isEmpty(iterable.over("One", "Two", "Three")));
    azzert.assertFalse(iterables.isEmpty(iterable.singleton(new Object())));
    azzert.assertTrue(iterables.isEmpty(iterable.singleton(null)));
  }

  private static <T> Collection<T> toCollection(Iterable<T> it) {
    Collection<T> list = new ArrayList<>();
    for (T $ : it)
      list.add($);
    return list;
  }

  @Test @SuppressWarnings({ "boxing", "null" }) public void singletonIterator() {
    azzert.assertCollectionsEqual(toCollection(iterable.over(1)), toCollection(() -> iterables.singletonIterator(1)));
    azzert.assertCollectionsEqual(toCollection(iterable.over("one")), toCollection(() -> iterables.singletonIterator("one")));
  }

  @Test @SuppressWarnings({ "boxing", "null" }) public void alternateNull() {
    Iterable<Integer> i1 = iterable.over(1, 3, 5);
    azzert.assertNull(iterables.alternate(null, null));
    azzert.notNull(iterables.alternate(i1, null));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, null)), toCollection(i1));
    azzert.notNull(iterables.alternate(null, i1));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(null, i1)), toCollection(i1));
  }

  @SuppressWarnings({ "boxing", "null" }) @Test public void alternateIterablesWithSameLength() {
    Iterable<Integer> i1 = iterable.over(1, 3, 5);
    Iterable<Integer> i2 = iterable.over(2, 4, 6);
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, i2)), toCollection(iterable.over(1, 2, 3, 4, 5, 6)));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i2, i1)), toCollection(iterable.over(2, 1, 4, 3, 6, 5)));
  }

  @SuppressWarnings({ "boxing", "null" }) @Test public void alternateIterablesWithoutSameLength() {
    Iterable<Integer> i1 = iterable.over(1, 3, 5, 7, 9, 11);
    Iterable<Integer> i2 = iterable.over(1, 3);
    Iterable<Integer> i3 = iterable.over(2, 4, 6);
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, i2)), toCollection(iterable.over(1, 1, 3, 3, 5, 7, 9, 11)));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i2, i1)), toCollection(iterable.over(1, 1, 3, 3, 5, 7, 9, 11)));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, i3)), toCollection(iterable.over(1, 2, 3, 4, 5, 6, 7, 9, 11)));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i3, i1)), toCollection(iterable.over(2, 1, 4, 3, 6, 5, 7, 9, 11)));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i2, i3)), toCollection(iterable.over(1, 2, 3, 4, 6)));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i3, i2)), toCollection(iterable.over(2, 1, 4, 3, 6)));
  }
}
