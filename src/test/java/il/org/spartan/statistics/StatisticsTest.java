package il.org.spartan.statistics;

import static org.junit.Assert.*;

import org.junit.*;

public class StatisticsTest {
  @SuppressWarnings("static-method") @Test public void MedianTest() {
    final double a[] = { 1, 2, 3, 4 };
    final double b[] = { 1, 2, 3, 4, 5 };
    final double c[] = { -1, -2, 3, 4 };
    final double d[] = { -1, -2, -3, -4, -5 };
    final double e[] = { 0, 0, 0, 0 };
    final double f[] = { 4.6 };
    assertTrue(Statistics.median(a) == 2.5);
    assertTrue(Statistics.median(b) == 3);
    assertTrue(Statistics.median(c) == 1);
    assertTrue(Statistics.median(d) == -3);
    assertTrue(Statistics.median(e) == 0);
    assertTrue(Statistics.median(f) == 4.6);
  }

  @SuppressWarnings("static-method") @Test public void MadTest() {
    final double a[] = { 1, 2, 3, 4 };
    final double b[] = { 1, 2, 3, 4, 5 };
    final double c[] = { -1, -2, 3, 4 };
    final double d[] = { -1, -2, -3, -4, -5 };
    final double e[] = { 0, 0, 0, 0 };
    final double f[] = { 4.6 };
    assertTrue(Statistics.mad(a) == 1);
    assertTrue(Statistics.mad(b) == 1);
    assertTrue(Statistics.mad(c) == 2.5);
    assertTrue(Statistics.mad(d) == 1);
    assertTrue(Statistics.mad(e) == 0);
    assertTrue(Statistics.mad(f) == 0);
  }

  @SuppressWarnings("static-method") @Test public void SampleMeanTest() {
    final double a[] = { 1, 2, 3, 4 };
    final double b[] = { 1, 2, 3, 4, 5 };
    final double c[] = { -1, -2, 3, 4 };
    final double d[] = { -1, -2, -3, -4, -5 };
    final double e[] = { 0, 0, 0, 0 };
    final double f[] = { 4.6 };
    assertTrue(Statistics.sampleMean(a) == 2.5);
    assertTrue(Statistics.sampleMean(b) == 3);
    assertTrue(Statistics.sampleMean(c) == 1);
    assertTrue(Statistics.sampleMean(d) == -3);
    assertTrue(Statistics.sampleMean(e) == 0);
    assertTrue(Statistics.sampleMean(f) == 4.6);
  }

  @SuppressWarnings("static-method") @Test public void SampleVarianceTest() {
    // double is too inacurate to check any other values
    final double a[] = { 4.6, 4.6 };
    final double b[] = { -1, -1 };
    final double c[] = { 1, 3 };
    final double d[] = { 1, 2 };
    assertTrue(Statistics.sampleVariance(a) == 0);
    assertTrue(Statistics.sampleVariance(b) == 0);
    assertTrue(Statistics.sampleVariance(c) == 2);
    assertTrue(Statistics.sampleVariance(d) == 0.5);
  }

  // test anything that's not a nightmare because of double
  @SuppressWarnings("static-method") @Test public void ClassVareTest() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    assertTrue(s.isEmpty());
    s.n = 1;
    assertFalse(s.isEmpty());
    assertTrue(s.n() == 1);
    s.n = 2;
    s.moments[1] = 20;
    s.moments[2] = 30;
    assertTrue(s.sum() == 20);
    assertTrue(s.sum2() == 30);
    s.min = 1;
    s.max = 2;
    assertTrue(s.min() == 1);
    assertTrue(s.max() == 2);
    s.missing = 0;
    assertTrue(s.missing() == 0);
    assertTrue(s.mean() == 10);
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest1() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.checkEmpty();
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest2() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.max();
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest3() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.mean();
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest4() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.min();
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest5() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.sd();
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest6() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.relativeError();
  }

  @SuppressWarnings("static-method") @Test(expected = ArithmeticException.class) public void ClassVareEmptyTest7() {
    final Statistics s = new Statistics() {
      /* eclipse wanted a comment */};
    s.variance();
  }
}
