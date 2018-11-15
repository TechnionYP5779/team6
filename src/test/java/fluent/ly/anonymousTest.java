package fluent.ly;

import java.util.function.*;

import org.junit.*;

public class anonymousTest {
  @Test @SuppressWarnings("static-method") public void lyAsBooleanTest() {
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(() -> false);
  }

  @Test @SuppressWarnings("static-method") public void lyAsDoubleTest() {
    assert anonymous.ly(() -> 10.76) == 10.76;
    assert anonymous.ly(() -> 30) == 30;
    assert anonymous.ly(() -> -858993459) == -858993459;
  }

  @Test @SuppressWarnings("static-method") public void lyAsIntTest() {
    assert anonymous.ly(() -> 10) == 10;
    assert anonymous.ly(() -> -858993459) == -858993459;
  }

  @Test @SuppressWarnings("static-method") public void lyAsLongTest() {
    assert anonymous.ly(() -> 8589934592L) == 8589934592L;
    assert anonymous.ly(() -> -17179869184L) == -17179869184L;
    assert anonymous.ly(() -> 7) == 7L;
    assert anonymous.ly(() -> -40L) == -40;
  }

  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void lyAsTTest() {
    assert anonymous.ly((Supplier<Integer>) () -> Unbox.unbox(Box.box(0))) == 0;
    assert anonymous.ly((Supplier<Integer>) () -> Unbox.unbox(Box.box(-1000))) == -1000;
    assert Unbox.unbox(anonymous.ly((Supplier<Boolean>) () -> Boolean.TRUE));
    assert !Unbox.unbox(anonymous.ly((Supplier<Boolean>) () -> Boolean.FALSE));
    assert anonymous.ly((Supplier<Double>) () -> Unbox.unbox(Box.box(10.76))) == 10.76;
    assert anonymous.ly((Supplier<Double>) () -> Unbox.unbox(Box.box(10.0))) == 10;
    assert anonymous.ly((Supplier<Long>) () -> Unbox.unbox(Box.box(10L))) == 10;
    assert anonymous.ly((Supplier<Long>) () -> Unbox.unbox(Box.box(-17179869184L))) == -17179869184L;
  }
}
