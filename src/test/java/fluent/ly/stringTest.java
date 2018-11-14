package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method", "boxing" }) public class stringTest {
  @Test public void stringTestAtod() {
    azzert.that(Double.valueOf("2.2"), azzert.is(string.atod("2.2")));
  }

  @Test public void stringTestAtof() {
    azzert.that(Float.valueOf("2.2"), azzert.is(string.atof("2.2")));
  }

  @Test public void stringTestAtoi() {
    azzert.that(1, azzert.is(string.atoi("1")));
  }

  @Test public void stringTestAtol() {
    azzert.that(1L, azzert.is(string.atol("1")));
  }

  @Test public void stringTestcapitalizeEmpty() {
    azzert.that("", azzert.is(string.capitalize("")));
  }

  @Test public void stringTestcapitalizeNotEmpty() {
    azzert.that("Test", azzert.is(string.capitalize("test")));
  }

  @Test public void stringTestcat() {
    azzert.that("my name is weird Al", azzert.is(string.cat("my", " ", "name", " ", "is", " ", "weird", " ", "Al")));
  }

  @Test public void stringTestcat2() {
    azzert.that("my name is weird Al", azzert.is(string.cat(new String[] { "my", " ", "name", " ", "is", " ", "weird", " ", "Al" })));
  }

  @Test public void stringTestDeeltaZero() {
    azzert.that(0.0, azzert.is(string.delta(2.2, 2.2)));
  }

  @Test public void stringTestDeltaNotZero() {
    azzert.that(0.6666666666666666, azzert.is(string.delta(1.0, 2.0)));
  }

  @Test public void stringTestDtoa() {
    azzert.that("1.1", azzert.is(string.dtoa(1.1)));
  }

  @Test public void stringTestEqANull() {
    assert !string.eq(null, 2);
  }

  @Test public void stringTestEqANotNull() {
    assert !string.eq(4, 2);
  }

  @Test public void stringTestesc() {
    azzert.that("\\n", azzert.is(string.esc('\n')));
  }

  @Test public void stringTestesc1() {
    azzert.that("\\r", azzert.is(string.esc('\r')));
  }

  @Test public void stringTestesc2() {
    azzert.that("\\t", azzert.is(string.esc('\t')));
  }

  @Test public void stringTestesc3() {
    azzert.that("\\f", azzert.is(string.esc('\f')));
  }

  @Test public void stringTestesc4() {
    azzert.that("\\b", azzert.is(string.esc('\b')));
  }

  @Test public void stringTestesc5() {
    azzert.that("\\\\", azzert.is(string.esc('\\')));
  }

  @Test public void stringTestesc6() {
    azzert.that("d", azzert.is(string.esc('d')));
  }

  @Test public void stringTestescSrtingNull() {
    azzert.that("(null)", azzert.is(string.esc(null)));
  }

  @Test public void stringTestescStringNotNull() {
    azzert.that("\\n\\f\\\\", azzert.is(string.esc("\n\f\\")));
  }

  @Test public void stringTestFill() {
    azzert.that("hahaha", azzert.is(string.fill(3, "ha")));
  }

  @Test public void stringTestFill1() {
    azzert.that("hhh", azzert.is(string.fill(3, 'h')));
  }

  @Test public void stringTestfirst() {
    azzert.that('h', azzert.is(string.first("ha")));
  }

  @Test public void stringTestFtoa() {
    azzert.that("2.2", azzert.is(string.ftoa((float) 2.2)));
  }

  @Test public void stringTestIsDoubleTrue() {
    assert string.isDouble("2.2");
  }

  @Test public void stringTestIsDoubleFalse() {
    assert !string.isDouble("koko");
  }

  @Test public void stringTestIsFloatTrue() {
    assert string.isFloat("2.2");
  }

  @Test public void stringTestIsFloatFalse() {
    assert !string.isFloat("koko");
  }

  @Test public void stringTestIsIntTrue() {
    assert string.isInt("2");
  }

  @Test public void stringTestIsIntFalse() {
    assert !string.isInt("koko");
  }

  @Test public void stringTestIsLongTrue() {
    assert string.isLong("2");
  }

  @Test public void stringTestIsLongFalse() {
    assert !string.isLong("koko");
  }

  @Test public void stringTestitoa() {
    azzert.that("1", azzert.is(string.itoa(1)));
  }

  @Test public void stringTestLowCounter1() {
    azzert.that("", azzert.is(string.lowCounter(-1)));
  }

  @Test public void stringTestLowCounter2() {
    azzert.that("a", azzert.is(string.lowCounter(0)));
  }

  @Test public void stringTestLowCounter3() {
    azzert.that("c", azzert.is(string.lowCounter(2)));
  }

  @Test public void stringTestparen() {
    azzert.that("(1)", azzert.is(string.paren(Box.box(1))));
  }

  @Test public void stringTestpluralize() {
    azzert.that("two apples", azzert.is(string.pluralize(2, "apple")));
  }

  @Test public void stringTestpluralize1() {
    azzert.that("no apples", azzert.is(string.pluralize(0, "apple", "apples")));
  }

  @Test public void stringTestpluralize12() {
    azzert.that("apple", azzert.is(string.pluralize(1, "apple", "apples")));
  }

  @Test public void stringTestpluralize3() {
    azzert.that("two apples", azzert.is(string.pluralize(2, "apple", "apples")));
  }

  @Test public void stringTestpluralize4() {
    azzert.that("three apples", azzert.is(string.pluralize(3, "apple", "apples")));
  }

  @Test public void stringTestpluralize5() {
    azzert.that("four apples", azzert.is(string.pluralize(4, "apple", "apples")));
  }

  @Test public void stringTestpluralize6() {
    azzert.that("five apples", azzert.is(string.pluralize(5, "apple", "apples")));
  }

  @Test public void stringTestpluralize7() {
    azzert.that("six apples", azzert.is(string.pluralize(6, "apple", "apples")));
  }

  @Test public void stringTestpluralize8() {
    azzert.that("seven apples", azzert.is(string.pluralize(7, "apple", "apples")));
  }

  @Test public void stringTestpluralize9() {
    azzert.that("eight apples", azzert.is(string.pluralize(8, "apple", "apples")));
  }

  @Test public void stringTestpluralize10() {
    azzert.that("nine apples", azzert.is(string.pluralize(9, "apple", "apples")));
  }

  @Test public void stringTestpluralize11() {
    azzert.that("10 apples", azzert.is(string.pluralize(10, "apple", "apples")));
  }

  @Test public void stringTestPretty1() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    arr.add("bye");
    azzert.that("2 apples:\n\t1) hi\n\t2) bye\n", azzert.is(string.pretty("apple", arr)));
  }

  @Test public void stringTestPretty2() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    arr.add("bye");
    azzert.that("2 banana:\n\t1) hi\n\t2) bye\n", azzert.is(string.pretty("apple", "banana", arr)));
  }

  @Test public void stringTestPretty3() {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    azzert.that("1 apple: hi\n", azzert.is(string.pretty("apple", "banana", arr)));
  }

  @Test public void stringTestPretty4() {
    azzert.that("", azzert.is(string.pretty("apple", "banana", new ArrayList<>())));
  }

  @Test public void stringTestPretty5() {
    azzert.that("", azzert.is(string.pretty("apple", "banana", null)));
  }

  @Test public void stringTestquote() {
    azzert.that("'test'", azzert.is(string.quote("test")));
  }

  @Test public void stringTestrepeat() {
    azzert.that("hh", azzert.is(string.repeat(2, 'h')));
  }

  @Test public void stringTestrepeatString() {
    azzert.that("hh", azzert.is(string.repeat(2, "h")));
  }

  @Test public void stringTestsprintf1() {
    azzert.that("", azzert.is(string.sprintf(new String[] {})));
  }

  @Test public void stringTestsprintf2() {
    azzert.that("test", azzert.is(string.sprintf(new String[] { "test" })));
  }

  @Test public void stringTestsprintf3() {
    azzert.that("test1", azzert.is(string.sprintf(new String[] { "test1", "test2" })));
  }

  @Test public void stringTeststrip() {
    azzert.that("es", azzert.is(string.strip("test")));
  }

  @Test public void stringTestUpCount1() {
    azzert.that("", azzert.is(string.upCounter(-1)));
  }

  @Test public void stringTestUpCount2() {
    azzert.that("A", azzert.is(string.upCounter(0)));
  }

  @Test public void stringTestUpCount3() {
    azzert.that("C", azzert.is(string.upCounter(2)));
  }

  @Test public void stringTestvisualize() {
    azzert.that("hellosworld\\n", azzert.is(string.visualize("hello world\n")));
  }

  @Test public void stringTestwrapChar() {
    azzert.that("xtestx", azzert.is(string.wrap('x', "test")));
  }

  @Test public void stringTestwrapString() {
    azzert.that("xxtestxx", azzert.is(string.wrap("xx", "test")));
  }
}
