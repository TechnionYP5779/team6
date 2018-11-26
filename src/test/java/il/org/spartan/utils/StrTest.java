package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
/**
* For tested class please see {@link il.org.spartan.utils.Str} .
*/
@SuppressWarnings("static-method") public class StrTest {
  @Test public void emptyTest() {
    azzert.isNull(new Str().inner());
    assert new Str().isEmptyx();
    assert !new Str().notEmpty();
  }

  @Test public void notEmptyTest() {
    final Str abc = new Str("abc");
    assert "abc".equals(abc.inner());
    assert abc.notEmpty();
    assert !abc.isEmptyx();
  }

  @Test public void setTest() {
    final Str empty = new Str(), abc = new Str("abc");
    empty.set("notnull");
    abc.set("cba");
    assert "cba".equals(abc.inner());
    assert "notnull".equals(empty.inner());
  }
}
