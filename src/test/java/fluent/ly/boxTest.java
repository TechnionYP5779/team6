package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

public class boxTest {
  @SuppressWarnings("static-method") @Test public void boxBoolTest() {
    final boolean a = true;
    final Boolean boxa = box.box(a);
    assertTrue(boxa.booleanValue() == a);
    final boolean b = false;
    final Boolean boxb = box.box(b);
    assertTrue(boxb.booleanValue() == b);
  }

  @SuppressWarnings("static-method") @Test public void boxBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].booleanValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxByteTest() {
    final byte a = Byte.parseByte("123", 8);
    final Byte boxa = box.box(a);
    assertTrue(boxa.byteValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].byteValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxCharacterTest() {
    final char a = 'a';
    final Character boxa = box.box(a);
    assertTrue(boxa.charValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].charValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxDoubleTest() {
    final double a = 5.7;
    final Double boxa = box.box(a);
    assertTrue(boxa.doubleValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].doubleValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxFloatTest() {
    final float a = 5;
    final Float boxa = box.box(a);
    assertTrue(boxa.floatValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].floatValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxIntegerTest() {
    final int a = 3;
    final Integer boxa = box.box(a);
    assertTrue(boxa.intValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].intValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxLongTest() {
    final long a = 1232144;
    final Long boxa = box.box(a);
    assertTrue(boxa.longValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].longValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void boxShortTest() {
    final short a = 96;
    final Short boxa = box.box(a);
    assertTrue(boxa.shortValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void boxShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] boxa = box.box(a);
    for (int i = 0; i < 2; i++)
      assertTrue(boxa[i].shortValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itBoolTest() {
    final boolean a = true;
    final Boolean ita = box.it(a);
    assertTrue(ita.booleanValue() == a);
    final boolean b = false;
    final Boolean itb = box.it(b);
    assertTrue(itb.booleanValue() == b);
  }

  @SuppressWarnings("static-method") @Test public void itBoolArrayTest() {
    final boolean[] a = { true, false };
    final Boolean[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].booleanValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itByteTest() {
    final byte a = Byte.parseByte("123", 8);
    final Byte ita = box.it(a);
    assertTrue(ita.byteValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itByteArrayTest() {
    final byte[] a = { Byte.parseByte("123", 8), Byte.parseByte("124", 8) };
    final Byte[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].byteValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itCharacterTest() {
    final char a = 'a';
    final Character ita = box.it(a);
    assertTrue(ita.charValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itCharacterArrayTest() {
    final char[] a = { 'a', 'b' };
    final Character[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].charValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itDoubleTest() {
    final double a = 5.7;
    final Double ita = box.it(a);
    assertTrue(ita.doubleValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itDoubleArrayTest() {
    final double[] a = { 5.7, 3.33 };
    final Double[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].doubleValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itFloatTest() {
    final float a = 5;
    final Float ita = box.it(a);
    assertTrue(ita.floatValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itFloatArrayTest() {
    final float[] a = { 5, 9 };
    final Float[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].floatValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itIntegerTest() {
    final int a = 3;
    final Integer ita = box.it(a);
    assertTrue(ita.intValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itIntegerArrayTest() {
    final int[] a = { 3, 1 };
    final Integer[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].intValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itLongTest() {
    final long a = 1232144;
    final Long ita = box.it(a);
    assertTrue(ita.longValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itLongArrayTest() {
    final long[] a = { 1232144, 12312 };
    final Long[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].longValue() == a[i]);
  }

  @SuppressWarnings("static-method") @Test public void itShortTest() {
    final short a = 96;
    final Short ita = box.it(a);
    assertTrue(ita.shortValue() == a);
  }

  @SuppressWarnings("static-method") @Test public void itShortArrayTest() {
    final short[] a = { 96, 12 };
    final Short[] ita = box.it(a);
    for (int i = 0; i < 2; i++)
      assertTrue(ita[i].shortValue() == a[i]);
  }
}
