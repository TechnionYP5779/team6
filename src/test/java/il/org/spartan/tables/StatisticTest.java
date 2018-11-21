package il.org.spartan.tables;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.statistics.*;

public class StatisticTest {
  private final double[] d = { 1, 2, 3, 4 };
  RealStatistics r = new RealStatistics().record(2).record(4).record(6).record(8);

  @Test public void testQuartile() {
    azzert.that(Statistic.quartile(1, d), is(1.0));
    azzert.that(Statistic.quartile(28, d), is(2.0));
  }

  @Test public void testN() {
    azzert.that(Statistic.valueOf("N").of(r), is(4.0));
  }

  @Test public void testNA() {
    final Statistic na = Statistic.valueOf("NA");
    azzert.that(na + "", is("N/A"));
    azzert.that(na.of(r), is(0.0));
  }

  @Test public void testMean() {
    azzert.that(Statistic.valueOf("mean").of(r), is(5.0));
  }

  @Test public void testSD() {
    azzert.that(Statistic.valueOf("σ").of(r), is(Math.sqrt((Math.pow(1, 2) + Math.pow(1, 2) + Math.pow(3, 2) + Math.pow(3, 2)) / 4.0)));
  }

  @Test public void testMedian() {
    azzert.that(Statistic.valueOf("median").of(r), is(5.0));
  }

  @Test public void testMAD() {
    final Statistic mad = Statistic.valueOf("MAD");
    azzert.that(mad + "", is("M.A.D"));
    azzert.that(mad.of(r), is(2.0));
  }

  @Test public void testMin() {
    azzert.that(Statistic.valueOf("min").of(r), is(2.0));
  }

  @Test public void testMax() {
    azzert.that(Statistic.valueOf("max").of(r), is(8.0));
  }

  @Test public void testRange() {
    azzert.that(Statistic.valueOf("range").of(r), is(6.0));
  }

  
  @Test public void testQ1() {
    azzert.that(Statistic.valueOf("Q1").of(r), is(4.0));
  }

  @Test public void testSum() {
    azzert.that(Statistic.valueOf("Σ").of(r), is(20.0));
  }
  
  @Test public void testQ3() {
    azzert.that(Statistic.valueOf("Q3").of(r), is(8.0));
  }
}
