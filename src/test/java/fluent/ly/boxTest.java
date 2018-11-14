package fluent.ly;

import org.junit.*;

public class boxTest {
  @Test @SuppressWarnings("static-method") public void boxBoolTest() {
    final boolean a = true;
    assert Box.box(a).booleanValue() == a;
    assert !Box.box(false).booleanValue();
  }

  @Test @SuppressWarnings("static-method") public void boxBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].booleanValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxByteTest() {
    final byte a = Byte.parseByte("123", 8);
    assert Box.box(a).byteValue() == a;
  }

  @Test @SuppressWarnings("static-method") public void boxByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].byteValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxCharacterTest() {
    assert Box.box('a').charValue() == 'a';
  }

  @Test @SuppressWarnings("static-method") public void boxCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].charValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxDoubleTest() {
    assert Box.box(5.7).doubleValue() == 5.7;
  }

  @Test @SuppressWarnings("static-method") public void boxDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].doubleValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxFloatTest() {
    assert Box.box(5).floatValue() == 5;
  }

  @Test @SuppressWarnings("static-method") public void boxFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].floatValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxIntegerTest() {
    assert Box.box(3).intValue() == 3;
  }

  @Test @SuppressWarnings("static-method") public void boxIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].intValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxLongTest() {
    assert Box.box(1232144).longValue() == 1232144;
  }

  @Test @SuppressWarnings("static-method") public void boxLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].longValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void boxShortTest() {
    assert Box.box(96).shortValue() == 96;
  }

  @Test @SuppressWarnings("static-method") public void boxShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] boxa = Box.box(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert boxa[¢].shortValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itBoolTest() {
    final boolean a = true;
    assert Box.it(a).booleanValue() == a;
    assert !Box.it(false).booleanValue();
  }

  @Test @SuppressWarnings("static-method") public void itBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].booleanValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itByteTest() {
    final byte a = Byte.parseByte("123", 8);
    assert Box.it(a).byteValue() == a;
  }

  @Test @SuppressWarnings("static-method") public void itByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].byteValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itCharacterTest() {
    assert Box.it('a').charValue() == 'a';
  }

  @Test @SuppressWarnings("static-method") public void itCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].charValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itDoubleTest() {
    assert Box.it(5.7).doubleValue() == 5.7;
  }

  @Test @SuppressWarnings("static-method") public void itDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].doubleValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itFloatTest() {
    assert Box.it(5).floatValue() == 5;
  }

  @Test @SuppressWarnings("static-method") public void itFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].floatValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itIntegerTest() {
    assert Box.it(3).intValue() == 3;
  }

  @Test @SuppressWarnings("static-method") public void itIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].intValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itLongTest() {
    assert Box.it(1232144).longValue() == 1232144;
  }

  @Test @SuppressWarnings("static-method") public void itLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].longValue() == a[¢];
  }

  @Test @SuppressWarnings("static-method") public void itShortTest() {
    assert Box.it(96).shortValue() == 96;
  }

  @Test @SuppressWarnings("static-method") public void itShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] ita = Box.it(a);
    for (int ¢ = 0; ¢ < 2; ++¢)
      assert ita[¢].shortValue() == a[¢];
  }
}
