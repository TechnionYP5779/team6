package il.org.spartan;

import static il.org.spartan.Utils.*;
import static il.org.spartan.utils.Permutation.swap;
import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

/**
* For tested interface please see {@link il.org.spartan.Utils} .
*/
@SuppressWarnings({ "null", "static-method" }) public class UtilsTest {
  @NotNull public static Integer[] intToIntegers(final int... is) {
    final Integer @NotNull [] $ = new Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }

  @Test @SuppressWarnings("unchecked") public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    assert !ss.contains("E");
    assert !ss.contains(null);
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    assert !ss.contains("E");
    assert !ss.contains(null);
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
    assert ss.contains("A");
  }

  @Test public void cantBeNullOfNull() {
    try {
      cantBeNull(null);
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void cantBeNullTypical() {
    assert cantBeNull(new Object()) != null;
  }

  @Test public void isNullTypical() {
    try {
      isNull(mustBeNull(null));
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void mustBeNullOfNotNull() {
    try {
      mustBeNull(new Object());
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void quoteEmptyString() {
    azzert.that(idiomatic.quote(""), is("''"));
  }

  @Test public void quoteNull() {
    azzert.that(idiomatic.quote(null), is("<null reference>"));
  }

  @Test public void quoteSimpleString() {
    azzert.that(idiomatic.quote("A"), is("'A'"));
  }

  @Test public void swapDegenerate() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 1);
    assertArrayEquals(as.array("A", "B", "C", "D"), ss);
  }

  @Test public void swapTypical() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 2);
    assertArrayEquals(as.array("A", "C", "B", "D"), ss);
  }

  @Test public void swapTypicalCase() {
    final Integer @NotNull [] $ = intToIntegers(29, 1, 60);
    swap($, 0, 1);
    assertArrayEquals(intToIntegers(1, 29, 60), $);
  }

  @Test public void append() {
    final Integer[] arr = new Integer[2];
    arr[0] = box.it(0);
    arr[1] = box.it(1);
    final Integer[] arrPlusOne = new Integer[3];
    arrPlusOne[0] = box.it(0);
    arrPlusOne[1] = box.it(1);
    arrPlusOne[2] = box.it(2);
    assertArrayEquals(Utils.append(arr, box.it(2)), arrPlusOne);
  }

  @Test public void cantBeNullTest1() {
    azzert.that(Utils.cantBeNull("string"), is("string"));
  }

  @Test(expected = java.lang.AssertionError.class) public void cantBeNullTest2() {
    Utils.cantBeNull(null);
  }

  @Test public void compare() {
    azzert.that(Utils.compare(true, true), is(0));
    azzert.that(Utils.compare(true, false), is(1));
    azzert.that(Utils.compare(false, true), is(-1));
  }

  @Test public void compressSpaces() {
    azzert.that(Utils.compressSpaces("1 + 2"), is("1+2"));
    azzert.that(Utils.compressSpaces("     2"), is("2"));
  }

  @Test public void contains() {
    assert !Utils.contains("abc def ", "zz", "xx");
    assert Utils.contains("abc def ", "zz", "xx", "c d");
  }

  @Test public void delete() {
    final Integer[] arr = new Integer[5];
    arr[0] = box.it(0);
    arr[1] = box.it(1);
    arr[2] = box.it(2);
    arr[3] = box.it(3);
    arr[4] = box.it(4);
    final Integer[] arr2 = new Integer[4];
    arr2[0] = box.it(0);
    arr2[1] = box.it(1);
    arr2[2] = box.it(3);
    arr2[3] = box.it(4);
    final Integer[] arr0 = new Integer[4];
    arr0[0] = box.it(1);
    arr0[1] = box.it(2);
    arr0[2] = box.it(3);
    arr0[3] = box.it(4);
    assertArrayEquals(Utils.delete(arr, 0), arr0);
  }

  @Test public void found() {
    final FoundHandleForT.FoundHandleForInt f1 = Utils.found(10);
    assert f1.in(9, 10, 11);
    assert !f1.in(9, 11);
    final FoundHandleForT<String> f2 = Utils.found("s");
    assert f2.in("a", "b", "s");
    assert !f2.in("a", "b");
  }

  @Test public void hasNull() {
    assert Utils.hasNull("a", "b", null, "s");
    assert !Utils.hasNull("a", "b", "s");
  }

  @Test public void inRange() {
    final List<Integer> list = new ArrayList<>();
    assert !Utils.inRange(1, list);
    list.add(0, box.it(1));
    assert Utils.inRange(0, list);
    list.add(1, box.it(1));
    assert Utils.inRange(1, list);
  }

  @Test public void intIsIn() {
    assert Utils.intIsIn(1, 2, 3, 3, 1, 2);
    assert !Utils.intIsIn(1, 2, 3, 3, 2);
  }

  @Test public void lastIn() {
    final List<Integer> list = new ArrayList<>();
    list.add(0, box.it(0));
    list.add(1, box.it(1));
    list.add(2, box.it(2));
    assert !Utils.lastIn(box.it(1), list);
    assert Utils.lastIn(box.it(2), list);
  }

  @Test public void mustBeNull1() {
    azzert.assertNull(Utils.mustBeNull(null));
  }

  /* @Test public void penultimateIn() { List<Integer> list = new ArrayList<>();
   * list.add(0, box.it(0)); list.add(1, box.it(1)); list.add(2, box.it(2));
   * assert Utils.penultimateIn(box.it(2),list); assert
   * !Utils.penultimateIn(box.it(0),list); } */
  @Test public void prependChar() {
    azzert.that(Utils.prepend(new StringBuilder(), 'c') + "", is("c"));
    azzert.that(Utils.prepend(new StringBuilder().append("ab"), 'c') + "", is("cab"));
  }

  @Test public void prependString() {
    azzert.that(Utils.prepend(new StringBuilder(), "c") + "", is("c"));
    azzert.that(Utils.prepend(new StringBuilder().append("ab"), "c") + "", is("cab"));
  }

  @Test public void quote() {
    azzert.that(Utils.quote(null), is("<null reference>"));
    azzert.that(Utils.quote("a"), is("'a'"));
  }

  @Test public void removeDuplicates() {
    final List<Integer> list = new ArrayList<>();
    list.add(0, box.it(0));
    list.add(1, box.it(1));
    list.add(2, box.it(0));
    Utils.removeDuplicates(list);
    azzert.that(list.size(), is(2));
    assert list.contains(box.it(0));
    assert list.contains(box.it(1));
  }

  @Test public void removePrefix() {
    azzert.that(Utils.removePrefix("abc", "ab"), is("c"));
  }

  @Test public void removeSuffix() {
    azzert.that(Utils.removeSuffix("abc", "bc"), is("a"));
  }

  @Test public void removeWhites() {
    azzert.that(Utils.removeWhites(" a b    c"), is("abc"));
  }

  @Test public void sort() {
    final int[] arr = new int[4];
    arr[0] = 6;
    arr[1] = 4;
    arr[2] = 8;
    arr[3] = 1;
    final int[] sorted = new int[4];
    sorted[0] = 1;
    sorted[1] = 4;
    sorted[2] = 6;
    sorted[3] = 8;
    azzert.that(Utils.sort(arr), is(sorted));
  }

  @Test public void sqr() {
    azzert.that(Utils.sqr(3.0), is(9.0));
  }

  @Test public void suffixedBy() {
    final List<String> stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");
    assert Utils.suffixedBy("abc", stringList);
    assert !Utils.suffixedBy("abg", stringList);
    assert Utils.suffixedBy("abc", "c");
    assert Utils.suffixedBy("abc", "g", "c");
    assert !Utils.suffixedBy("abc", "g", "f");
  }

  @Test public void swapTest() {
    final Integer[] arr = new Integer[4];
    arr[0] = box.it(1);
    arr[1] = box.it(3);
    arr[2] = box.it(2);
    arr[3] = box.it(4);
    Utils.swap(arr, 1, 2);
    azzert.that(arr[0], is(box.it(1)));
    azzert.that(arr[1], is(box.it(2)));
    azzert.that(arr[2], is(box.it(3)));
    azzert.that(arr[3], is(box.it(4)));
  }
}
