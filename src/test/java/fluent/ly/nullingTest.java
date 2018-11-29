package fluent.ly;

import java.util.function.*;

import org.junit.*;

/** For tested interface please see {@link fluent.ly.nulling} . */
@SuppressWarnings("static-method") public class nullingTest {
  @Test public void lyBoolean() {
    BooleanSupplier s = () -> true;
    azzert.assertNull(nulling.ly(s));
    s = () -> false;
    azzert.assertNull(nulling.ly(s));
  }

  @Test public void lyDouble() {
    DoubleSupplier s = () -> 1.0;
    azzert.assertNull(nulling.ly(s));
    s = () -> 2.0;
    azzert.assertNull(nulling.ly(s));
  }

  @Test public void lyInt() {
    IntSupplier s = () -> 1;
    azzert.assertNull(nulling.ly(s));
    s = () -> 2;
    azzert.assertNull(nulling.ly(s));
  }

  @Test public void lyLong() {
    LongSupplier s = () -> 1L;
    azzert.assertNull(nulling.ly(s));
    s = () -> 2L;
    azzert.assertNull(nulling.ly(s));
  }

  @Test public void lyRunnable() {
    azzert.assertNull(nulling.ly(() -> {
      assert true;
    }));
  }

  @Test public void lySupplier() {
    azzert.assertNull(nulling.ly(() -> "string"));
  }
}
