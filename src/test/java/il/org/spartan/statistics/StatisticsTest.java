package il.org.spartan.statistics;

import static org.junit.Assert.*;


import org.junit.*;

import il.org.spartan.statistics.*;

public class StatisticsTest {
  @SuppressWarnings("static-method") @Test public void MedianTest() {
    double a[] = {1,2,3,4};
    double b[] = {1,2,3,4,5};
    double c[] = {-1,-2,3,4};
    double d[] = {-1,-2,-3,-4,-5};
    double e[] = {0,0,0,0};
    double f[] = {4.6};
    assertTrue(Statistics.median(a) == 2.5);
    assertTrue(Statistics.median(b) == 3);
    assertTrue(Statistics.median(c) == 1);
    assertTrue(Statistics.median(d) == -3);
    assertTrue(Statistics.median(e) == 0);
    assertTrue(Statistics.median(f) == 4.6);
  }
  
  @SuppressWarnings("static-method") @Test public void MadTest() {
    double a[] = {1,2,3,4};
    double b[] = {1,2,3,4,5};
    double c[] = {-1,-2,3,4};
    double d[] = {-1,-2,-3,-4,-5};
    double e[] = {0,0,0,0};
    double f[] = {4.6};
    assertTrue(Statistics.mad(a) == 1);
    assertTrue(Statistics.mad(b) == 1);
    assertTrue(Statistics.mad(c) == 2.5);
    assertTrue(Statistics.mad(d) == 1);
    assertTrue(Statistics.mad(e) == 0);
    assertTrue(Statistics.mad(f) == 0);
  }
  
  /*
  @SuppressWarnings("static-method") @Test public void PruneTest() {
    double a[] = {1,2,3,4};
    double b[] = Statistics.prune(a);
  }
  */
  /*
  @SuppressWarnings("static-method") @Test public void MeanTest() {
    double a[] = {1,2,3,4};
    double b[] = {1,2,3,4,5};
    double c[] = {-1,-2,3,4};
    double d[] = {-1,-2,-3,-4,-5};
    double e[] = {0,0,0,0};
    double f[] = {4.6};
   
  }
  */
}
