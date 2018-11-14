package il.org.spartan.utils;



import org.junit.*;

public class IntTest {
  @Test @SuppressWarnings("static-method") public void constructorTest() {
    assert (new Int(3)).inner == 3;
  }

  @Test @SuppressWarnings("static-method") public void innerTest() {
    assert (new Int(3)).inner().equals(Integer.valueOf(3));
  }

  @Test @SuppressWarnings("static-method") public void valueOfTest() {
    assert (new Int(3)).inner == Int.valueOf(3).inner;
  }

  @Test @SuppressWarnings("static-method") public void stepTest() {
    int a = 3;
    Int boxa = new Int(a);
    boxa.step();
    assert boxa.inner == (a + 1);
  }

  @Test @SuppressWarnings("static-method") public void getTest() {
    Int boxa = new Int(3);
    assert boxa.get() == boxa.inner;
    assert boxa.get() == 3;
  }

  @Test @SuppressWarnings("static-method") public void addTest() {
    int a = 3;
    Int boxa = new Int(a);
    int b = 5;
    boxa.add(b);
    assert boxa.inner == (a + b);
    boxa = new Int(a);
    boxa.add(new Int(b));
    assert boxa.inner == (a + b);
  }

  @Test @SuppressWarnings("static-method") public void setTest() {
    int a = 3;
    Int boxa = new Int(a);
    boxa.set(7);
    assert boxa.inner == 7;
  }

  @Test @SuppressWarnings("static-method") public void toStringTest() {
    assert (new Int(3) + "").equals(3 + "");
  }

  @Test @SuppressWarnings("static-method") public void nextTest() {
    int a = 3;
    Int boxa = new Int(a);
    assert boxa.next() == (a + 1);
    assert boxa.inner == (a + 1);
  }

  @Test @SuppressWarnings("static-method") public void clearTest() {
    int a = 3;
    Int boxa = new Int(a);
    boxa.clear();
    assert boxa.inner == 0;
  }
}
