package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;
import static il.org.spartan.iterables.iterables.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;


import fluent.ly.*;

@SuppressWarnings("static-method") public class iterablesTest {
  @Test public void containsDegenerate() {
    assert !contains("Hello");
  }

  @Test public void containseturnsFalseTypical() {
    assert !contains("Hello", null, "x", "y", null, "z", "w", "u", "v");
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
    azzert.that(0, is(count(null)));
  }

  @Test public void countDoesNotIncludeNull() {
    azzert.that(3, is(count(iterable.over(null, "One", null, "Two", null, "Three"))));
  }

  @Test public void countEmpty() {
    azzert.that(0, is(count(iterables.<String> empty())));
  }

  @Test public void countSingleton() {
    azzert.that(1, is(count(iterable.singleton(new Object()))));
  }

  @Test public void countThree() {
    azzert.that(3, is(count(iterable.over("One", "Two", "Three"))));
  }

  @Test(expected = NullPointerException.class) public void isEmptyNullParmeter() {
    iterables.isEmpty(null);
  }

  @Test public void isEmpty() {
    assert iterables.isEmpty(iterables.<String> empty());
    assert !iterables.isEmpty(iterable.over("One", "Two", "Three"));
    assert !iterables.isEmpty(iterable.singleton(new Object()));
    assert iterables.isEmpty(iterable.singleton(null));
  }

  private static <T> Collection<T> toCollection(final Iterable<T> ts) {
    final Collection<T> list = new ArrayList<>();
    for (final T $ : ts)
      list.add($);
    return list;
  }

  @Test @SuppressWarnings("null") public void singletonIterator() {
    azzert.assertCollectionsEqual(toCollection(iterable.over(box.it(1))), toCollection(() -> iterables.singletonIterator(box.it(1))));
    azzert.assertCollectionsEqual(toCollection(iterable.over("one")), toCollection(() -> iterables.singletonIterator("one")));
  }

  @Test @SuppressWarnings("null") public void alternateNull() {
    final Iterable<Integer> i1 = iterable.over(box.it(1), box.it(3), box.it(5));
    azzert.assertNull(iterables.alternate(null, null));
    azzert.notNull(iterables.alternate(i1, null));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, null)), toCollection(i1));
    azzert.notNull(iterables.alternate(null, i1));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(null, i1)), toCollection(i1));
  }

  @Test @SuppressWarnings("null") public void alternateIterablesWithSameLength() {
    final Iterable<Integer> i1 = iterable.over(box.it(1), box.it(3), box.it(5)), i2 = iterable.over(box.it(2), box.it(4), box.it(6));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, i2)),
        toCollection(iterable.over(box.it(1), box.it(2), box.it(3), box.it(4), box.it(5), box.it(6))));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i2, i1)),
        toCollection(iterable.over(box.it(2), box.it(1), box.it(4), box.it(3), box.it(6), box.it(5))));
  }

  @Test @SuppressWarnings("null") public void alternateIterablesWithoutSameLength() {
    final Iterable<Integer> i1 = iterable.over(box.it(1), box.it(3), box.it(5), box.it(7), box.it(9), box.it(11)),
        i2 = iterable.over(box.it(1), box.it(3)), i3 = iterable.over(box.it(2), box.it(4), box.it(6));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, i2)),
        toCollection(iterable.over(box.it(1), box.it(1), box.it(3), box.it(3), box.it(5), box.it(7), box.it(9), box.it(11))));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i2, i1)),
        toCollection(iterable.over(box.it(1), box.it(1), box.it(3), box.it(3), box.it(5), box.it(7), box.it(9), box.it(11))));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i1, i3)),
        toCollection(iterable.over(box.it(1), box.it(2), box.it(3), box.it(4), box.it(5), box.it(6), box.it(7), box.it(9), box.it(11))));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i3, i1)),
        toCollection(iterable.over(box.it(2), box.it(1), box.it(4), box.it(3), box.it(6), box.it(5), box.it(7), box.it(9), box.it(11))));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i2, i3)),
        toCollection(iterable.over(box.it(1), box.it(2), box.it(3), box.it(4), box.it(6))));
    azzert.assertCollectionsEqual(toCollection(iterables.alternate(i3, i2)),
        toCollection(iterable.over(box.it(2), box.it(1), box.it(4), box.it(3), box.it(6))));
  }
}
