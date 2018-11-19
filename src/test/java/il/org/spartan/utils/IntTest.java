package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void constructorTest() {
    assert new Int(3).inner == 3;
  }

  @Test public void innerTest() {
    assert new Int(3).inner().equals(Box.box(3));
  }

  @Test public void valueOfTest() {
    assert new Int(3).inner == Int.valueOf(3).inner;
  }

  @Test public void stepTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    boxa.step();
    assert boxa.inner == a + 1;
  }

  @Test public void getTest() {
    final Int boxa = new Int(3);
    assert boxa.get() == boxa.inner;
    assert boxa.get() == 3;
  }

  @Test public void addTest() {
    final int a = 3;
    Int boxa = new Int(a);
    final int b = 5;
    boxa.add(b);
    assert boxa.inner == a + b;
    boxa = new Int(a);
    boxa.add(new Int(b));
    assert boxa.inner == a + b;
  }

  @Test public void setTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    boxa.set(7);
    assert boxa.inner == 7;
  }

  @Test public void toStringTest() {
    assert (new Int(3) + "").equals(3 + "");
  }

  @Test public void nextTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    assert boxa.next() == a + 1;
    assert boxa.inner == a + 1;
  }

  @Test public void clearTest() {
    final int a = 3;
    final Int boxa = new Int(a);
    boxa.clear();
    assert boxa.inner == 0;
  }
}
