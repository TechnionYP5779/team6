package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class unboxTest {
  @Test public void unboxTestBoolean() {
    assertArrayEquals(new boolean[] { true, false, true, false },
        Unbox.unbox(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }));
  }

  @Test public void unboxTestByte() {
    assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 },
        Unbox.unbox(new Byte[] { Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3"), Byte.valueOf("4"), Byte.valueOf("5") }));
  }

  @Test public void unboxTestChar() {
    assertArrayEquals(new char[] { 'E', 'y', 'a', 'l' },
        Unbox.unbox(new Character[] { Character.valueOf('E'), Character.valueOf('y'), Character.valueOf('a'), Character.valueOf('l') }));
  }

  @Test public void unboxTestShort1() {
    assertArrayEquals(new short[] { 1, 2, 3, 4, 5 },
        Unbox.unbox(new Short[] { Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4"), Short.valueOf("5") }));
  }

  @Test public void unboxTestDouble() {
    assertArrayEquals(new double[] { 1.1, 2.1, 3.1, 4.1, 5.1 },
        Unbox.it(new Double[] { Double.valueOf(1.1), Double.valueOf(2.1), Double.valueOf(3.1), Double.valueOf(4.1), Double.valueOf(5.1) }),
        0.0001);
  }

  @Test public void unboxTestFloat() {
    assertArrayEquals(new float[] { (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, (float) 5.1 }, Unbox.it(new Float[] {
        Float.valueOf((float) 1.1), Float.valueOf((float) 2.1), Float.valueOf((float) 3.1), Float.valueOf((float) 4.1), Float.valueOf((float) 5.1) }),
        (float) 0.0001);
  }

  @Test public void unboxTestInt() {
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
        Unbox.it(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));
  }

  @Test public void unboxTestLong() {
    assertArrayEquals(new long[] { 1, 2, 3, 4, 5 },
        Unbox.unbox(new Long[] { Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4), Long.valueOf(5) }));
  }

  @Test public void unboxTestDoubleArr() {
    assertArrayEquals(new double[] { 1.1, 2.1, 3.1, 4.1, 5.1 },
        Unbox.it(new Double[] { Double.valueOf(1.1), Double.valueOf(2.1), Double.valueOf(3.1), Double.valueOf(4.1), Double.valueOf(5.1) }), 0.0001);
  }

  @Test public void unboxTestFloatArr() {
    assertArrayEquals(new float[] { (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, (float) 5.1 }, Unbox.it(new Float[] {
        Float.valueOf((float) 1.1), Float.valueOf((float) 2.1), Float.valueOf((float) 3.1), Float.valueOf((float) 4.1), Float.valueOf((float) 5.1) }),
        (float) 0.0001);
  }

  @Test public void unboxTestintVal() {
    azzert.that(1, is(Unbox.it(Box.it(1))));
    azzert.that(2, is(Unbox.it(Box.it(2))));
    azzert.that(3, is(Unbox.it(Box.it(3))));
    azzert.that(4, is(Unbox.it(Box.it(4))));
  }

  @Test public void unboxTestDoubleVal() {
    azzert.that(1.1, is(Unbox.unbox(Double.valueOf(1.1))));
    azzert.that(2.1, is(Unbox.unbox(Double.valueOf(2.1))));
    azzert.that(3.1, is(Unbox.unbox(Double.valueOf(3.1))));
  }

  @Test public void unboxTestIntArr() {
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
        Unbox.it(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));
  }

  @Test public void unboxTestBoolVal() {
    assert Unbox.unbox(Boolean.TRUE);
    assert !Unbox.unbox(Boolean.FALSE);
  }

  @Test public void unboxTestByteVal() {
    azzert.that((byte) 1, is(Unbox.unbox(Byte.valueOf("1"))));
    azzert.that((byte) 2, is(Unbox.unbox(Byte.valueOf("2"))));
    azzert.that((byte) 3, is(Unbox.unbox(Byte.valueOf("3"))));
  }

  @Test public void unboxTestCharVal() {
    azzert.that('E', is(Unbox.unbox(Character.valueOf('E'))));
    azzert.that('y', is(Unbox.unbox(Character.valueOf('y'))));
    azzert.that('a', is(Unbox.unbox(Character.valueOf('a'))));
  }
}
