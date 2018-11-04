package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class RangeTest {
  @SuppressWarnings("static-method") @Test public void RangeEqualTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(1,4);
    Range r3 = new Range(2,4);
    Range r4 = new Range(1,5);
    assertTrue(r1.equals(r2));
    assertFalse(r1.equals(r3));
    assertFalse(r1.equals(r4));
    assertFalse(r3.equals(r4));
  }
  
  @SuppressWarnings("static-method") @Test public void RangeIncludenInTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(1,4);
    Range r3 = new Range(0,4);
    Range r4 = new Range(1,5);
    Range r5 = new Range(2,4);
    Range r6 = new Range(1,3);
    assertTrue(r1.includedIn(r2));
    assertFalse(r3.includedIn(r1));
    assertFalse(r4.includedIn(r1));
    assertTrue(r5.includedIn(r1));
    assertTrue(r6.includedIn(r1));
  }
  
  @SuppressWarnings("static-method") @Test public void HashCodeTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(1,4);
    Range r3 = new Range(2,4);
    Range r4 = new Range(1,5);
    assertTrue(r1.hashCode()==r2.hashCode());
    assertFalse(r1.hashCode()==r3.hashCode());
    assertFalse(r1.hashCode()==r4.hashCode());
    assertFalse(r3.hashCode()==r4.hashCode());
  }
  
  @SuppressWarnings("static-method") @Test public void SizeAndEmptyTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(4,1);
    Range r3 = new Range(1,1);
    assertTrue(r1.size()==3);
    assertTrue(r2.size()==-3);
    assertTrue(r3.size()==0);
    assertFalse(r1.isEmpty());
    assertTrue(r2.isEmpty());
    assertTrue(r3.isEmpty());
  }
  
  @SuppressWarnings("static-method") @Test public void FindIncludedInTest() {
    Range r1 = new Range(1,4);
    Range r2 = new Range(1,4);
    Range r3 = new Range(2,4);
    Range r4 = new Range(1,3);
    Range r5 = new Range(0,4);
    Range r6 = new Range(1,5);
    assertTrue(r1.findIncludedIn(null)==null);
    ArrayList<Range> notIncluded = new ArrayList<>();
    ArrayList<Range> included = new ArrayList<>();
    notIncluded.add(r3);
    notIncluded.add(r4);
    assertTrue(r1.findIncludedIn(notIncluded)==null);
    included.add(r2);
    included.add(r5);
    included.add(r6);
    assertTrue(r2.equals(r1.findIncludedIn(included)));
    assertTrue(included.remove(r2));
    assertTrue(r5.equals(r1.findIncludedIn(included)));
    assertTrue(included.remove(r5));
    assertTrue(r6.equals(r1.findIncludedIn(included)));
    assertTrue(included.remove(r6));
    assertTrue(r1.findIncludedIn(included)==null);
  }
  
  @SuppressWarnings("static-method") @Test public void OverlappingTest() {
    Range r1 = new Range(1,100);
    Range r2 = new Range(1,100);
    Range r3 = new Range(0,101);
    Range r4 = new Range(0,99);
    Range r5 = new Range(2,101);
    Range r6 = new Range(2,99); //no
    assertTrue(r1.overlapping(r2));
    assertTrue(r1.overlapping(r3));
    assertTrue(r1.overlapping(r4));
    assertTrue(r1.overlapping(r5));
    assertFalse(r1.overlapping(r6));

  }
}
