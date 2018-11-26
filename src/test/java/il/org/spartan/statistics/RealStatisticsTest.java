package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
/**
* For tested class please see {@link il.org.spartan.statistics.RealStatistics} .
*/
@SuppressWarnings("static-method") public class RealStatisticsTest {
  final RealStatistics s11_20_5 = new RealStatistics().record(11).record(20).record(5);
  final RealStatistics s15 = new RealStatistics().record(5).record(3).record(1).record(2).record(4);
  final RealStatistics s07 = new RealStatistics().record(0).record(5).record(6).record(3).record(1).record(2).record(4).record(7);
  final RealStatistics s_4x0_5x1 = new RealStatistics().record(0).record(0).record(0).record(0)//
      .record(1).record(1).record(1).record(1).record(1);
  final ImmutableStatistics s = new RealStatistics().record(11).record(20).record(5);

  @Test public void all() {
    s11_20_5.median();
    s11_20_5.mad();
    final double @NotNull [] vs = s11_20_5.all();
    azzert.that(vs.length, is(3));
    azzert.that(11, is(vs[0]));
    azzert.that(20, is(vs[1]));
    azzert.that(5, is(vs[2]));
  }

  @Test public void all0() {
    azzert.that(new RealStatistics().all().length, is(0));
  }

  @Test public void all1() {
    azzert.that(new RealStatistics().record(0).all().length, is(1));
  }

  @Test public void all5() {
    azzert.that(new RealStatistics().record(0, 1, 2, 4, 5).all().length, is(5));
  }

  @Test public void max() {
    azzert.that(20, is(s11_20_5.max()));
    azzert.that(5, is(s15.max()));
    azzert.that(7, is(s07.max()));
    azzert.that(1, is(s_4x0_5x1.max()));
  }

  @Test public void mean() {
    azzert.that(12, is(s11_20_5.mean()));
    azzert.that(3, is(s15.mean()));
    azzert.that(3.5, is(s07.mean()));
    azzert.that(5 / 9.0, is(s_4x0_5x1.mean()));
  }

  @Test(expected = ArithmeticException.class) public void meanEmpty() {
    final @NotNull RealStatistics x = new RealStatistics();
    azzert.that(0, is(x.mean()));
    x.relativeError();
  }

  @Test public void meanZero() {
    final @NotNull RealStatistics x = new RealStatistics().record(1).record(-1);
    azzert.that(0, is(x.mean()));
    x.relativeError();
  }

  @Test public void median() {
    azzert.that(11, is(s11_20_5.median()));
    azzert.that(3, is(s15.median()));
    azzert.that(3.5, is(s07.median()));
    azzert.that(1, is(s_4x0_5x1.median()));
    azzert.that(1, is(s_4x0_5x1.record(1).median()));
    azzert.that(1, is(s_4x0_5x1.record(5).median()));
    azzert.that(1, is(s_4x0_5x1.record(5).record(6).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(0.5, is(s_4x0_5x1.record(0).median()));
    azzert.that(0, is(s_4x0_5x1.record(0).median()));
  }

  @Test(expected = ArithmeticException.class) public void medianEmpty() {
    new RealStatistics().median();
  }

  @Test public void medianMiddle() {
    azzert.that(0.5, is(s_4x0_5x1.record(0).median()));
  }

  @Test public void medianMovingDown() {
    azzert.that(0, is(s_4x0_5x1.record(0).record(0).median()));
  }

  @Test public void mediannMovingDown() {
    azzert.that(0, is(s_4x0_5x1.record(0).record(0).median()));
  }

  @Test public void medianNotMovingUp() {
    azzert.that(1, is(s_4x0_5x1.record(5).record(6).median()));
  }

  @Test public void min() {
    azzert.that(5, is(s11_20_5.min()));
    azzert.that(1, is(s15.min()));
    azzert.that(0, is(s07.min()));
    azzert.that(0, is(s_4x0_5x1.min()));
  }

  @Test public void n() {
    azzert.that(s11_20_5.n(), is(3));
    azzert.that(s15.n(), is(5));
    azzert.that(s07.n(), is(8));
    azzert.that(s_4x0_5x1.n(), is(9));
  }

  @Test public void simpleLength() {
    azzert.that(s.n(), is(3));
    azzert.that(s15.n(), is(5));
    azzert.that(s07.n(), is(8));
    azzert.that(s_4x0_5x1.n(), is(9));
  }

  @Test public void sum() {
    azzert.that(36, is(s11_20_5.sum()));
    azzert.that(15, is(s15.sum()));
    azzert.that(28, is(s07.sum()));
    azzert.that(5.0, is(s_4x0_5x1.sum()));
  }

  @Test public void testMax() {
    azzert.that(20, is(s.max()));
    azzert.that(5, is(s15.max()));
    azzert.that(7, is(s07.max()));
    azzert.that(1, is(s_4x0_5x1.max()));
  }

  @Test public void testMean() {
    azzert.that(12, is(s.mean()));
    azzert.that(3, is(s15.mean()));
    azzert.that(3.5, is(s07.mean()));
    azzert.that(5 / 9.0, is(s_4x0_5x1.mean()));
  }

  @Test public void testMedian() {
    azzert.that(11, is(s.median()));
    azzert.that(3, is(s15.median()));
    azzert.that(3.5, is(s07.median()));
    azzert.that(1, is(s_4x0_5x1.median()));
    azzert.that(1, is(s_4x0_5x1.record(1).median()));
    azzert.that(1, is(s_4x0_5x1.record(5).median()));
    azzert.that(1, is(s_4x0_5x1.record(5).record(6).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(1, is(s_4x0_5x1.record(0).median()));
    azzert.that(0.5, is(s_4x0_5x1.record(0).median()));
    azzert.that(0, is(s_4x0_5x1.record(0).median()));
  }

  @Test(expected = ArithmeticException.class) public void testMedianEmpty() {
    new RealStatistics().median();
  }

  @Test public void testMedianMiddle() {
    azzert.that(0.5, is(s_4x0_5x1.record(0).median()));
  }

  @Test public void testMedianNotMovingUp() {
    azzert.that(1, is(s_4x0_5x1.record(5).record(6).median()));
  }

  @Test public void testMin() {
    azzert.that(5, is(s.min()));
    azzert.that(1, is(s15.min()));
    azzert.that(0, is(s07.min()));
    azzert.that(0, is(s_4x0_5x1.min()));
  }

  @Test public void testSum() {
    azzert.that(36, is(s.sum()));
    azzert.that(15, is(s15.sum()));
    azzert.that(28, is(s07.sum()));
    azzert.that(5.0, is(s_4x0_5x1.sum()));
  }
}
