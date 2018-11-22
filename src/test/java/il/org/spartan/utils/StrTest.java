package il.org.spartan.utils;

import org.junit.*;


import fluent.ly.azzert;

@SuppressWarnings("static-method") public class StrTest {
   @Test public void emptyTest() {
    azzert.isNull((new Str()).inner());
    assert (new Str()).isEmptyx();
    assert !((new Str()).notEmpty());
  }
   
   @Test public void notEmptyTest() {
     Str abc = new Str("abc");
     assert "abc".equals(abc.inner());
     assert abc.notEmpty();
     assert !(abc.isEmptyx());
   }
   
   @Test public void setTest() {
     Str empty = new Str();
     Str abc = new Str("abc");
     empty.set("notnull");
     abc.set("cba");
     assert "cba".equals(abc.inner());
     assert "notnull".equals(empty.inner());
   }
}
