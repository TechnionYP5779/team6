package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import il.org.spartan.utils.*;

public class englishTest {
  // @Test
  // public void englishTestIndefinite1(){
  // String s = "str";
  // azzert.that(English.indefinite(s), is("a str"));
  //
  //
  // azzert.that(English.indefinite(1.1), is("an Double"));
  // azzert.that(English.indefinite("StrinG"), is("a StrinG"));
  // }
  //
  // @Test
  // public void englishTestIndefinite2(){
  // Integer i = 1;
  // azzert.that(English.indefinite(i), is("a Integer"));
  // }
  //
  // @Test
  // public void englishTestIndefinite3(){
  // azzert.that(English.indefinite(1.1), is("an Double"));
  // }
  @Test public void englishTestList1() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    azzert.that(English.list(arr), is("hi"));
  }

  @Test public void englishTestList2() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    arr.add("bye");
    azzert.that(English.list(arr), is("hi and bye"));
  }

  @Test public void englishTestlowerFirstLetter() {
    azzert.that(English.lowerFirstLetter("Hi"), is("hi"));
    English.lowerFirstLetter("");
  }

  @Test public void englishTestplurales1() {
    azzert.that(English.plurales("apple", 1), is("one apple"));
  }

  @Test public void englishTestplurales2() {
    azzert.that(English.plurales("apple", (Integer) null), is("??? applees"));
  }

  @Test public void englishTestplurales3() {
    azzert.that(English.plurales("apple", Integer.valueOf(1)), is("one apple"));
  }

  @Test public void englishTestplurales4() {
    azzert.that(English.plurales("apple", Integer.valueOf(2)), is("2 applees"));
  }

  @Test public void englishTestplurales5() {
    azzert.that(English.plurales("apple", 2), is("2 applees"));
  }

  @Test public void englishTestplurales6() {
    azzert.that(English.plurales("apple", Int.valueOf(1)), is("one apple"));
  }

  @Test public void englishTestplurales7() {
    azzert.that(English.plurales("apple", Int.valueOf(2)), is("2 applees"));
  }

  // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  @Test public void englishTestplurals1() {
    azzert.that(English.plurals("apple", 1), is("one apple"));
  }

  @Test public void englishTestplurals2() {
    azzert.that(English.plurals("apple", (Integer) null), is("??? apples"));
  }

  @Test public void englishTestplurals3() {
    azzert.that(English.plurals("apple", Integer.valueOf(1)), is("one apple"));
  }

  @Test public void englishTestplurals4() {
    azzert.that(English.plurals("apple", Integer.valueOf(2)), is("2 apples"));
  }

  @Test public void englishTestplurals5() {
    azzert.that(English.plurals("apple", 2), is("2 apples"));
  }

  @Test public void englishTestplurals6() {
    azzert.that(English.plurals("apple", Int.valueOf(1)), is("one apple"));
  }

  @Test public void englishTestplurals7() {
    azzert.that(English.plurals("apple", Int.valueOf(2)), is("2 apples"));
  }

  @Test public void englishTestPronounce() {
    String[] resArr = { "aey", "bee", "see", "dee", "eae", "eff", "gee", "eitch", "eye", "jay", "kay", "ell", "em", "en", "oh", "pee", "queue", "ar",
        "ess", "tee", "you", "vee", "some character", "exx", "why", "zee" };
    for (int i = 0; i < 26; i++) {
      azzert.that(English.pronounce((char) (i + 'a')), is(resArr[i]));
    }
    azzert.that(English.pronounce('A'), is("aey"));
  }

  @Test public void englishTestRepeat() {
    azzert.that(English.repeat(2, 'h'), is("hh"));
  }

  @Test public void englishTestTime() {
    long time = 222222222;
    azzert.that(English.time(time), is("0.22"));
  }

  @Test public void englishTestTrimeNull() {
    azzert.assertNull(English.trim(null));
  }

  @Test public void englishTestTrimeNotNull() {
    azzert.that(English.trim("hello world"), is("hello world"));
  }

  @Test public void englishTestTrimeNotAbs() {
    azzert.that(English.trimAbsolute("hello world", 10, "bye world"), is("hbye world"));
  }

  @Test public void englishTestupperFirstLetter1() {
    azzert.that(English.upperFirstLetter("hello world"), is("Hello world"));
  }
}
