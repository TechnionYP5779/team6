package fluent.ly;

import org.junit.Test;

import java.util.ArrayList;

import static fluent.ly.azzert.*;

@SuppressWarnings({ "null", "static-method", "boxing" }) public class theTest {
  @Test public void theTestIndexFound() {
    azzert.that(1, azzert.is(the.index(2, 1, 2, 3)));
  }

  @Test public void theTestIndexNotFound() {
    azzert.that(-1, azzert.is(the.index(5, 1, 2, 3)));
  }

  @Test public void theTestNil() {
    azzert.assertNull(the.nil());
  }

  @Test public void theTestnth1() {
    azzert.that(" #1/3", azzert.is(the.nth(1, 3)));
  }

  @Test public void theTestnth2() {
    azzert.that(" #1/3", azzert.is(the.nth("1", "3")));
  }

  @Test public void theTestpenultimateOf1() {
    azzert.assertNull(the.penultimateOf(null));
  }

  @Test public void theTestpenultimateOf2() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    azzert.assertNull(the.penultimateOf(arr));
  }

  @Test public void theTestpenultimateOf3() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    azzert.that(Box.box(2), azzert.is(the.penultimateOf(arr)));
  }

  @Test public void theTestPreviousNull() {
    azzert.assertNull(the.previous(1, null));
  }

  @Test public void theTestPreviousNull2() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    azzert.assertNull(the.previous(1, arr));
  }

  @Test public void theTestPreviousNotNull() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    azzert.that(Box.box(2), azzert.is(the.previous(3, arr)));
  }

  @Test public void theTestHeadNull() {
    azzert.assertNull(the.headOf(null));
  }

  @Test public void theTestHeadNull2() {
    azzert.assertNull(the.headOf(new ArrayList<>()));
  }

  @Test public void theTestHeadNotNull() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    azzert.that(Box.box(1), azzert.is(the.headOf(arr)));
  }

  @Test public void theTestTailOf() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    ArrayList<Integer> res = new ArrayList<>();
    res.add(2);
    res.add(3);
    azzert.that(res, azzert.is(the.tailOf(arr)));
  }

  @Test public void theTestTailOfString() {
    azzert.that("est", is(the.tailOf("test")));
  }

  @Test public void theTestRest() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    ArrayList<Integer> res = new ArrayList<>();
    res.add(2);
    res.add(3);
    azzert.that(res, azzert.is(the.rest(1, arr)));
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
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    azzert.that(Box.box(1), is(the.lastOf(arr)));
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
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    azzert.that(Box.box(1), is(the.onlyOneOf(arr)));
  }

  @Test public void theTestOnlyOneOfNull2() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    azzert.assertNull(the.onlyOneOf(arr));
  }

  @Test public void theTestsecondOfNull1() {
    azzert.assertNull(the.secondOf(null));
  }

  @Test public void theTestsecondOfNull2() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    azzert.assertNull(the.secondOf(arr));
  }

  @Test public void theTestsecondOfNotNull() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    azzert.that(Box.box(2), is(the.secondOf(arr)));
  }

  @Test public void theTestMax() {
    azzert.that(4, is(the.max(1, 2, 3, 4)));
  }

  @Test public void theTestMin() {
    azzert.that(1, is(the.min(1, 2, 3, 4)));
  }

  @Test public void theTestLastOfArray() {
    azzert.that(Box.box(4), is(the.lastOf(new Integer[] { 1, 2, 3, 4 })));
  }

  @Test public void theTestLastNull1() {
    azzert.assertNull(the.last(null));
  }

  @Test public void theTestLastNull2() {
    azzert.assertNull(the.last(new ArrayList<>()));
  }

  @Test public void theTestLastNotNull() {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    azzert.that(Box.box(3), is(the.last(arr)));
  }

  @Test public void theTestsqr() {
    azzert.that(4, is(the.sqr(2)));
  }

  @Test public void theTestTailOfArray() {
    azzert.that(new Integer[] { 2, 3, 4 }, is(the.tailOf(new Integer[] { 1, 2, 3, 4 })));
  }

  @Test public void theTestRestString() {
    azzert.that("est", azzert.is(the.rest("test")));
  }
}
