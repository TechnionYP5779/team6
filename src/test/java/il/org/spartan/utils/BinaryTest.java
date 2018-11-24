package il.org.spartan.utils;

import org.junit.*;

// import static fluent.ly.azzert.is;
public class BinaryTest {
  Binary f = Binary.of(false);
  Binary t = Binary.of(true);

  @Test public void testOf() {
    assert t == Binary.T;
    assert f == Binary.F;
  }

  @Test public void testAnd() {
    assert Binary.and(t, t) == Binary.T;
    assert Binary.and(t, f) == Binary.F;
    assert Binary.and(f, t) == Binary.F;
    assert Binary.and(f, f) == Binary.F;
  }

  @Test public void testOr() {
    assert Binary.or(t, t) == Binary.T;
    assert Binary.or(t, f) == Binary.T;
    assert Binary.or(f, t) == Binary.T;
    assert Binary.or(f, f) == Binary.F;
  }

  @Test public void testAsBoolean() {
    assert Binary.asBoolean(t) == Binary.T;
    assert Binary.asBoolean(f) == Binary.F;
  }

  @Test public void testEq() {
    assert Binary.eq(t, t) == t;
    assert Binary.eq(t, f) == f;
    assert Binary.eq(f, t) == f;
    assert Binary.eq(f, f) == t;
  }

  @Test public void testNot() {
    assert Binary.not(t) == f;
    assert Binary.not(f) == t;
  }
}
