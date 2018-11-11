package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings({ "null", "static-method" }) public class unboxTest {
  @Test
  public void unboxTestBoolean() {
    assertArrayEquals(new boolean[] { true, false, true, false },
        unbox.unbox(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }));
  }

  @Test
  public void unboxTestByte() {
    assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 },
        unbox.unbox(new Byte[] { Byte.valueOf("1"), Byte.valueOf("2"), Byte.valueOf("3"), Byte.valueOf("4"), Byte.valueOf("5") }));
  }

  @Test
  public void unboxTestChar() {
    assertArrayEquals(new char[] { 'E', 'y', 'a', 'l' },
        unbox.unbox(new Character[] { Character.valueOf('E'), Character.valueOf('y'), Character.valueOf('a'), Character.valueOf('l') }));
  }

  @Test
  public void unboxTestShort1() {
    assertArrayEquals(new short[] { 1, 2, 3, 4, 5 },
        unbox.unbox(new Short[] { Short.valueOf("1"), Short.valueOf("2"), Short.valueOf("3"), Short.valueOf("4"), Short.valueOf("5") }));
  }

  @Test
  public void unboxTestDouble() {
    assertArrayEquals(new double[] { 1.1, 2.1, 3.1, 4.1, 5.1 },
        unbox.unbox(new Double[] { Double.valueOf(1.1), Double.valueOf(2.1), Double.valueOf(3.1), Double.valueOf(4.1), Double.valueOf(5.1) }),
        0.0001);
  }

  @Test
  public void unboxTestFloat() {
    assertArrayEquals(new float[] { (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, (float) 5.1 }, unbox.unbox(new Float[] {
        Float.valueOf((float) 1.1), Float.valueOf((float) 2.1), Float.valueOf((float) 3.1), Float.valueOf((float) 4.1), Float.valueOf((float) 5.1) }),
        (float) 0.0001);
  }

  @Test
  public void unboxTestInt() {
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
        unbox.unbox(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));
  }

  @Test
  public void unboxTestLong() {
    assertArrayEquals(new long[] { 1, 2, 3, 4, 5 },
        unbox.unbox(new Long[] { Long.valueOf(1), Long.valueOf(2), Long.valueOf(3), Long.valueOf(4), Long.valueOf(5) }));
  }

  @Test
  public void unboxTestDoubleArr() {
    assertArrayEquals(new double[] { 1.1, 2.1, 3.1, 4.1, 5.1 },
        unbox.it(new Double[] { Double.valueOf(1.1), Double.valueOf(2.1), Double.valueOf(3.1), Double.valueOf(4.1), Double.valueOf(5.1) }), 0.0001);
  }

  @Test
  public void unboxTestFloatArr() {
    assertArrayEquals(new float[] { (float) 1.1, (float) 2.1, (float) 3.1, (float) 4.1, (float) 5.1 }, unbox.it(new Float[] {
        Float.valueOf((float) 1.1), Float.valueOf((float) 2.1), Float.valueOf((float) 3.1), Float.valueOf((float) 4.1), Float.valueOf((float) 5.1) }),
        (float) 0.0001);
  }


  @Test @SuppressWarnings("boxing") public void unboxTestintVal() {
    assertEquals(1, unbox.it(1));
    assertEquals(2, unbox.it(2));
    assertEquals(3, unbox.it(3));
    assertEquals(4, unbox.it(4));
  }

  @Test
  public void unboxTestDoubleVal(){
    assertEquals(1.1, unbox.unbox(Double.valueOf(1.1)), 0.0001);
    assertEquals(2.1, unbox.unbox(Double.valueOf(2.1)), 0.0001);
    assertEquals(3.1, unbox.unbox(Double.valueOf(3.1)), 0.0001);

  }

  @Test
  public void unboxTestIntArr() {
    assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
        unbox.it(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }));

  }

  @Test
  public void unboxTestBoolVal() {
    assert unbox.unbox(Boolean.TRUE);
    assert !unbox.unbox(Boolean.FALSE);
  }
  @Test
  public void unboxTestByteVal() {
    assertEquals((byte) 1, unbox.unbox(Byte.valueOf("1")));
    assertEquals((byte) 2, unbox.unbox(Byte.valueOf("2")));
    assertEquals((byte) 3, unbox.unbox(Byte.valueOf("3")));
  }

  @Test
  public void unboxTestCharVal() {
    assertEquals('E', unbox.unbox(Character.valueOf('E')));
    assertEquals('y', unbox.unbox(Character.valueOf('y')));
    assertEquals('a', unbox.unbox(Character.valueOf('a')));
  }
}
