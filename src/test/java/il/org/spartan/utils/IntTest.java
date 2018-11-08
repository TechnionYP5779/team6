package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class IntTest {
  @SuppressWarnings("static-method") @Test public void constructorTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    assertTrue(boxa.inner == a);
  }

  @SuppressWarnings("static-method") @Test public void innerTest() {
    final Int boxa = new Int(3);
    assertTrue(boxa.inner().equals(Integer.valueOf(3)));
  }

  @SuppressWarnings("static-method") @Test public void valueOfTest() {
    final Int boxa = new Int(3);
    assertTrue(boxa.inner == Int.valueOf(3).inner);
  }

  @SuppressWarnings("static-method") @Test public void stepTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    boxa.step();
    assertTrue(boxa.inner == a + 1);
  }

  @SuppressWarnings("static-method") @Test public void getTest() {
    final Int boxa = new Int(3);
    assertTrue(boxa.get() == boxa.inner);
    assertTrue(boxa.get() == 3);
  }

  @SuppressWarnings("static-method") @Test public void addTest() {
    final int a = 3;
    Int boxa = new Int(a);
    final int b = 5;
    boxa.add(b);
    assertTrue(boxa.inner == a + b);
    boxa = new Int(a);
    final Int boxb = new Int(b);
    boxa.add(boxb);
    assertTrue(boxa.inner == a + b);
  }

  @SuppressWarnings("static-method") @Test public void setTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    boxa.set(7);
    assertTrue(boxa.inner == 7);
  }

  @SuppressWarnings("static-method") @Test public void toStringTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    assertTrue(boxa.toString().equals(3 + ""));
  }

  @SuppressWarnings("static-method") @Test public void nextTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    assertTrue(boxa.next() == a + 1);
    assertTrue(boxa.inner == a + 1);
  }

  @SuppressWarnings("static-method") @Test public void clearTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    boxa.clear();
    assertTrue(boxa.inner == 0);
  }
}
