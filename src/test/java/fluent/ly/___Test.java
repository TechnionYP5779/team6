package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class ___Test {
  @Test public void ensure() {
    ___.ensure(true);
    try {
      ___.ensure(false);
    } catch (final ___.Bug.Contract.Postcondition e) {
      azzert.that("", is(e.getMessage()));
    }
    try {
      ___.ensure(false, "ensure");
    } catch (final ___.Bug.Contract.Postcondition e) {
      azzert.that("ensure", is(e.getMessage()));
    }
    try {
      ___.ensure(false, "ensure %s message %s", "this", "now");
    } catch (final ___.Bug.Contract.Postcondition e) {
      azzert.that("ensure this message now", is(e.getMessage()));
    }
  }

  @Test public void negative() {
    ___.negative(-1);
    ___.negative(-2);
    ___.negative(-0.3);
    try {
      ___.negative(0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      azzert.that("Found 0 while expecting a negative integer.", is(¢.getMessage()));
    }
    try {
      ___.negative(0.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      azzert.that("Found 0.00000 while expecting a negative number.", is(¢.getMessage()));
    }
    try {
      ___.negative(-1);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      azzert.that("Found -1 while expecting a negative integer.", is(¢.getMessage()));
    }
    try {
      ___.negative(-1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Negative ¢) {
      azzert.that("Found -1.00000 while expecting a negative number.", is(¢.getMessage()));
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
      azzert.that("Found -1 while expecting a negative integer.", is(¢.getMessage()));
    }
    try {
      ___.nonnegative(1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.NonNegative ¢) {
      azzert.that("Found -1.00000 while expecting a negative number.", is(¢.getMessage()));
    }
  }

  @Test public void nonnull() {
    ___.nonnull(new Object());
    try {
      ___.nonnull(null);
    } catch (final Exception ¢) {
      azzert.that("", is(¢.getMessage()));
    }
    try {
      ___.nonnull(null, "nonnull");
    } catch (final Exception ¢) {
      azzert.that("nonnull", is(¢.getMessage()));
    }
    try {
      ___.nonnull(null, "nonnull %s message %s", "this", "now");
    } catch (final Exception ¢) {
      azzert.that("nonnull this message now", is(¢.getMessage()));
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
      azzert.that("Found -1 while expecting a nonpositive integer.", is(¢.getMessage()));
    }
    try {
      ___.nonpositive(-1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.NonPositive ¢) {
      azzert.that("Found -1.00000 while expecting a nonpositive number.", is(¢.getMessage()));
    }
  }

  @Test public void positive() {
    ___.positive(1);
    ___.positive(2);
    ___.positive(0.3);
    try {
      ___.positive(0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      azzert.that("Found 0 while expecting a positive integer.", is(¢.getMessage()));
    }
    try {
      ___.positive(0.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      azzert.that("Found 0.00000 while expecting a positive number.", is(¢.getMessage()));
    }
    try {
      ___.positive(-1);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      azzert.that("Found -1 while expecting a positive integer.", is(¢.getMessage()));
    }
    try {
      ___.positive(-1.0);
    } catch (final ___.Bug.Assertion.Value.Numerical.Positive ¢) {
      azzert.that("Found -1.00000 while expecting a positive number.", is(¢.getMessage()));
    }
  }

  @Test public void require() {
    ___.require(true);
    try {
      ___.require(false);
    } catch (final ___.Bug.Contract.Precondition ¢) {
      azzert.that("", is(¢.getMessage()));
    }
    try {
      ___.require(false, "requireMessage");
    } catch (final ___.Bug.Contract.Precondition ¢) {
      azzert.that("requireMessage", is(¢.getMessage()));
    }
    try {
      ___.require(false, "require %s message %s", "this", "now");
    } catch (final ___.Bug.Contract.Precondition ¢) {
      azzert.that("require this message now", is(¢.getMessage()));
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
      azzert.that("", is(¢.getMessage()));
    }
    try {
      ___.sure(false, "sure");
    } catch (final ___.Bug.Assertion.Invariant ¢) {
      azzert.that("sure", is(¢.getMessage()));
    }
    try {
      ___.sure(false, "sure %s message %s", "this", "now");
    } catch (final ___.Bug.Assertion.Invariant ¢) {
      azzert.that("sure this message now", is(¢.getMessage()));
    }
  }

  @Test public void unreachable() {
    try {
      ___.unreachable();
    } catch (final ___.Bug.Assertion.Reachability ¢) {
      azzert.that("", is(¢.getMessage()));
    }
    try {
      ___.unreachable("unreachable message");
    } catch (final ___.Bug.Assertion.Reachability ¢) {
      azzert.that("unreachable message", is(¢.getMessage()));
    }
    try {
      ___.unreachable("unreachable %s message %s", "this", "now");
    } catch (final ___.Bug.Assertion.Reachability ¢) {
      azzert.that("unreachable this message now", is(¢.getMessage()));
    }
  }

  @Test public void variant() {
    {
      final ___.Variant v = new ___.Variant(10);
      azzert.that(10, is(v.value()));
      v.check(9);
      v.check(8);
      v.check(4);
      v.check(2);
      v.check(1);
      v.check(0);
      azzert.that(0, is(v.value()));
    }
    try {
      forget.unused(new ___.Variant(-1));
    } catch (final ___.Bug.Assertion.Variant.Initial ¢) {
      azzert.that("Initial variant value (-1) is negative", is(¢.getMessage()));
    }
    try {
      final ___.Variant v = new ___.Variant(10);
      v.check(8);
      v.check(9);
    } catch (final ___.Bug.Assertion.Variant.Nondecreasing ¢) {
      azzert.that("New variant value (9) should be less than previous value (8)", is(¢.getMessage()));
    }
    try {
      final ___.Variant v = new ___.Variant(10);
      v.check(8);
      v.check(-2);
    } catch (final ___.Bug.Assertion.Variant.Underflow ¢) {
      azzert.that("New variant value (-2) is negative", is(¢.getMessage()));
    }
  }
}
