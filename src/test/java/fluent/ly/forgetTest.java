package fluent.ly;



import org.junit.*;

public class forgetTest {
  static void auxeAll(Integer integer) {
    try {
      integer.getClass();
    } catch (final Exception ¢) {
      forget.all(¢);
    }
  }

  static void auxeItObject(Object o) {
    try {
      o.getClass();
    } catch (final Exception ¢) {
      forget.it(¢);
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
      assert false;
    }
  }

  @Test @SuppressWarnings("static-method") public void testIt() {
    try {
      forgetTest.auxeItObject(null);
      forgetTest.auxeItObject(Box.box(1));
      forgetTest.auxeItLong(1);
      forgetTest.auxeItDouble(0.0);
      forgetTest.auxeItBoolean(true);
    } catch (@SuppressWarnings("unused") final Throwable o) {
      assert false;
    }
  }
}
