package fluent.ly;

import static fluent.ly.azzert.*;

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

  @Test @SuppressWarnings("static-method") public void lyAsTTest() {
    final Supplier<Integer> t0 = () -> Integer.valueOf(0);
    assertTrue(anonymous.ly(t0).intValue() == 0);
    final Supplier<Integer> t1 = () -> Integer.valueOf(-1000);
    assertTrue(anonymous.ly(t1).intValue() == -1000);
    final Supplier<Boolean> t2 = () -> Boolean.valueOf(true);
    assertTrue(anonymous.ly(t2).booleanValue());
    final Supplier<Boolean> t3 = () -> Boolean.valueOf(false);
    assertFalse(anonymous.ly(t3).booleanValue());
    final Supplier<Double> t4 = () -> Double.valueOf(10.76);
    assertTrue(anonymous.ly(t4).doubleValue() == 10.76);
    final Supplier<Double> t5 = () -> Double.valueOf(10);
    assertTrue(anonymous.ly(t5).doubleValue() == 10);
    final Supplier<Long> t6 = () -> Long.valueOf(10);
    assertTrue(anonymous.ly(t6).longValue() == 10);
    final Supplier<Long> t7 = () -> Long.valueOf(-17179869184L);
    assertTrue(anonymous.ly(t7).longValue() == -17179869184L);
  }
}
