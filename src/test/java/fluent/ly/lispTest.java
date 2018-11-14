package fluent.ly;

import java.util.*;

import org.junit.*;
import static fluent.ly.azzert.*;
@SuppressWarnings({ "static-method", "null" }) public class lispTest {
  @Test public void lispTestChopNull() {
    azzert.assertNull(lisp.chop(new ArrayList<>()));
  }

  @Test public void lispTestChopNotNull() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    ArrayList<String> res = new ArrayList<>();
    res.add("a");
    azzert.that(res, is(lisp.chop(arr)));
  }

  @Test public void lispTestCons() {
    ArrayList<String> arr = new ArrayList<>(), res = new ArrayList<>();
    res.add("a");
    azzert.that(res, is(lisp.cons("a", arr)));
  }

  @Test public void lispTestNext1() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.next(0, arr)));
  }

  @Test public void lispTestNext2() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.next(9, arr)));
  }

  @Test public void lispTestGetNull() {
    azzert.assertNull(lisp.get(null, 2));
  }

  @Test public void lispTestGetNotNull() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.get(arr, 0)));
  }

  @Test public void lispTestPrevZero() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("h", is(lisp.prev(0, arr)));
  }

  @Test public void lispTestPrevNotZero() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that("a", is(lisp.prev(2, arr)));
  }

  @Test public void lispTestReplaceNull() {
    azzert.assertNull(lisp.replace(null, Box.box(2), 4));
  }

  @Test public void lispTestReplaceNegIndex() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that(arr, is(lisp.replace(arr, "fd", -4)));
  }

  @Test public void lispTestReplaceBadIndex() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    azzert.that(arr, is(lisp.replace(arr, "fd", 32)));
  }

  @Test public void lispTestReplace() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    ArrayList<String> res = new ArrayList<>();
    res.add("a");
    res.add("a");
    azzert.that(res, is(lisp.replace(arr, "a", 0)));
  }

  @Test public void lispTestReplaceFirst() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("a");
    ArrayList<String> res = new ArrayList<>();
    res.add("a");
    res.add("a");
    azzert.that(res, is(lisp.replaceFirst(arr, "a")));
  }

  @Test public void lispTestReplaceLast() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("h");
    arr.add("h");
    ArrayList<String> res = new ArrayList<>();
    res.add("h");
    res.add("a");
    azzert.that(res, is(lisp.replaceLast(arr, "a")));
  }
}
