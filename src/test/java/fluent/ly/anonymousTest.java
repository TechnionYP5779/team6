package fluent.ly;

import static org.junit.Assert.*;

import java.util.function.*;

import org.junit.*;

public class anonymousTest {
  @SuppressWarnings("static-method") @Test public void lyAsBooleanTest() {
    assertTrue(anonymous.ly(() -> true));
    assertFalse(anonymous.ly(() -> false));
  }

  @SuppressWarnings("static-method") @Test public void lyAsDoubleTest() {
    final DoubleSupplier d1 = () -> 10.76;
    assertTrue(anonymous.ly(d1) == 10.76);
    final DoubleSupplier d2 = () -> 30;
    assertTrue(anonymous.ly(d2) == 30);
    final DoubleSupplier d3 = () -> -858993459;
    assertTrue(anonymous.ly(d3) == -858993459);
  }

  @SuppressWarnings("static-method") @Test public void lyAsIntTest() {
    final IntSupplier i1 = () -> 10;
    assertTrue(anonymous.ly(i1) == 10);
    final IntSupplier i2 = () -> -858993459;
    assertTrue(anonymous.ly(i2) == -858993459);
  }

  @SuppressWarnings("static-method") @Test public void lyAsLongTest() {
    final LongSupplier l1 = () -> 8589934592L;
    assertTrue(anonymous.ly(l1) == 8589934592L);
    final LongSupplier l2 = () -> -17179869184L;
    assertTrue(anonymous.ly(l2) == -17179869184L);
    final LongSupplier l3 = () -> 7;
    assertTrue(anonymous.ly(l3) == 7L);
    final LongSupplier l4 = () -> -40L;
    assertTrue(anonymous.ly(l4) == -40);
  }

  @SuppressWarnings("static-method") @Test public void lyAsTTest() {
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
