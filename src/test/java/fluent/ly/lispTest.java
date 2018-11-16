package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class lispTest {
  @Test public void lispTestChopNull() {
    azzert.assertNull(lisp.chop(new ArrayList<>()));
  }

  @Test public void lispTestChopNotNull() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    final ArrayList<String> res = new ArrayList<>();
    res.add("a");
    azzert.that(res, is(lisp.chop(arr)));
  }

  @Test public void lispTestCons() {
    final ArrayList<String> arr = new ArrayList<>(), res = new ArrayList<>();
    res.add("a");
    azzert.that(res, is(lisp.cons("a", arr)));
  }

  @Test public void lispTestNext1() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.next(0, arr)));
  }

  @Test public void lispTestNext2() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.next(9, arr)));
  }

  @Test public void lispTestGetNull() {
    azzert.assertNull(lisp.get(null, 2));
  }

  @Test public void lispTestGetNotNull() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.get(arr, 0)));
  }

  @Test public void lispTestPrevZero() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("h", is(lisp.prev(0, arr)));
  }

  @Test public void lispTestPrevNotZero() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.prev(2, arr)));
  }

  @Test public void lispTestReplaceNull() {
    azzert.assertNull(lisp.replace(null, Box.box(2), 4));
  }

  @Test public void lispTestReplaceNegIndex() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that(arr, is(lisp.replace(arr, "fd", -4)));
  }

  @Test public void lispTestReplaceBadIndex() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that(arr, is(lisp.replace(arr, "fd", 32)));
  }

  @Test public void lispTestReplace() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    final ArrayList<String> res = new ArrayList<>();
    res.add("a");
    res.add("a");
    azzert.that(res, is(lisp.replace(arr, "a", 0)));
  }

  @Test public void lispTestReplaceFirst() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    final ArrayList<String> res = new ArrayList<>();
    res.add("a");
    res.add("a");
    azzert.that(res, is(lisp.replaceFirst(arr, "a")));
  }

  @Test public void lispTestReplaceLast() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("h");
    final ArrayList<String> res = new ArrayList<>();
    res.add("h");
    res.add("a");
    azzert.that(res, is(lisp.replaceLast(arr, "a")));
  }
}
