package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class BoolTest {
  @Test @SuppressWarnings({ "static-method", "null" }) public void consTest() {
    final Bool vot = Bool.valueOf(true), cd = new Bool(), vof = Bool.valueOf(false), cf = new Bool(false);
    azzert.that( vot.inner ,azzert.is( new Bool(true).inner));
    azzert.that( vot.inner ,azzert.not( cd.inner));
    azzert.that( vof.inner ,azzert.is( cf.inner));
    azzert.that( vof.inner ,azzert.not( vot.inner));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void clearTest() {
    final Bool ct = new Bool(true), cf = new Bool(false);
    cf.clear();
    azzert.that( ct.inner ,azzert.not( cf.inner));
    ct.clear();
    azzert.that( ct.inner ,azzert.is( cf.inner));
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void getTest() {
    final Bool ct1 = new Bool(true), ct2 = new Bool(true), cf1 = new Bool(false), cf2 = new Bool(false);
    azzert.that( ct1.get(),azzert.not( cf1.get()));
    azzert.that( ct1.get() ,azzert.is( ct2.get()));
    azzert.that( cf1.get() ,azzert.is( cf2.get()));
  }

  @Test @SuppressWarnings("static-method") public void innerTest() {
    final Bool ct1 = new Bool(true), ct2 = new Bool(true), cf1 = new Bool(false), cf2 = new Bool(false);
    assert !ct1.inner().equals(cf1.inner());
    assert ct1.inner().equals(ct2.inner());
    assert cf1.inner().equals(cf2.inner());
  }

  @Test @SuppressWarnings({ "static-method", "null" }) public void setTest() {
    final Bool ct = new Bool(true), cf = new Bool(false);
    ct.set();
    azzert.that( ct.inner ,azzert.not( cf.inner));
    cf.set();
    azzert.that( ct.inner ,azzert.is( cf.inner));
    cf.set(true);
    azzert.that( ct.inner ,azzert.is( cf.inner));
    cf.set(false);
    azzert.that( ct.inner ,azzert.not( cf.inner));
  }
}
