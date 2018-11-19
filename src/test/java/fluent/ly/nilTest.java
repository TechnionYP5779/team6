package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class nilTest {
  @Test public void forgetting() {
    assertNull(nil.forgetting(null));
    assertNull(nil.forgetting(Box.it(1)));
    assertNull(nil.forgetting(Box.it(1), "a", Box.it(true)));
    assertNull(nil.forgetting(new int[] { 1, 2, 3 }, null, Box.it(7)));
  }

  @Test @SuppressWarnings("null") public void guardingly() {
    final Function<String, Integer> stringIntegerFunction = String::length;
    assertNull(nil.guardingly(stringIntegerFunction).on(null));
    azzert.that(5, is(Unbox.unbox(nil.guardingly(stringIntegerFunction).on("abcde"))));
    final Function<Integer, String> integerStringFunction = λ -> λ + "";
    assertNull("5", nil.guardingly(integerStringFunction).on(null));
    azzert.that("5", is( nil.guardingly(integerStringFunction).on(Box.it(5))));
  }

  @Test public void ignoring_boolean() {
    assertNull(nil.ignoring(true));
    assertNull(nil.ignoring(false));
    assertNull(nil.ignoring('z' < 'a' || 59 >= 400));
  }

  @Test public void ignoring_double() {
    assertNull(nil.ignoring(0.0));
    assertNull(nil.ignoring(0));
    assertNull(nil.ignoring(5.89));
  }

  @Test public void ignoring_long() {
    assertNull(nil.ignoring((long) 0.0));
    assertNull(nil.ignoring(100L));
  }

  @Test(expected = NumberFormatException.class) public void ignoring_null() {
    assertNull(Long.valueOf(null));
  }
}
