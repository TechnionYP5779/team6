package fluent.ly;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test  public void lyAsBooleanTest() {
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(() -> false);
  }

  @Test public void lyAsDoubleTest() {
    assert anonymous.ly(() -> 10.76) == 10.76;
    assert anonymous.ly(() -> 30) == 30;
    assert anonymous.ly(() -> -858993459) == -858993459;
  }

  @Test  public void lyAsIntTest() {
    assert anonymous.ly(() -> 10) == 10;
    assert anonymous.ly(() -> -858993459) == -858993459;
  }

  @Test public void lyAsLongTest() {
    assert anonymous.ly(() -> 8589934592L) == 8589934592L;
    assert anonymous.ly(() -> -17179869184L) == -17179869184L;
    assert anonymous.ly(() -> 7) == 7L;
    assert anonymous.ly(() -> -40L) == -40;
  }

  @Test @SuppressWarnings("null") public void lyAsTTest() {
    assert anonymous.ly(() -> unbox.it(Box.it(0))) == 0;
    assert anonymous.ly(() -> unbox.it(Box.it(-1000))) == -1000;
    assert unbox.unboxBoolean(anonymous.ly((Supplier<Boolean>) () -> Boolean.TRUE));
    assert !unbox.unboxBoolean(anonymous.ly((Supplier<Boolean>) () -> Boolean.FALSE));
    assert anonymous.ly(() -> unbox.unboxDouble(Box.it(10.76))) == 10.76;
    assert anonymous.ly(() -> unbox.unboxDouble(Box.it(10.0))) == 10;
    assert anonymous.ly(() -> unbox.unboxLong(Box.it(10L))) == 10;
    assert anonymous.ly(() -> unbox.unboxLong(Box.it(-17179869184L))) == -17179869184L;
  }
}
