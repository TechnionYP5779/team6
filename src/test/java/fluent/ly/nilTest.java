package fluent.ly;

import static org.junit.Assert.*;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class nilTest {
  @Test public void forgetting() {
    assertNull(nil.forgetting(null));
    assertNull(nil.forgetting(1));
    assertNull(nil.forgetting(1, "a", true));
    assertNull(nil.forgetting(new int[] { 1, 2, 3 }, null, 7));
  }

  @Test public void guardingly() {
    // function=String::length
    final Function<String, Integer> stringIntegerFunction = String::length;
    assertNull(nil.guardingly(stringIntegerFunction).on(null));
    assertEquals(5, nil.guardingly(stringIntegerFunction).on("abcde").intValue());
    // function=Integer.toString
    final Function<Integer, String> integerStringFunction = λ -> λ + "";
    assertNull("5", nil.guardingly(integerStringFunction).on(null));
    assertEquals("5", nil.guardingly(integerStringFunction).on(5));
  }

  @Test public void ignoring_boolean() {
    assertNull(nil.ignoring(true));
    assertNull(nil.ignoring(false));
    assertNull(nil.ignoring('z' < 'a' || 109 - 50 >= 400));
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
    assertNull(new Long(null).longValue());
  }
}
