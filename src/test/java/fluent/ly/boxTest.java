package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

public class boxTest {
  @SuppressWarnings("static-method") @Test public void boxBoolTest() {
    boolean a=true;
    Boolean boxa = box.box(a);
    assertTrue(boxa.booleanValue()==a);
    boolean b=false;
    Boolean boxb = box.box(b);
    assertTrue(boxb.booleanValue()==b);
  }
  @SuppressWarnings("static-method") @Test public void boxBoolArrayTest() {
      boolean [] a= {true,false};
      Boolean[] boxa = box.box(a);
      for(int i=0;i<2;i++) {
        assertTrue(boxa[i].booleanValue()==a[i]);
      }
    }
  @SuppressWarnings("static-method") @Test public void boxByteTest() {
    byte a= Byte.parseByte("123",8);
    Byte boxa = box.box(a);
    assertTrue(boxa.byteValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxByteArrayTest() {
    byte[] a= {Byte.parseByte("123",8),Byte.parseByte("124",8)};
    Byte[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
      assertTrue(boxa[i].byteValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void boxCharacterTest() {
    char a='a';
    Character boxa = box.box(a);
    assertTrue(boxa.charValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxCharacterArrayTest() {
    char[] a= {'a','b'};
    Character[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
      assertTrue(boxa[i].charValue()==a[i]);
    }
  }
  
  @SuppressWarnings("static-method") @Test public void boxDoubleTest() {
    double a=5.7;
    Double boxa = box.box(a);
    assertTrue(boxa.doubleValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxDoubleArrayTest() {
    double[] a= {5.7,3.33};
    Double[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
    assertTrue(boxa[i].doubleValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void boxFloatTest() {
    float a=5;
    Float boxa = box.box(a);
    assertTrue(boxa.floatValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxFloatArrayTest() {
    float[] a= {5,9};
    Float[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
    assertTrue(boxa[i].floatValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void boxIntegerTest() {
    int a=3;
    Integer boxa = box.box(a);
    assertTrue(boxa.intValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxIntegerArrayTest() {
    int[] a= {3,1};
    Integer[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
    assertTrue(boxa[i].intValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void boxLongTest() {
    long a=1232144;
    Long boxa = box.box(a);
    assertTrue(boxa.longValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxLongArrayTest() {
    long[] a= {1232144,12312};
    Long[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
    assertTrue(boxa[i].longValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void boxShortTest() {
    short a=96;
    Short boxa = box.box(a);
    assertTrue(boxa.shortValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxShortArrayTest() {
    short[] a= {96,12};
    Short[] boxa = box.box(a);
    for(int i=0;i<2;i++) {
    assertTrue(boxa[i].shortValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void itBoolTest() {
    boolean a=true;
    Boolean ita = box.it(a);
    assertTrue(ita.booleanValue()==a);
    boolean b=false;
    Boolean itb = box.it(b);
    assertTrue(itb.booleanValue()==b);
  }
  @SuppressWarnings("static-method") @Test public void itBoolArrayTest() {
      boolean [] a= {true,false};
      Boolean[] ita = box.it(a);
      for(int i=0;i<2;i++) {
        assertTrue(ita[i].booleanValue()==a[i]);
      }
    }
  @SuppressWarnings("static-method") @Test public void itByteTest() {
    byte a= Byte.parseByte("123",8);
    Byte ita = box.it(a);
    assertTrue(ita.byteValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itByteArrayTest() {
    byte[] a= {Byte.parseByte("123",8),Byte.parseByte("124",8)};
    Byte[] ita = box.it(a);
    for(int i=0;i<2;i++) {
      assertTrue(ita[i].byteValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void itCharacterTest() {
    char a='a';
    Character ita = box.it(a);
    assertTrue(ita.charValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itCharacterArrayTest() {
    char[] a= {'a','b'};
    Character[] ita = box.it(a);
    for(int i=0;i<2;i++) {
      assertTrue(ita[i].charValue()==a[i]);
    }
  }
  
  @SuppressWarnings("static-method") @Test public void itDoubleTest() {
    double a=5.7;
    Double ita = box.it(a);
    assertTrue(ita.doubleValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itDoubleArrayTest() {
    double[] a= {5.7,3.33};
    Double[] ita = box.it(a);
    for(int i=0;i<2;i++) {
    assertTrue(ita[i].doubleValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void itFloatTest() {
    float a=5;
    Float ita = box.it(a);
    assertTrue(ita.floatValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itFloatArrayTest() {
    float[] a= {5,9};
    Float[] ita = box.it(a);
    for(int i=0;i<2;i++) {
    assertTrue(ita[i].floatValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void itIntegerTest() {
    int a=3;
    Integer ita = box.it(a);
    assertTrue(ita.intValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itIntegerArrayTest() {
    int[] a= {3,1};
    Integer[] ita = box.it(a);
    for(int i=0;i<2;i++) {
    assertTrue(ita[i].intValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void itLongTest() {
    long a=1232144;
    Long ita = box.it(a);
    assertTrue(ita.longValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itLongArrayTest() {
    long[] a= {1232144,12312};
    Long[] ita = box.it(a);
    for(int i=0;i<2;i++) {
    assertTrue(ita[i].longValue()==a[i]);
    }
  }
  @SuppressWarnings("static-method") @Test public void itShortTest() {
    short a=96;
    Short ita = box.it(a);
    assertTrue(ita.shortValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itShortArrayTest() {
    short[] a= {96,12};
    Short[] ita = box.it(a);
    for(int i=0;i<2;i++) {
    assertTrue(ita[i].shortValue()==a[i]);
    }
  }
  
 
}
