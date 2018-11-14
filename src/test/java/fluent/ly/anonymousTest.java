package fluent.ly;



import java.util.function.*;

import org.junit.Test;

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

  @Test @SuppressWarnings("static-method") public void lyAsTTest() {
    assert anonymous.ly((Supplier<Integer>)() -> Integer.valueOf(0)).intValue() == 0;
    assert anonymous.ly((Supplier<Integer>)() -> Integer.valueOf(-1000)).intValue() == -1000;
    assert anonymous.ly((Supplier<Boolean>)() -> Boolean.TRUE).booleanValue();
    assert !anonymous.ly((Supplier<Boolean>)() -> Boolean.FALSE).booleanValue();
    assert anonymous.ly((Supplier<Double>)() -> Double.valueOf(10.76)).doubleValue() == 10.76;
    assert anonymous.ly((Supplier<Double>)() -> Double.valueOf(10)).doubleValue() == 10;
    assert anonymous.ly((Supplier<Long>)() -> Long.valueOf(10)).longValue() == 10;
    assert anonymous.ly((Supplier<Long>)() -> Long.valueOf(-17179869184L)).longValue() == -17179869184L;
  }
}
