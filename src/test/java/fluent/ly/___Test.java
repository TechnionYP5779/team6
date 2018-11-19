package fluent.ly;

import static org.junit.Assert.assertEquals;

// import static org.junit.Assert.assertEquals;
import static fluent.ly.___.*;
import static fluent.ly.azzert.assertEquals;

import org.junit.*;

@SuppressWarnings("static-method") public class ___Test {
  @Test public void ensure() {
    ___.ensure(true);
    try {
      ___.ensure(false);
    } catch (final ___.Bug.Contract.Postcondition e) {
      assertEquals("", e.getMessage());
    }
    try {
      ___.ensure(false, "ensure");
    } catch (final ___.Bug.Contract.Postcondition e) {
      assertEquals("ensure", e.getMessage());
    }
    try {
      ___.ensure(false, "ensure %s message %s", "this", "now");
    } catch (final ___.Bug.Contract.Postcondition e) {
      assertEquals("ensure this message now", e.getMessage());
    }
  }

  @Test public void negative() {
    ___.negative(-1);
    ___.negative(-2);
    ___.negative(-0.3);
    try {
      ___.negative(0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      assertEquals("Found 0 while expecting a negative integer.", ¢.getMessage());
    }
    try {
      ___.negative(0.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      assertEquals("Found 0.00000 while expecting a negative number.", ¢.getMessage());
    }
    try {
      ___.negative(-1);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      assertEquals("Found -1 while expecting a negative integer.", ¢.getMessage());
    }
    try {
      ___.negative(-1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      assertEquals("Found -1.00000 while expecting a negative number.", ¢.getMessage());
    }
  }

  @Test public void nonnegative() {
    ___.nonnegative(1);
    ___.nonnegative(2);
    ___.nonnegative(0);
    ___.nonnegative(0.3);
    ___.nonnegative(0.0);
    try {
      ___.nonnegative(1);
    } catch (final ___.Bug.Assertion.Value.Numerical.NonNegative ¢) {
      assertEquals("Found -1 while expecting a negative integer.", ¢.getMessage());
    }
    try {
      ___.nonnegative(1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.NonNegative ¢) {
      assertEquals("Found -1.00000 while expecting a negative number.", ¢.getMessage());
    }
  }

  @Test public void nonnull() {
    ___.nonnull(new Object());
    try {
      ___.nonnull(null);
    } catch (final Exception ¢) {
      assertEquals("", ¢.getMessage());
    }
    try {
      ___.nonnull(null, "nonnull");
    } catch (final Exception ¢) {
      assertEquals("nonnull", ¢.getMessage());
    }
    try {
      ___.nonnull(null, "nonnull %s message %s", "this", "now");
    } catch (final Exception ¢) {
      assertEquals("nonnull this message now", ¢.getMessage());
    }
  }

  @Test public void nonpositive() {
    ___.nonpositive(-1);
    ___.nonpositive(-2);
    ___.nonpositive(-0.3);
    ___.nonpositive(0);
    ___.nonpositive(0.0);
    try {
      ___.nonpositive(-1);
    } catch (final ___.Bug.Assertion.Value.Numerical.NonPositive ¢) {
      assertEquals("Found -1 while expecting a nonpositive integer.", ¢.getMessage());
    }
    try {
      ___.nonpositive(-1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.NonPositive ¢) {
      assertEquals("Found -1.00000 while expecting a nonpositive number.", ¢.getMessage());
    }
  }

  @Test public void positive() {
    ___.positive(1);
    ___.positive(2);
    ___.positive(0.3);
    try {
      ___.positive(0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      assertEquals("Found 0 while expecting a positive integer.", ¢.getMessage());
    }
    try {
      ___.positive(0.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      assertEquals("Found 0.00000 while expecting a positive number.", ¢.getMessage());
    }
    try {
      ___.positive(-1);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      assertEquals("Found -1 while expecting a positive integer.", ¢.getMessage());
    }
    try {
      ___.positive(-1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      assertEquals("Found -1.00000 while expecting a positive number.", ¢.getMessage());
    }
  }

  @Test public void require() {
    ___.require(true);
    try {
      ___.require(false);
    } catch (final ___.Bug.Contract.Precondition ¢) {
      assertEquals("", ¢.getMessage());
    }
    try {
      ___.require(false, "requireMessage");
    } catch (final ___.Bug.Contract.Precondition ¢) {
      assertEquals("requireMessage", ¢.getMessage());
    }
    try {
      ___.require(false, "require %s message %s", "this", "now");
    } catch (final ___.Bug.Contract.Precondition ¢) {
      assertEquals("require this message now", ¢.getMessage());
    }
  }

  @Test(expected = ___.Bug.class) public void requireBug() {
    ___.require(false);
  }

  @Test(expected = ___.Bug.Contract.Precondition.class) public void requirePrecondition() {
    ___.require(false);
  }

  @Test public void sure() {
    ___.sure(true);
    try {
      ___.sure(false);
    } catch (final ___.Bug.Assertion.Invariant ¢) {
      assertEquals("", ¢.getMessage());
    }
    try {
      ___.sure(false, "sure");
    } catch (final ___.Bug.Assertion.Invariant ¢) {
      assertEquals("sure", ¢.getMessage());
    }
    try {
      ___.sure(false, "sure %s message %s", "this", "now");
    } catch (final ___.Bug.Assertion.Invariant ¢) {
      assertEquals("sure this message now", ¢.getMessage());
    }
  }

  @Test public void unreachable() {
    try {
      ___.unreachable();
    } catch (final ___.Bug.Assertion.Reachability ¢) {
      assertEquals("", ¢.getMessage());
    }
    try {
      ___.unreachable("unreachable message");
    } catch (final ___.Bug.Assertion.Reachability ¢) {
      assertEquals("unreachable message", ¢.getMessage());
    }
    try {
      ___.unreachable("unreachable %s message %s", "this", "now");
    } catch (final ___.Bug.Assertion.Reachability ¢) {
      assertEquals("unreachable this message now", ¢.getMessage());
    }
  }

  @Test public void variant() {
    {
      final ___.Variant v = new ___.Variant(10);
      assertEquals(10, v.value());
      v.check(9);
      v.check(8);
      v.check(4);
      v.check(2);
      v.check(1);
      v.check(0);
      assertEquals(0, v.value());
    }
    try {
      forget.unused(new ___.Variant(-1));
    } catch (final ___.Bug.Assertion.Variant.Initial ¢) {
      assertEquals("Initial variant value (-1) is negative", ¢.getMessage());
    }
    try {
      final ___.Variant v = new ___.Variant(10);
      v.check(8);
      v.check(9);
    } catch (final ___.Bug.Assertion.Variant.Nondecreasing ¢) {
      assertEquals("New variant value (9) should be less than previous value (8)", ¢.getMessage());
    }
    try {
      final ___.Variant v = new ___.Variant(10);
      v.check(8);
      v.check(-2);
    } catch (final ___.Bug.Assertion.Variant.Underflow ¢) {
      assertEquals("New variant value (-2) is negative", ¢.getMessage());
    }
  }
}
