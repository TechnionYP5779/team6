package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

/** For tested enum please see {@link fluent.ly.box} . */
@SuppressWarnings("static-method") public class boxTest {
  @Test public void boxBoolTest() {
    final boolean a = true;
    azzert.that(box.it(a).booleanValue(), is(a));
    assert !box.it(false).booleanValue();
  }

  @Test public void boxBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].booleanValue(), is(a[¢]));
  }

  @Test public void boxByteTest() {
    final byte a = Byte.parseByte("123", 8);
    azzert.that(box.it(a).byteValue(), is(a));
  }

  @Test public void boxByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].byteValue(), is(a[¢]));
  }

  @Test public void boxCharacterTest() {
    azzert.that(box.it('a').charValue(), is('a'));
  }

  @Test public void boxCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].charValue(), is(a[¢]));
  }

  @Test public void boxDoubleTest() {
    azzert.that(box.it(5.7).doubleValue(), is(5.7));
  }

  @Test public void boxDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].doubleValue(), is(a[¢]));
  }

  @Test public void boxFloatTest() {
    azzert.that(box.it((float) 5).floatValue(), is((float) 5));
  }

  @Test public void boxFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].floatValue(), is(a[¢]));
  }

  @Test public void boxIntegerTest() {
    azzert.that(box.it(3).intValue(), is(3));
  }

  @Test public void boxIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].intValue(), is(a[¢]));
  }

  @Test public void boxLongTest() {
    azzert.that(box.it(1232144L).longValue(), is(1232144L));
  }

  @Test public void boxLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].longValue(), is(a[¢]));
  }

  @Test public void boxShortTest() {
    azzert.that(box.it(96).shortValue(), is(96));
  }

  @Test public void boxShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].shortValue(), is(a[¢]));
  }

  @Test public void itBoolTest() {
    final boolean a = true;
    azzert.that(box.it(a).booleanValue(), is(a));
    assert !box.it(false).booleanValue();
  }

  @Test public void itBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].booleanValue(), is(a[¢]));
  }

  @Test public void itByteTest() {
    final byte a = Byte.parseByte("123", 8);
    azzert.that(box.it(a).byteValue(), is(a));
  }

  @Test public void itByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].byteValue(), is(a[¢]));
  }

  @Test public void itCharacterTest() {
    azzert.that(box.it('a').charValue(), is('a'));
  }

  @Test public void itCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].charValue(), is(a[¢]));
  }

  @Test public void itDoubleTest() {
    azzert.that(box.it(5.7).doubleValue(), is(5.7));
  }

  @Test public void itDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].doubleValue(), is(a[¢]));
  }

  @Test public void itFloatTest() {
    azzert.that(box.it((float) 5).floatValue(), is((float) 5));
  }

  @Test public void itFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].floatValue(), is(a[¢]));
  }

  @Test public void itIntegerTest() {
    azzert.that(box.it(3).intValue(), is(3));
  }

  @Test public void itIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].intValue(), is(a[¢]));
  }

  @Test public void itLongTest() {
    azzert.that(box.it(1232144L).longValue(), is(1232144L));
  }

  @Test public void itLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].longValue(), is(a[¢]));
  }

  @Test public void itShortTest() {
    azzert.that(box.it(96).shortValue(), is(96));
  }

  @Test public void itShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].shortValue(), is(a[¢]));
  }

  @Test public void boxThisBoolean() {
    final boolean[] uboxArr = { true, false, false };
    final Boolean[] boxArr = new Boolean[3];
    boxArr[0] = Boolean.TRUE;
    boxArr[2] = boxArr[1] = Boolean.FALSE;
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢]));
  }

  @Test public void boxThisByte() {
    final byte[] uboxArr = { 1, 0, 0 };
    final Byte[] boxArr = new Byte[3];
    boxArr[0] = Byte.valueOf((byte) 1);
    boxArr[1] = Byte.valueOf((byte) 0);
    boxArr[2] = Byte.valueOf((byte) 0);
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢]));
  }

  @Test public void boxThisCharacter() {
    final char[] uboxArr = { 'a', 'b', 'b' };
    final Character[] boxArr = new Character[3];
    boxArr[0] = Character.valueOf('a');
    boxArr[1] = Character.valueOf('b');
    boxArr[2] = Character.valueOf('b');
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢]));
  }

  @Test public void boxThisDouble() {
    final double[] uboxArr = { 1.0, 2.0, 2.0 };
    final Double[] boxArr = new Double[3];
    boxArr[0] = Double.valueOf(1.0);
    boxArr[1] = Double.valueOf(2.0);
    boxArr[2] = Double.valueOf(2.0);
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢]));
  }

  @Test public void boxThisFloat() {
    final float[] uboxArr = { 1, 1, 1 };
    final Float[] boxArr = new Float[3];
    boxArr[0] = Float.valueOf(1);
    boxArr[1] = Float.valueOf(1);
    boxArr[2] = Float.valueOf(1);
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢].floatValue()));
  }

  @Test public void boxThisLong() {
    final long[] uboxArr = { 1L, 2L, 3L };
    final Long[] boxArr = new Long[3];
    boxArr[0] = Long.valueOf(1L);
    boxArr[1] = Long.valueOf(2L);
    boxArr[2] = Long.valueOf(3L);
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢]));
  }

  @Test public void boxThisShort() {
    final short[] uboxArr = { 1, 2, 1 };
    final Short[] boxArr = new Short[3];
    boxArr[0] = Short.valueOf((short) 1);
    boxArr[1] = Short.valueOf((short) 2);
    boxArr[2] = Short.valueOf((short) 1);
    for (int ¢ = 0; ¢ < 3; ++¢)
      azzert.that(boxArr[¢], is(box.boxThis(uboxArr)[¢]));
  }
}
