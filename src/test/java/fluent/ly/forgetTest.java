package fluent.ly;

import org.junit.*;
/**
* For tested interface please see {@link fluent.ly.forget} .
*/
@SuppressWarnings({ "static-method", "unused" }) public class forgetTest {
  static void auxeAll(final Integer integer) {
    try {
      integer.getClass();
    } catch (final Exception ¢) {
      forget.all(¢);
    }
  }

  static void auxeItObject(final Object o) {
    try {
      o.getClass();
    } catch (final Exception ¢) {
      forget.it(¢);
    }
  }

  static void auxeItBoolean(final boolean param) {
    try {
      throw new Exception();
    } catch (final Exception e) {
      forget.it(param);
    }
  }

  static void auxeItDouble(final double param) {
    try {
      throw new Exception();
    } catch (final Exception e) {
      forget.it(param);
    }
  }

  static void auxeItLong(final long param) {
    try {
      throw new Exception();
    } catch (final Exception e) {
      forget.it(param);
    }
  }

  @Test public void testAll() {
    try {
      forgetTest.auxeAll(null);
    } catch (final Throwable o) {
      assert false;
    }
  }

  @Test public void testIt() {
    try {
      forgetTest.auxeItObject(null);
      forgetTest.auxeItObject(box.it(1));
      forgetTest.auxeItLong(1);
      forgetTest.auxeItDouble(0.0);
      forgetTest.auxeItBoolean(true);
    } catch (final Throwable o) {
      assert false;
    }
  }
}
