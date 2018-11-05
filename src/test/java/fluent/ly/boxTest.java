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
  @SuppressWarnings("static-method") @Test public void boxByteTest() {
    byte a= Byte.parseByte("123",8);
    Byte boxa = box.box(a);
    assertTrue(boxa.byteValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxCharacterTest() {
    char a='a';
    Character boxa = box.box(a);
    assertTrue(boxa.charValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxDoubleTest() {
    double a=5.7;
    Double boxa = box.box(a);
    assertTrue(boxa.doubleValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxFloatTest() {
    float a=5;
    Float boxa = box.box(a);
    assertTrue(boxa.floatValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxIntegerTest() {
    int a=3;
    Integer boxa = box.box(a);
    assertTrue(boxa.intValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxLongTest() {
    long a=1232144;
    Long boxa = box.box(a);
    assertTrue(boxa.longValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void boxShortTest() {
    short a=96;
    Short boxa = box.box(a);
    assertTrue(boxa.shortValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itBoolTest() {
    boolean a=true;
    Boolean ita = box.it(a);
    assertTrue(ita.booleanValue()==a);
    boolean b=false;
    Boolean itb = box.it(b);
    assertTrue(itb.booleanValue()==b);
  }
  @SuppressWarnings("static-method") @Test public void itByteTest() {
    byte a= Byte.parseByte("123",8);
    Byte ita = box.it(a);
    assertTrue(ita.byteValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itCharacterTest() {
    char a='a';
    Character ita = box.it(a);
    assertTrue(ita.charValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itDoubleTest() {
    double a=5.7;
    Double ita = box.it(a);
    assertTrue(ita.doubleValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itFloatTest() {
    float a=5;
    Float ita = box.it(a);
    assertTrue(ita.floatValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itIntegerTest() {
    int a=3;
    Integer ita = box.it(a);
    assertTrue(ita.intValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itLongTest() {
    long a=1232144;
    Long ita = box.it(a);
    assertTrue(ita.longValue()==a);
  }
  @SuppressWarnings("static-method") @Test public void itShortTest() {
    short a=96;
    Short ita = box.it(a);
    assertTrue(ita.shortValue()==a);
  }

  
 
}
