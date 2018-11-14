package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;
import static fluent.ly.azzert.assertNull;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class nilTest {
  @Test public void forgetting() {
    assertNull(nil.forgetting(null));
    assertNull(nil.forgetting(1));
    assertNull(nil.forgetting(1, "a", true));
    assertNull(nil.forgetting(new int[] { 1, 2, 3 }, null, 7));
  }

  @SuppressWarnings("null") @Test public void guardingly() {
    // function=String::length
    final Function<String, Integer> stringIntegerFunction = String::length;
    assertNull(nil.guardingly(stringIntegerFunction).on(null));
    assertEquals(5, Unbox.unbox(nil.guardingly(stringIntegerFunction).on("abcde")));
    // function=Integer.toString
    final Function<Integer, String> integerStringFunction = λ -> λ + "";
    assertNull("5", nil.guardingly(integerStringFunction).on(null));
    assertEquals("5", nil.guardingly(integerStringFunction).on(5));
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
