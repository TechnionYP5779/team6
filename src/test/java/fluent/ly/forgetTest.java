package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

public class forgetTest {
  static void auxeAll(Integer integer) {
    try {
      integer.getClass();
    } catch (final Exception e) {
      forget.all(e);
    }
  }

  static void auxeItObject(Object object) {
    try {
      object.getClass();
    } catch (final Exception e) {
      forget.it(e);
    }
  }

  static void auxeItBoolean(boolean param) {
    try {
      throw new Exception();
    } catch (@SuppressWarnings("unused") final Exception e) {
      forget.it(param);
    }
  }

  static void auxeItDouble(double param) {
    try {
      throw new Exception();
    } catch (@SuppressWarnings("unused") final Exception e) {
      forget.it(param);
    }
  }

  static void auxeItLong(long param) {
    try {
      throw new Exception();
    } catch (@SuppressWarnings("unused") final Exception e) {
      forget.it(param);
    }
  }

  @Test @SuppressWarnings("static-method") public void testAll() {
    try {
      forgetTest.auxeAll(null);
    } catch (@SuppressWarnings("unused") final Throwable o) {
      assertFalse(true);
    }
  }

  @Test @SuppressWarnings("static-method") public void testIt() {
    try {
      forgetTest.auxeItObject(null);
      forgetTest.auxeItObject(Integer.valueOf(1));
      forgetTest.auxeItLong(1);
      forgetTest.auxeItDouble(0.0);
      forgetTest.auxeItBoolean(true);
    } catch (@SuppressWarnings("unused") final Throwable o) {
      assertFalse(true);
    }
  }
}
