package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class forgetTest {
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
    } catch (@SuppressWarnings("unused") final Exception e) {
      forget.it(param);
    }
  }

  static void auxeItDouble(final double param) {
    try {
      throw new Exception();
    } catch (@SuppressWarnings("unused") final Exception e) {
      forget.it(param);
    }
  }

  static void auxeItLong(final long param) {
    try {
      throw new Exception();
    } catch (@SuppressWarnings("unused") final Exception e) {
      forget.it(param);
    }
  }

  @Test public void testAll() {
    try {
      forgetTest.auxeAll(null);
    } catch (@SuppressWarnings("unused") final Throwable o) {
      assert false;
    }
  }

  @Test public void testIt() {
    try {
      forgetTest.auxeItObject(null);
      forgetTest.auxeItObject(Box.it(1));
      forgetTest.auxeItLong(1);
      forgetTest.auxeItDouble(0.0);
      forgetTest.auxeItBoolean(true);
    } catch (@SuppressWarnings("unused") final Throwable o) {
      assert false;
    }
  }
}
