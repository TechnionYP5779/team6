package il.org.spartan.utils;

import org.junit.*;

public class BoolTest {
  @Test @SuppressWarnings("static-method") public void consTest() {
    final Bool vot = Bool.valueOf(true), cd = new Bool(), vof = Bool.valueOf(false), cf = new Bool(false);
    assert vot.inner == new Bool(true).inner;
    assert vot.inner != cd.inner;
    assert vof.inner == cf.inner;
    assert vof.inner != vot.inner;
  }

  @Test @SuppressWarnings("static-method") public void clearTest() {
    final Bool ct = new Bool(true), cf = new Bool(false);
    cf.clear();
    assert ct.inner != cf.inner;
    ct.clear();
    assert ct.inner == cf.inner;
  }

  @Test @SuppressWarnings("static-method") public void getTest() {
    final Bool ct1 = new Bool(true), ct2 = new Bool(true), cf1 = new Bool(false), cf2 = new Bool(false);
    assert ct1.get() != cf1.get();
    assert ct1.get() == ct2.get();
    assert cf1.get() == cf2.get();
  }

  @Test @SuppressWarnings("static-method") public void innerTest() {
    final Bool ct1 = new Bool(true), ct2 = new Bool(true), cf1 = new Bool(false), cf2 = new Bool(false);
    assert !ct1.inner().equals(cf1.inner());
    assert ct1.inner().equals(ct2.inner());
    assert cf1.inner().equals(cf2.inner());
  }

  @Test @SuppressWarnings("static-method") public void setTest() {
    final Bool ct = new Bool(true), cf = new Bool(false);
    ct.set();
    assert ct.inner != cf.inner;
    cf.set();
    assert ct.inner == cf.inner;
    cf.set(true);
    assert ct.inner == cf.inner;
    cf.set(false);
    assert ct.inner != cf.inner;
  }
}
