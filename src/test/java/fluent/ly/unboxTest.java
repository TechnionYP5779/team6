package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class unboxTest {
  @Test public void unboxTestBoolean() {
    boolean[] arr = { true, false, true, false };
    Boolean[] param = { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE };
    boolean[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestByte() {
    byte[] arr = { 1, 2, 3, 4, 5 };
    Byte[] param = { Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3"), Byte.valueOf("4"), Byte.valueOf("5") };
    byte[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestChar() {
    char[] arr = { 'E', 'y', 'a', 'l' };
    Character[] param = { Character.valueOf('E'), Character.valueOf('y'), Character.valueOf('a'), Character.valueOf('l') };
    char[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestShort1() {
    short[] arr = { 1, 2, 3, 4, 5 };
    Short[] param = { Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4"), Short.valueOf("5") };
    short[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestDouble() {
    double[] arr = { 1.1, 2.1, 3.1, 4.1, 5.1 };
    Double[] param = { Double.valueOf(1.1), Double.valueOf(2.1), Double.valueOf(3.1), Double.valueOf(4.1), Double.valueOf(5.1) };
    double[] result = unbox.unbox(param);
    assertArrayEquals(arr, result, 0.0001);
  }

  @Test public void unboxTestFloat() {
    float[] arr = { (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, (float) 5.1 };
    Float[] param = { Float.valueOf((float) 1.1), Float.valueOf((float) 2.1), Float.valueOf((float) 3.1), Float.valueOf((float) 4.1),
        Float.valueOf((float) 5.1) };
    float[] result = unbox.unbox(param);
    assertArrayEquals(arr, result, (float) 0.0001);
  }

  @Test public void unboxTestInt() {
    int[] arr = { 1, 2, 3, 4, 5 };
    Integer[] param = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) };
    int[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }

  @Test public void unboxTestLong() {
    long[] arr = { 1, 2, 3, 4, 5 };
    Long[] param = { Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4), Long.valueOf(5) };
    long[] result = unbox.unbox(param);
    assertArrayEquals(arr, result);
  }
}
