package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method", "boxing" }) public class stringTest {
  @Test public void stringTestAtod() {
    azzert.that(Double.valueOf("2.2"), is(string.atod("2.2")));
  }

  @Test public void stringTestAtof() {
    azzert.that(Float.valueOf("2.2"), is(string.atof("2.2")));
  }

  @Test public void stringTestAtoi() {
    azzert.that(1, is(string.atoi("1")));
  }

  @Test public void stringTestAtol() {
    azzert.that(1L, is(string.atol("1")));
  }

  @Test public void stringTestcapitalizeEmpty() {
    azzert.that("", is(string.capitalize("")));
  }

  @Test public void stringTestcapitalizeNotEmpty() {
    azzert.that("Test", is(string.capitalize("test")));
  }

  @Test public void stringTestcat() {
    azzert.that("my name is weird Al", is(string.cat("my", " ", "name", " ", "is", " ", "weird", " ", "Al")));
  }

  @Test public void stringTestcat2() {
    azzert.that("my name is weird Al", is(string.cat(new String[] { "my", " ", "name", " ", "is", " ", "weird", " ", "Al" })));
  }

  @Test public void stringTestDeeltaZero() {
    azzert.that(0.0, is(string.delta(2.2, 2.2)));
  }

  @Test public void stringTestDeltaNotZero() {
    azzert.that(0.6666666666666666, is(string.delta(1.0, 2.0)));
  }

  @Test public void stringTestDtoa() {
    azzert.that("1.1", is(string.dtoa(1.1)));
  }

  @Test public void stringTestEqANull() {
    assert !string.eq(null, 2);
  }

  @Test public void stringTestEqANotNull() {
    assert !string.eq(4, 2);
  }

  @Test public void stringTestesc() {
    azzert.that("\\n", is(string.esc('\n')));
  }

  @Test public void stringTestesc1() {
    azzert.that("\\r", is(string.esc('\r')));
  }

  @Test public void stringTestesc2() {
    azzert.that("\\t", is(string.esc('\t')));
  }

  @Test public void stringTestesc3() {
    azzert.that("\\f", is(string.esc('\f')));
  }

  @Test public void stringTestesc4() {
    azzert.that("\\b", is(string.esc('\b')));
  }

  @Test public void stringTestesc5() {
    azzert.that("\\\\", is(string.esc('\\')));
  }

  @Test public void stringTestesc6() {
    azzert.that("d", is(string.esc('d')));
  }

  @Test public void stringTestescSrtingNull() {
    azzert.that("(null)", is(string.esc(null)));
  }

  @Test public void stringTestescStringNotNull() {
    azzert.that("\\n\\f\\\\", is(string.esc("\n\f\\")));
  }

  @Test public void stringTestFill() {
    azzert.that("hahaha", is(string.fill(3, "ha")));
  }

  @Test public void stringTestFill1() {
    azzert.that("hhh", is(string.fill(3, 'h')));
  }

  @Test public void stringTestfirst() {
    azzert.that('h', is(string.first("ha")));
  }

  @Test public void stringTestFtoa() {
    azzert.that("2.2", is(string.ftoa((float) 2.2)));
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
    azzert.that("1", is(string.itoa(1)));
  }

  @Test public void stringTestLowCounter1() {
    azzert.that("", is(string.lowCounter(-1)));
  }

  @Test public void stringTestLowCounter2() {
    azzert.that("a", is(string.lowCounter(0)));
  }

  @Test public void stringTestLowCounter3() {
    azzert.that("c", is(string.lowCounter(2)));
  }

  @Test public void stringTestparen() {
    azzert.that("(1)", is(string.paren(Box.box(1))));
  }

  @Test public void stringTestpluralize() {
    azzert.that("two apples", is(string.pluralize(2, "apple")));
  }

  @Test public void stringTestpluralize1() {
    azzert.that("no apples", is(string.pluralize(0, "apple", "apples")));
  }

  @Test public void stringTestpluralize12() {
    azzert.that("apple", is(string.pluralize(1, "apple", "apples")));
  }

  @Test public void stringTestpluralize3() {
    azzert.that("two apples", is(string.pluralize(2, "apple", "apples")));
  }

  @Test public void stringTestpluralize4() {
    azzert.that("three apples", is(string.pluralize(3, "apple", "apples")));
  }

  @Test public void stringTestpluralize5() {
    azzert.that("four apples", is(string.pluralize(4, "apple", "apples")));
  }

  @Test public void stringTestpluralize6() {
    azzert.that("five apples", is(string.pluralize(5, "apple", "apples")));
  }

  @Test public void stringTestpluralize7() {
    azzert.that("six apples", is(string.pluralize(6, "apple", "apples")));
  }

  @Test public void stringTestpluralize8() {
    azzert.that("seven apples", is(string.pluralize(7, "apple", "apples")));
  }

  @Test public void stringTestpluralize9() {
    azzert.that("eight apples", is(string.pluralize(8, "apple", "apples")));
  }

  @Test public void stringTestpluralize10() {
    azzert.that("nine apples", is(string.pluralize(9, "apple", "apples")));
  }

  @Test public void stringTestpluralize11() {
    azzert.that("10 apples", is(string.pluralize(10, "apple", "apples")));
  }

  @Test public void stringTestPretty1() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    arr.add("bye");
    azzert.that("2 apples:\n\t1) hi\n\t2) bye\n", is(string.pretty("apple", arr)));
  }

  @Test public void stringTestPretty2() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    arr.add("bye");
    azzert.that("2 banana:\n\t1) hi\n\t2) bye\n", is(string.pretty("apple", "banana", arr)));
  }

  @Test public void stringTestPretty3() {
    final ArrayList<String> arr = new ArrayList<>();
    arr.add("hi");
    azzert.that("1 apple: hi\n", is(string.pretty("apple", "banana", arr)));
  }

  @Test public void stringTestPretty4() {
    azzert.that("", is(string.pretty("apple", "banana", new ArrayList<>())));
  }

  @Test public void stringTestPretty5() {
    azzert.that("", is(string.pretty("apple", "banana", null)));
  }

  @Test public void stringTestquote() {
    azzert.that("'test'", is(string.quote("test")));
  }

  @Test public void stringTestrepeat() {
    azzert.that("hh", is(string.repeat(2, 'h')));
  }

  @Test public void stringTestrepeatString() {
    azzert.that("hh", is(string.repeat(2, "h")));
  }

  @Test public void stringTestsprintf1() {
    azzert.that("", is(string.sprintf(new String[] {})));
  }

  @Test public void stringTestsprintf2() {
    azzert.that("test", is(string.sprintf(new String[] { "test" })));
  }

  @Test public void stringTestsprintf3() {
    azzert.that("test1", is(string.sprintf(new String[] { "test1", "test2" })));
  }

  @Test public void stringTeststrip() {
    azzert.that("es", is(string.strip("test")));
  }

  @Test public void stringTestUpCount1() {
    azzert.that("", is(string.upCounter(-1)));
  }

  @Test public void stringTestUpCount2() {
    azzert.that("A", is(string.upCounter(0)));
  }

  @Test public void stringTestUpCount3() {
    azzert.that("C", is(string.upCounter(2)));
  }

  @Test public void stringTestvisualize() {
    azzert.that("hellosworld\\n", is(string.visualize("hello world\n")));
  }

  @Test public void stringTestwrapChar() {
    azzert.that("xtestx", is(string.wrap('x', "test")));
  }

  @Test public void stringTestwrapString() {
    azzert.that("xxtestxx", is(string.wrap("xx", "test")));
  }
}
