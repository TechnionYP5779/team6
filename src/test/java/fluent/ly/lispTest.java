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
    azzert.assertNull(lisp.replace(null, Box.it(2), 4));
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
  
  //added for coverage
  @Test public void lispRest2() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("a");
    arr.add("b");
    arr.add("c");
    arr.add("z");
    int c = 0;
    for(String ¢ : lisp.rest2(arr)) {
      azzert.that(¢, is(arr.get(c+2)));
      ++c;
    }
    azzert.that(Box.it(2), is(c));
  }
  
  @Test public void areEqualTest() {
    assert !lisp.areEqual(null, null, null);
    assert !lisp.areEqual(null);
    
    assert !lisp.areEqual(null, Box.it(1), Box.it(1));
    
    assert !lisp.areEqual(Box.it(1), Box.it(1), Box.it(2));
    
    assert !lisp.areEqual(Box.it(2), Box.it(1), Box.it(1));
    
    assert !lisp.areEqual(Box.it(1), Box.it(1), Box.it(1), Box.it(2));
    
    assert lisp.areEqual(Box.it(1), Box.it(1),  Box.it(1));
    
    assert !lisp.areEqual(Box.it(true), Box.it(true), Box.it(false));
    
    assert lisp.areEqual(Box.it(true), Box.it(true), Box.it(true));

  }
  @Test public void chopLastListTest() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("a");
    arr.add("b");
    arr.add("c");
    arr.add("d");
    arr.add("e");
    
    azzert.that("d", is(lisp.chopLast(arr).get(arr.size()-2)));
    
    azzert.that("c", is(lisp.chopLast(lisp.chopLast(arr)).get(arr.size()-3)));
    
    azzert.that(Box.it(4), is(lisp.chopLast(arr).size()));
    
    azzert.that(Box.it(3), is(lisp.chop(lisp.chopLast(arr)).size()));
  }
  
  @Test public void chopLastStringTest() {
      final String str = "aba";
      azzert.that("ab", is(lisp.chopLast(str)));
      azzert.that("a", is(lisp.chopLast(lisp.chopLast(str))));
  }
  
  @Test public void removeFromListTest() {
    final ArrayList<String> arr1 = new ArrayList<>();
    final ArrayList<String> arr2 = new ArrayList<>();
    arr1.add("a");
    arr1.add("b");
    arr1.add("c");
    arr1.add("d");
    arr2.add("b");
    arr2.add("c");
    lisp.removeFromList(arr2, arr1);
    azzert.that(Box.it(2), is(arr1.size()));
    azzert.that("a", is(arr1.get(0)));
    azzert.that("d", is(arr1.get(1)));    
  }
  
  @Test public void removeLastTest() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("a");
    arr.add("b");
    arr.add("c");
    arr.add("d");
    lisp.removeLast(arr);
    azzert.that(Box.it(3), is(arr.size()));
    azzert.that("c", is(arr.get(arr.size()-1)));
  }
  
  @Test public void swapTest() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("a");
    arr.add("b");
    arr.add("c");
    arr.add("d");
    azzert.that(arr, is(lisp.swap(arr, 3, 4)));
    azzert.that(arr, is(lisp.swap(arr, 4, 3)));
    azzert.that(arr, is(lisp.swap(arr, 3, 3)));
    azzert.that(arr, is(lisp.swap(arr, 1, 3)));
  }
  
  
  
}
