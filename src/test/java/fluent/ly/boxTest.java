package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class boxTest {
  @Test public void boxBoolTest() {
    final boolean a = true;
    azzert.that(box.it(a).booleanValue(),azzert.is(a));
    assert !box.it(false).booleanValue();
  }

  @Test public void boxBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that(boxa[¢].booleanValue() ,azzert.is(a[¢]));
  }

  @Test public void boxByteTest() {
    final byte a = Byte.parseByte("123", 8);
    azzert.that( box.it(a).byteValue() ,azzert.is(a));
  }

  @Test public void boxByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].byteValue(),azzert.is(a[¢]));
  }

  @Test public void boxCharacterTest() {
    azzert.that(box.it('a').charValue(),azzert.is('a'));
  }

  @Test public void boxCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].charValue(),azzert.is(a[¢]));
  }

  @Test public void boxDoubleTest() {
    azzert.that( box.it(5.7).doubleValue() ,azzert.is( 5.7));
  }

  @Test public void boxDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].doubleValue() ,azzert.is( a[¢]));
  }

  @Test public void boxFloatTest() {
    azzert.that( box.it((float)5).floatValue() ,azzert.is( (float)5));
  }

  @Test public void boxFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].floatValue() ,azzert.is( a[¢]));
  }

  @Test public void boxIntegerTest() {
    azzert.that( box.it(3).intValue() ,azzert.is( 3));
  }

  @Test public void boxIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].intValue() ,azzert.is( a[¢]));
  }

  @Test public void boxLongTest() {
    azzert.that( box.it(1232144L).longValue() ,azzert.is(1232144L));
  }

  @Test public void boxLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].longValue() ,azzert.is( a[¢]));
  }

  @Test public void boxShortTest() {
    azzert.that( box.it(96).shortValue() ,azzert.is( 96));
  }

  @Test public void boxShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] boxa = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( boxa[¢].shortValue() ,azzert.is( a[¢]));
  }

  @Test public void itBoolTest() {
    final boolean a = true;
    azzert.that( box.it(a).booleanValue() ,azzert.is( a));
    assert !box.it(false).booleanValue();
  }

  @Test public void itBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].booleanValue() ,azzert.is( a[¢]));
  }

  @Test public void itByteTest() {
    final byte a = Byte.parseByte("123", 8);
    azzert.that( box.it(a).byteValue() ,azzert.is( a));
  }

  @Test public void itByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].byteValue() ,azzert.is( a[¢]));
  }

  @Test public void itCharacterTest() {
    azzert.that( box.it('a').charValue() ,azzert.is( 'a'));
  }

  @Test public void itCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].charValue() ,azzert.is( a[¢]));
  }

  @Test public void itDoubleTest() {
    azzert.that( box.it(5.7).doubleValue() ,azzert.is( 5.7));
  }

  @Test public void itDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].doubleValue() ,azzert.is( a[¢]));
  }

  @Test public void itFloatTest() {
    azzert.that( box.it((float)5).floatValue() ,azzert.is((float) 5));
  }

  @Test public void itFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].floatValue() ,azzert.is( a[¢]));
  }

  @Test public void itIntegerTest() {
    azzert.that( box.it(3).intValue() ,azzert.is( 3));
  }

  @Test public void itIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].intValue() ,azzert.is( a[¢]));
  }

  @Test public void itLongTest() {
    azzert.that( box.it(1232144L).longValue() ,azzert.is(1232144L));
  }

  @Test public void itLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].longValue() ,azzert.is( a[¢]));
  }

  @Test public void itShortTest() {
    azzert.that( box.it(96).shortValue() ,azzert.is( 96));
  }

  @Test  public void itShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] ita = box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      azzert.that( ita[¢].shortValue() ,azzert.is( a[¢]));
  }
}
