package il.org.spartan.statistics;

import org.junit.*;

public class StatisticsTest {
  @Test @SuppressWarnings("static-method") public void MedianTest() {
    final double b[] = { 1, 2, 3, 4, 5 }, c[] = { -1, -2, 3, 4 }, d[] = { -1, -2, -3, -4, -5 }, e[] = { 0, 0, 0, 0 }, f[] = { 4.6 };
    assert Statistics.median(new double[] { 1, 2, 3, 4 }) == 2.5;
    assert Statistics.median(b) == 3;
    assert Statistics.median(c) == 1;
    assert Statistics.median(d) == -3;
    assert Statistics.median(e) == 0;
    assert Statistics.median(f) == 4.6;
  }

  @Test @SuppressWarnings("static-method") public void MadTest() {
    final double b[] = { 1, 2, 3, 4, 5 }, c[] = { -1, -2, 3, 4 }, d[] = { -1, -2, -3, -4, -5 }, e[] = { 0, 0, 0, 0 }, f[] = { 4.6 };
    assert Statistics.mad(new double[] { 1, 2, 3, 4 }) == 1;
    assert Statistics.mad(b) == 1;
    assert Statistics.mad(c) == 2.5;
    assert Statistics.mad(d) == 1;
    assert Statistics.mad(e) == 0;
    assert Statistics.mad(f) == 0;
  }

  @Test @SuppressWarnings("static-method") public void SampleMeanTest() {
    final double b[] = { 1, 2, 3, 4, 5 }, c[] = { -1, -2, 3, 4 }, d[] = { -1, -2, -3, -4, -5 }, e[] = { 0, 0, 0, 0 }, f[] = { 4.6 };
    assert Statistics.sampleMean(new double[] { 1, 2, 3, 4 }) == 2.5;
    assert Statistics.sampleMean(b) == 3;
    assert Statistics.sampleMean(c) == 1;
    assert Statistics.sampleMean(d) == -3;
    assert Statistics.sampleMean(e) == 0;
    assert Statistics.sampleMean(f) == 4.6;
  }

  @Test @SuppressWarnings("static-method") public void SampleVarianceTest() {
    final double b[] = { -1, -1 }, c[] = { 1, 3 }, d[] = { 1, 2 };
    assert Statistics.sampleVariance(new double[] { 4.6, 4.6 }) == 0;
    assert Statistics.sampleVariance(b) == 0;
    assert Statistics.sampleVariance(c) == 2;
    assert Statistics.sampleVariance(d) == 0.5;
  }

  @Test @SuppressWarnings("static-method") public void ClassVareTest() {
    final Statistics s = new Statistics() {//
    };
    assert s.isEmpty();
    s.n = 1;
    assert !s.isEmpty();
    assert s.n() == 1;
    s.n = 2;
    s.moments[1] = 20;
    s.moments[2] = 30;
    assert s.sum() == 20;
    assert s.sum2() == 30;
    s.min = 1;
    s.max = 2;
    assert s.min() == 1;
    assert s.max() == 2;
    s.missing = 0;
    assert s.missing() == 0;
    assert s.mean() == 10;
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest1() {
    (new Statistics() {//
    }).checkEmpty();
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest2() {
    (new Statistics() {//
    }).max();
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest3() {
    (new Statistics() {//
    }).mean();
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest4() {
    (new Statistics() {//
    }).min();
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest5() {
    (new Statistics() {//
    }).sd();
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest6() {
    (new Statistics() {//
    }).relativeError();
  }

  @Test(expected = ArithmeticException.class) @SuppressWarnings("static-method") public void ClassVareEmptyTest7() {
    (new Statistics() {//
    }).variance();
  }
}
