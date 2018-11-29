package il.org.spartan.utils;

import static il.org.spartan.utils.AnyRange.*;

import static fluent.ly.azzert.*;
import static fluent.ly.forget.*;

import org.junit.*;

import fluent.ly.*;

/** For tested class please see {@link il.org.spartan.utils.AnyRange} . */
public class AnyRangeTest {
  @Test @SuppressWarnings("static-method") public void consTest11() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, 10);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    ______unused(range);
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void consTest21() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      azzert.that(0, is(range.getTo()));
      azzert.that(range.getStep(), is(-10));
    } catch (final Throwable ¢) {
      ______unused(¢);
      assert false;
    }
  }

  @Test @SuppressWarnings("static-method") public void toTest1() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range.to(5);
      azzert.that(range.getTo(), is(5));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void fromTest11() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range.from(5);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void fromTest21() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range.from(-5);
    } catch (final Throwable ¢) {
      ______unused(¢);
      assert false;
    }
  }

  @Test @SuppressWarnings("static-method") public void stepTest1() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      try {
        range.step(3);
      } catch (final Throwable ¢) {
        ______unused(¢);
        return;
      }
      assert false;
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void hashCodeTest1() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      azzert.that(range.hashCode(), is(-10));
      range = new AnyRange.BoundedAboveRange(3, -1);
      azzert.that(range.hashCode(), is(-2));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void mergeTest1() {
    AnyRange.BoundedAboveRange range = null, range2 = null, merged_range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range2 = new AnyRange.BoundedAboveRange(3, -9);
      merged_range = range.merge(range2);
      azzert.that(merged_range.getTo(), is(3));
      azzert.that(merged_range.getStep(), is(-10));
      range2 = new AnyRange.BoundedAboveRange(-3, -19);
      merged_range = range.merge(range2);
      azzert.that(merged_range.getTo(), is(0));
      azzert.that(merged_range.getStep(), is(-19));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void IncludedInTest1() {
    AnyRange.BoundedAboveRange range = null, range2 = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range2 = new AnyRange.BoundedAboveRange(3, -9);
      assert range.includedIn(range2);
      assert !range2.includedIn(range);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void overLappingTest1() {
    AnyRange.BoundedAboveRange range = null, range2 = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range2 = new AnyRange.BoundedAboveRange(3, -9);
      assert range.overlapping(range2);
      assert range2.overlapping(range);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings({ "static-method", "unlikely-arg-type" }) public void euaqlsTest1() {
    AnyRange.BoundedAboveRange range = null, range2 = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      range2 = new AnyRange.BoundedAboveRange(0, -9);
      assert !range.equals(Integer.valueOf(1));
      assert !range.equals(range2);
      range2 = new AnyRange.BoundedAboveRange(1, -10);
      assert !range.equals(range2);
      range2 = new AnyRange.BoundedAboveRange(0, -10);
      assert range.equals(range2);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void toStringTest1() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, -10);
      azzert.that(range + "", is("[0, -10]"));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void consTest12() {
    AnyRange.BoundedBelowRange range = null;
    try { // invalid step , should be negative
      range = new AnyRange.BoundedBelowRange(0, -10);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    ______unused(range);
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void consTest22() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      azzert.that(range.getFrom(), is(0));
      azzert.that(range.getStep(), is(10));
    } catch (final Throwable ¢) {
      ______unused(¢);
      assert false;
    }
  }

  @Test @SuppressWarnings("static-method") public void fromTest2() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range.from(5);
      azzert.that(range.getFrom(), is(5));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void toTest12() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range.to(-5);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void toTest22() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range.to(5);
    } catch (final Throwable ¢) {
      ______unused(¢);
      assert false;
    }
  }

  @Test @SuppressWarnings("static-method") public void stepTest2() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      try {
        range.step(-3);
      } catch (final Throwable ¢) {
        ______unused(¢);
        return;
      }
      assert false;
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void hashCodeTest2() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      azzert.that(range.hashCode(), is(10));
      range = new AnyRange.BoundedBelowRange(-3, 1);
      azzert.that(range.hashCode(), is(2));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void mergeTest2() {
    AnyRange.BoundedBelowRange range = null, range2 = null, merged_range = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range2 = new AnyRange.BoundedBelowRange(3, 9);
      merged_range = range.merge(range2);
      azzert.that(merged_range.getFrom(), is(0));
      azzert.that(merged_range.getStep(), is(9));
      range2 = new AnyRange.BoundedBelowRange(-3, 11);
      merged_range = range.merge(range2);
      azzert.that(merged_range.getFrom(), is(-3));
      azzert.that(merged_range.getStep(), is(10));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void IncludedInTest2() {
    AnyRange.BoundedBelowRange range = null, range2 = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range2 = new AnyRange.BoundedBelowRange(3, 9);
      assert range2.includedIn(range);
      assert !range.includedIn(range2);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void overLappingTest2() {
    AnyRange.BoundedBelowRange range = null, range2 = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range2 = new AnyRange.BoundedBelowRange(3, 9);
      assert range.overlapping(range2);
      assert range2.overlapping(range);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings({ "static-method", "unlikely-arg-type" }) public void euaqlsTest2() {
    AnyRange.BoundedBelowRange range = null, range2 = null;
    try {
      range = new AnyRange.BoundedBelowRange(0, 10);
      range2 = new AnyRange.BoundedBelowRange(0, 9);
      assert !range.equals(Integer.valueOf(1));
      assert !range.equals(range2);
      range2 = new AnyRange.BoundedBelowRange(1, 10);
      assert !range.equals(range2);
      range2 = new AnyRange.BoundedBelowRange(0, 10);
      assert range.equals(range2);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void toStringTest2() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = new AnyRange.BoundedAboveRange(0, 10);
      azzert.that(range + "", is("[0, 10]"));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void consTest13() {
    AnyRange.FiniteRange range = null;
    try { // invalid step , should be negative
      range = new AnyRange.FiniteRange(0, -1, 1);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    ______unused(range);
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void consTest23() {
    AnyRange.FiniteRange range = null;
    try { // invalid step , should be negative
      range = new AnyRange.FiniteRange(0, 1, -1);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    ______unused(range);
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void consTest33() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      azzert.that(range.getFrom(), is(0));
      azzert.that(range.getTo(), is(10));
      azzert.that(range.getStep(), is(1));
    } catch (final Throwable ¢) {
      ______unused(¢);
      assert false;
    }
  }

  @Test @SuppressWarnings("static-method") public void fromTest13() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range.from(15);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void fromTest23() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range.from(5);
      azzert.that(range.getFrom(), is(5));
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void toTest3() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range.to(-5);
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
    assert false;
  }

  @Test @SuppressWarnings("static-method") public void toTest13() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range.to(5);
      azzert.that(range.getTo(), is(5));
    } catch (final Throwable ¢) {
      ______unused(¢);
      return;
    }
  }

  @Test @SuppressWarnings({ "static-method", "unlikely-arg-type" }) public void euaqlsTest3() {
    AnyRange.FiniteRange range = null, range2 = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range2 = new AnyRange.FiniteRange(0, 9, 1);
      assert !range.equals(Integer.valueOf(1));
      assert !range.equals(range2);
      range2 = new AnyRange.FiniteRange(1, 10, 1);
      assert !range.equals(range2);
      range2 = new AnyRange.FiniteRange(0, 10, 2);
      assert !range.equals(range2);
      range2 = new AnyRange.FiniteRange(0, 10, 1);
      assert range.equals(range2);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void stepTest3() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      try {
        range.step(-3);
      } catch (final Throwable ¢) {
        ______unused(¢);
        return;
      }
      assert false;
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void hashCodeTest3() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      azzert.that(range.hashCode(), is(55));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void sizeTest3() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      azzert.that(range.size(), is(10));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void mergeTest3() {
    AnyRange.FiniteRange range = null, range2 = null, merged_range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 3);
      range2 = new AnyRange.FiniteRange(3, 9, 4);
      merged_range = range.merge(range2);
      azzert.that(merged_range.getFrom(), is(0));
      azzert.that(merged_range.getStep(), is(9));
      azzert.that(merged_range.getTo(), is(10));
      range2 = new AnyRange.FiniteRange(-3, 11, 2);
      merged_range = range.merge(range2);
      azzert.that(merged_range.getFrom(), is(-3));
      azzert.that(merged_range.getStep(), is(10));
      azzert.that(merged_range.getTo(), is(11));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void IncludedInTest3() {
    AnyRange.FiniteRange range = null, range2 = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range2 = new AnyRange.FiniteRange(3, 9, 1);
      assert range2.includedIn(range);
      assert !range.includedIn(range2);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void overLappingTest3() {
    AnyRange.FiniteRange range = null, range2 = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      range2 = new AnyRange.FiniteRange(3, 9, 1);
      assert range.overlapping(range2);
      assert range2.overlapping(range);
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void toStringTest3() {
    AnyRange.FiniteRange range = null;
    try {
      range = new AnyRange.FiniteRange(0, 10, 1);
      azzert.that(range + "", is("[0, 10]"));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void fromTest4() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = from(2);
      azzert.that(range.from, is(2));
      azzert.that(range.step, is(0));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void toTest4() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = to(2);
      azzert.that(range.getTo(), is(2));
      azzert.that(range.getStep(), is(0));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void naturalsTest4() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = naturals();
      azzert.that(range.from, is(1));
      azzert.that(range.step, is(1));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void positiveOddsTest4() {
    AnyRange.BoundedBelowRange range = null;
    try {
      range = Positiveodds();
      azzert.that(range.from, is(1));
      azzert.that(range.step, is(2));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }

  @Test @SuppressWarnings("static-method") public void negativeOddsTest4() {
    AnyRange.BoundedAboveRange range = null;
    try {
      range = Negativeodds();
      azzert.that(range.getTo(), is(-1));
      azzert.that(range.getStep(), is(-2));
    } catch (final Throwable ¢) {
      ______unused(¢);
    }
  }
}
