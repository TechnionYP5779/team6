package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class boxTest {
  @Test public void boxBoolTest() {
    final boolean a = true;
    azzert.that(Box.box(a).booleanValue(), azzert.is(a));
    assert !Box.box(false).booleanValue();
  }

  @Test public void boxBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].booleanValue(), azzert.is(a[¢]));
  }

  @Test public void boxByteTest() {
    final byte a = Byte.parseByte("123", 8);
    azzert.that(Box.box(a).byteValue(), azzert.is(a));
  }

  @Test public void boxByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].byteValue(), azzert.is(a[¢]));
  }

  @Test public void boxCharacterTest() {
    azzert.that(Box.box('a').charValue(), azzert.is('a'));
  }

  @Test public void boxCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].charValue(), azzert.is(a[¢]));
  }

  @Test public void boxDoubleTest() {
    azzert.that(Box.box(5.7).doubleValue(), azzert.is(5.7));
  }

  @Test public void boxDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].doubleValue(), azzert.is(a[¢]));
  }

  @Test public void boxFloatTest() {
    azzert.that(Box.box((float) 5).floatValue(), azzert.is((float) 5));
  }

  @Test public void boxFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].floatValue(), azzert.is(a[¢]));
  }

  @Test public void boxIntegerTest() {
    azzert.that(Box.box(3).intValue(), azzert.is(3));
  }

  @Test public void boxIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].intValue(), azzert.is(a[¢]));
  }

  @Test public void boxLongTest() {
    azzert.that(Box.box(1232144L).longValue(), azzert.is(1232144L));
  }

  @Test public void boxLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].longValue(), azzert.is(a[¢]));
  }

  @Test public void boxShortTest() {
    azzert.that(Box.box(96).shortValue(), azzert.is(96));
  }

  @Test public void boxShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].shortValue(), azzert.is(a[¢]));
  }

  @Test public void itBoolTest() {
    final boolean a = true;
    azzert.that(Box.it(a).booleanValue(), azzert.is(a));
    assert !Box.it(false).booleanValue();
  }

  @Test public void itBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].booleanValue(), azzert.is(a[¢]));
  }

  @Test public void itByteTest() {
    final byte a = Byte.parseByte("123", 8);
    azzert.that(Box.it(a).byteValue(), azzert.is(a));
  }

  @Test public void itByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].byteValue(), azzert.is(a[¢]));
  }

  @Test public void itCharacterTest() {
    azzert.that(Box.it('a').charValue(), azzert.is('a'));
  }

  @Test public void itCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].charValue(), azzert.is(a[¢]));
  }

  @Test public void itDoubleTest() {
    azzert.that(Box.it(5.7).doubleValue(), azzert.is(5.7));
  }

  @Test public void itDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].doubleValue(), azzert.is(a[¢]));
  }

  @Test public void itFloatTest() {
    azzert.that(Box.it((float) 5).floatValue(), azzert.is((float) 5));
  }

  @Test public void itFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].floatValue(), azzert.is(a[¢]));
  }

  @Test public void itIntegerTest() {
    azzert.that(Box.it(3).intValue(), azzert.is(3));
  }

  @Test public void itIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].intValue(), azzert.is(a[¢]));
  }

  @Test public void itLongTest() {
    azzert.that(Box.it(1232144L).longValue(), azzert.is(1232144L));
  }

  @Test public void itLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].longValue(), azzert.is(a[¢]));
  }

  @Test public void itShortTest() {
    azzert.that(Box.it(96).shortValue(), azzert.is(96));
  }

  @Test public void itShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(ita[¢].shortValue(), azzert.is(a[¢]));
  }
}
