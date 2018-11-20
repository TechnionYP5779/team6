package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class theTest {
  @Test public void theTestIndexFound() {
    azzert.that(1, is(the.index(2, 1, 2, 3)));
  }

  @Test public void theTestIndexNotFound() {
    azzert.that(-1, is(the.index(5, 1, 2, 3)));
  }

  @Test public void theTestNil() {
    azzert.assertNull(the.nil());
  }

  @Test public void theTestnth1() {
    azzert.that(" #1/3", is(the.nth(1, 3)));
  }

  @Test public void theTestnth2() {
    azzert.that(" #1/3", is(the.nth("1", "3")));
  }

  @Test public void theTestpenultimateOf1() {
    azzert.assertNull(the.penultimateOf(null));
  }

  @Test public void theTestpenultimateOf2() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    azzert.assertNull(the.penultimateOf(arr));
  }

  @Test public void theTestpenultimateOf3() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    azzert.that(Box.it(2), is(the.penultimateOf(arr)));
  }

  @Test public void theTestPreviousNull() {
    azzert.assertNull(the.previous(Box.it(1), null));
  }

  @Test public void theTestPreviousNull2() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    azzert.assertNull(the.previous(Box.it(1), arr));
  }

  @Test public void theTestPreviousNotNull() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    azzert.that(Box.it(2), is(the.previous(Box.it(3), arr)));
  }

  @Test public void theTestHeadNull() {
    azzert.assertNull(the.headOf(null));
  }

  @Test public void theTestHeadNull2() {
    azzert.assertNull(the.headOf(new ArrayList<>()));
  }

  @Test public void theTestHeadNotNull() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    azzert.that(Box.it(1), is(the.headOf(arr)));
  }

  @Test public void theTestTailOf() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    final ArrayList<Integer> res = new ArrayList<>();
    res.add(Box.it(2));
    res.add(Box.it(3));
    azzert.that(res, is(the.tailOf(arr)));
  }

  @Test public void theTestTailOfString() {
    azzert.that("est", is(the.tailOf("test")));
  }

  @Test public void theTestRest() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    final ArrayList<Integer> res = new ArrayList<>();
    res.add(Box.it(2));
    res.add(Box.it(3));
    azzert.that(res, is(the.rest(Box.it(1), arr)));
  }

  @Test public void theTestcharacterOf() {
    azzert.that('t', is(the.characterOf("test")));
  }

  @Test public void theTestIth() {
    azzert.that('e', is(the.ith("test", 1)));
  }

  @Test public void theTestLastOfNull1() {
    azzert.assertNull(the.lastOf((ArrayList<Integer>) null));
  }

  @Test public void theTestLastOfNull2() {
    azzert.assertNull(the.last(new ArrayList<>()));
  }

  @Test public void theTestLastOfNotNull() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    azzert.that(Box.it(1), is(the.lastOf(arr)));
  }

  @Test public void theTestLastOfString() {
    azzert.that('t', is(the.lastOf("test")));
  }

  @Test public void theTestbeforeLastOf() {
    azzert.that('s', is(the.beforeLastOf("test", 1)));
  }

  @Test public void theTestOnlyOneOfNull1() {
    azzert.assertNull(the.onlyOneOf(null));
  }

  @Test public void theTestOnlyOneOfNotNull() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    azzert.that(Box.it(1), is(the.onlyOneOf(arr)));
  }

  @Test public void theTestOnlyOneOfNull2() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    azzert.assertNull(the.onlyOneOf(arr));
  }

  @Test public void theTestsecondOfNull1() {
    azzert.assertNull(the.secondOf(null));
  }

  @Test public void theTestsecondOfNull2() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    azzert.assertNull(the.secondOf(arr));
  }

  @Test public void theTestsecondOfNotNull() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    azzert.that(Box.it(2), is(the.secondOf(arr)));
  }

  @Test public void theTestMax() {
    azzert.that(4, is(the.max(1, 2, 3, 4)));
  }

  @Test public void theTestMin() {
    azzert.that(1, is(the.min(1, 2, 3, 4)));
  }

  @Test public void theTestLastOfArray() {
    azzert.that(Box.it(4), is(the.lastOf(new Integer[] { Box.it(1), Box.it(2), Box.it(3), Box.it(4) })));
  }

  @Test public void theTestLastNull1() {
    azzert.assertNull(the.last(null));
  }

  @Test public void theTestLastNull2() {
    azzert.assertNull(the.last(new ArrayList<>()));
  }

  @Test public void theTestLastNotNull() {
    final ArrayList<Integer> arr = new ArrayList<>();
    arr.add(Box.it(1));
    arr.add(Box.it(2));
    arr.add(Box.it(3));
    azzert.that(Box.it(3), is(the.last(arr)));
  }

  @Test public void theTestsqr() {
    azzert.that(4, is(the.sqr(2)));
  }

  @Test public void theTestTailOfArray() {
    azzert.that(new Integer[] { Box.it(2), Box.it(3), Box.it(4) }, is(the.tailOf(new Integer[] { Box.it(1), Box.it(2), Box.it(3), Box.it(4) })));
  }

  @Test public void theTestRestString() {
    azzert.that("est", is(the.rest("test")));
  }
}
