package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

public class BoolTest {
  //check if all constructors provide the same expected result
  @SuppressWarnings("static-method") @Test public void consTest() {
    Bool vot = Bool.valueOf(true);
    Bool ct = new Bool(true);
    Bool cd = new Bool();
    Bool vof = Bool.valueOf(false);
    Bool cf = new Bool(false);
    assertTrue(vot.inner==ct.inner);
    assertFalse(vot.inner==cd.inner);
    assertTrue(vof.inner==cf.inner);
    assertFalse(vof.inner==vot.inner);
  }
  //check if clear() provide expected result
  @SuppressWarnings("static-method") @Test public void clearTest() {
    Bool ct = new Bool(true);
    Bool cf = new Bool(false);
    cf.clear();
    assertFalse(ct.inner==cf.inner);
    ct.clear();
    assertTrue(ct.inner==cf.inner);
  }
//check if get() provide expected result
  @SuppressWarnings("static-method") @Test public void getTest() {
    Bool ct1 = new Bool(true);
    Bool ct2 = new Bool(true);
    Bool cf1 = new Bool(false);
    Bool cf2 = new Bool(false);
    assertFalse(ct1.get()==cf1.get());
    assertTrue(ct1.get()==ct2.get());
    assertTrue(cf1.get()==cf2.get());
  }
  
//check if inner() provide expected result
  @SuppressWarnings("static-method") @Test public void innerTest() {
    Bool ct1 = new Bool(true);
    Bool ct2 = new Bool(true);
    Bool cf1 = new Bool(false);
    Bool cf2 = new Bool(false);
    assertFalse(ct1.inner().equals(cf1.inner()));
    assertTrue(ct1.inner().equals(ct2.inner()));
    assertTrue(cf1.inner().equals(cf2.inner()));
  }
  
  //check if set() provide expected result
  @SuppressWarnings("static-method") @Test public void setTest() {
    Bool ct = new Bool(true);
    Bool cf = new Bool(false);
    ct.set();
    assertFalse(ct.inner==cf.inner);
    cf.set();
    assertTrue(ct.inner==cf.inner);
    cf.set(true);
    assertTrue(ct.inner==cf.inner);
    cf.set(false);
    assertFalse(ct.inner==cf.inner);
  }
  
}
