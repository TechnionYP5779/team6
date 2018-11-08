package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

public class unboxTest {
  @Test public void unboxTestBoolean() {
    final boolean[] arr = { true, false, true, false };
    final Boolean[] param = { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE };
    final boolean[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestByte() {
    final byte[] arr = { 1, 2, 3, 4, 5 };
    final Byte[] param = { Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3"), Byte.valueOf("4"), Byte.valueOf("5") };
    final byte[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestChar() {
    final char[] arr = { 'E', 'y', 'a', 'l' };
    final Character[] param = { Character.valueOf('E'), Character.valueOf('y'), Character.valueOf('a'), Character.valueOf('l') };
    final char[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestShort1() {
    final short[] arr = { 1, 2, 3, 4, 5 };
    final Short[] param = { Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4"), Short.valueOf("5") };
    final short[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestDouble() {
    final double[] arr = { 1.1, 2.1, 3.1, 4.1, 5.1 };
    final Double[] param = { Double.valueOf(1.1), Double.valueOf(2.1), Double.valueOf(3.1), Double.valueOf(4.1), Double.valueOf(5.1) };
    final double[] result = unbox.unbox(param);
    assertArrayEquals(arr, result, 0.0001);
  }

  @Test public void unboxTestFloat() {
    final float[] arr = { (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, (float) 5.1 };
    final Float[] param = { Float.valueOf((float) 1.1), Float.valueOf((float) 2.1), Float.valueOf((float) 3.1), Float.valueOf((float) 4.1),
        Float.valueOf((float) 5.1) };
    final float[] result = unbox.unbox(param);
    assertArrayEquals(arr, result, (float) 0.0001);
  }

  @Test public void unboxTestInt() {
    final int[] arr = { 1, 2, 3, 4, 5 };
    final Integer[] param = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) };
    final int[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestLong() {
    final long[] arr = { 1, 2, 3, 4, 5 };
    final Long[] param = { Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4), Long.valueOf(5) };
    final long[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }
}
