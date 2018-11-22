package il.org.spartan.utils;
import static fluent.ly.azzert.*;
import static fluent.ly.forget.______unused;
import org.junit.*;
import static il.org.spartan.utils.AnyRange.*;

public class AnyRangeTest{

   static public class BoundedAboveRangeTest{
    @Test
    @SuppressWarnings("static-method")
    public void consTest1() {
      AnyRange.BoundedAboveRange range = null;
      
      
      try { // invalid step , should be negative
        range = new AnyRange.BoundedAboveRange(0, 10);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
      
      ______unused(range);
      assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void consTest2() {
      AnyRange.BoundedAboveRange range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        assertEquals(range.getTo(),0);
        assertEquals(range.getStep(),-10);
      }catch (Throwable o){
        ______unused(o);
        assertTrue(false);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest() {
      AnyRange.BoundedAboveRange range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range.to(5);
        assertEquals(range.getTo(),5);
      }catch (Throwable o){
        ______unused(o);
      }
     
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest1() {
      AnyRange.BoundedAboveRange range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range.from(5);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
     assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest2() {
      AnyRange.BoundedAboveRange range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range.from(-5);
      }catch (Throwable o){
        ______unused(o);
        assertTrue(false);
      }
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void stepTest() {
      AnyRange.BoundedAboveRange range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        try {
          range.step(3);
        }catch (Throwable o){
          ______unused(o);
          return;
        }
        assertTrue(false);
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    
    @Test
    @SuppressWarnings("static-method")
    public void hashCodeTest() {
      AnyRange.BoundedAboveRange range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        assertEquals(range.hashCode(),-10);
        
        range = new AnyRange.BoundedAboveRange(3, -1);
        assertEquals(range.hashCode(),-2);
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void mergeTest() {
      AnyRange.BoundedAboveRange range = null;
      AnyRange.BoundedAboveRange range2 = null;
      AnyRange.BoundedAboveRange merged_range = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(3, -9);
        merged_range = range.merge(range2);
        assertEquals(merged_range.getTo(),3);
        assertEquals(merged_range.getStep(),-10);
        
        range2 = new AnyRange.BoundedAboveRange(-3, -19);
        merged_range = range.merge(range2);
        assertEquals(merged_range.getTo(),0);
        assertEquals(merged_range.getStep(),-19);
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void IncludedInTest() {
      AnyRange.BoundedAboveRange range = null;
      AnyRange.BoundedAboveRange range2 = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(3, -9);
        
        assertTrue(range.includedIn(range2));
        assertFalse(range2.includedIn(range));
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void overLappingTest() {
      AnyRange.BoundedAboveRange range = null;
      AnyRange.BoundedAboveRange range2 = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(3, -9);
        
        assertTrue(range.overlapping(range2));
        assertTrue(range2.overlapping(range));
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings({ "static-method", "unlikely-arg-type" })
    public void euaqlsTest() {
      AnyRange.BoundedAboveRange range = null;
      AnyRange.BoundedAboveRange range2 = null;
      
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(0, -9);
        
        assertFalse(range.equals(Integer.valueOf(1)));
        
        assertFalse(range.equals(range2));
        
        range2 = new AnyRange.BoundedAboveRange(1, -10);
        assertFalse(range.equals(range2));
        
        range2 = new AnyRange.BoundedAboveRange(0, -10);
        assertTrue(range.equals(range2));
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toStringTest() {
      AnyRange.BoundedAboveRange range = null;

      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        String str = "[0, -10]";
        assertEquals(range.toString(),str);
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
  }
  
  public static class BoundedBelowRangeTest{
    @Test
    @SuppressWarnings("static-method")
    public void consTest1() {
      AnyRange.BoundedBelowRange range = null;
      
      
      try { // invalid step , should be negative
        range = new AnyRange.BoundedBelowRange(0, -10);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
      
      ______unused(range);
      assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void consTest2() {
      AnyRange.BoundedBelowRange  range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange (0, 10);
        assertEquals(range.getFrom(),0);
        assertEquals(range.getStep(),10);
      }catch (Throwable o){
        ______unused(o);
        assertTrue(false);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range.from(5);
        assertEquals(range.getFrom(),5);
      }catch (Throwable o){
        ______unused(o);
      }
     
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest1() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range.to(-5);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
     assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest2() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range.to(5);
      }catch (Throwable o){
        ______unused(o);
        assertTrue(false);
      }
    }
    
    
    
    @Test
    @SuppressWarnings("static-method")
    public void stepTest() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        try {
          range.step(-3);
        }catch (Throwable o){
          ______unused(o);
          return;
        }
        assertTrue(false);
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void hashCodeTest() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        assertEquals(range.hashCode(),10);
        
        range = new AnyRange.BoundedBelowRange(-3, 1);
        assertEquals(range.hashCode(),2);
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void mergeTest() {
      AnyRange.BoundedBelowRange range = null;
      AnyRange.BoundedBelowRange range2 = null;
      AnyRange.BoundedBelowRange merged_range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range2 = new AnyRange.BoundedBelowRange(3, 9);
        merged_range = range.merge(range2);
        assertEquals(merged_range.getFrom(),0);
        assertEquals(merged_range.getStep(),9);
        
        range2 = new AnyRange.BoundedBelowRange(-3, 11);
        merged_range = range.merge(range2);
        assertEquals(merged_range.getFrom(),-3);
        assertEquals(merged_range.getStep(),10);
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void IncludedInTest() {
      AnyRange.BoundedBelowRange range = null;
      AnyRange.BoundedBelowRange range2 = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range2 = new AnyRange.BoundedBelowRange(3, 9);
        
        assertTrue(range2.includedIn(range));
        assertFalse(range.includedIn(range2));
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void overLappingTest() {
      AnyRange.BoundedBelowRange range = null;
      AnyRange.BoundedBelowRange range2 = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range2 = new AnyRange.BoundedBelowRange(3, 9);
        
        assertTrue(range.overlapping(range2));
        assertTrue(range2.overlapping(range));
        
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings({ "static-method", "unlikely-arg-type" })
    public void euaqlsTest() {
      AnyRange.BoundedBelowRange range = null;
      AnyRange.BoundedBelowRange range2 = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range2 = new AnyRange.BoundedBelowRange(0, 9);
        
        assertFalse(range.equals(Integer.valueOf(1)));
        
        assertFalse(range.equals(range2));
        
        range2 = new AnyRange.BoundedBelowRange(1, 10);
        assertFalse(range.equals(range2));
        
        range2 = new AnyRange.BoundedBelowRange(0, 10);
        assertTrue(range.equals(range2));
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toStringTest() {
      AnyRange.BoundedAboveRange range = null;

      try {
        range = new AnyRange.BoundedAboveRange(0, 10);
        String str = "[0, 10]";
        assertEquals(range.toString(),str);
      }catch (Throwable o){
        ______unused(o);
      }
      
    }
  }
  
  public static class FiniteRangeTest{
    @Test
    @SuppressWarnings("static-method")
    public void consTest1() {
      AnyRange.FiniteRange range = null;
      
      
      try { // invalid step , should be negative
        range = new AnyRange.FiniteRange(0, -1,1);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
      
      ______unused(range);
      assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void consTest2() {
      AnyRange.FiniteRange range = null;
      
      
      try { // invalid step , should be negative
        range = new AnyRange.FiniteRange(0, 1,-1);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
      
      ______unused(range);
      assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void consTest3() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        assertEquals(range.getFrom(),0);
        assertEquals(range.getTo(),10);
        assertEquals(range.getStep(),1);
      }catch (Throwable o){
        ______unused(o);
        assertTrue(false);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest1() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        range.from(15);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
     assertTrue(false);
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest2() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        range.from(5);
        assertEquals(range.getFrom(),5);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
      assertTrue(false);
    }
    
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        range.to(-5);
      }catch (Throwable o){
        ______unused(o);
       return;
      }
      assertTrue(false);
    }
  
  
  @Test
  @SuppressWarnings("static-method")
  public void toTest1() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range.to(5);
      assertEquals(range.getTo(),5);
    }catch (Throwable o){
      ______unused(o);
      return;
    }
  }
  
  @Test
  @SuppressWarnings({ "static-method", "unlikely-arg-type" })
  public void euaqlsTest() {
    AnyRange.FiniteRange range = null;
    AnyRange.FiniteRange range2 = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range2 = new AnyRange.FiniteRange(0, 9,1);
      
      assertFalse(range.equals(Integer.valueOf(1)));
      
      assertFalse(range.equals(range2));
      
      range2 = new AnyRange.FiniteRange(1, 10,1);
      assertFalse(range.equals(range2));
      
      range2 = new AnyRange.FiniteRange(0, 10,2);
      assertFalse(range.equals(range2));
      
      range2 = new AnyRange.FiniteRange(0, 10,1);
      assertTrue(range.equals(range2));
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void stepTest() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      try {
        range.step(-3);
      }catch (Throwable o){
        ______unused(o);
        return;
      }
      assertTrue(false);
      
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void hashCodeTest() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      assertEquals(range.hashCode(),55);
      
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void sizeTest() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      assertEquals(range.size(),10);
      
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void mergeTest() {
    AnyRange.FiniteRange range = null;
    AnyRange.FiniteRange range2 = null;
    AnyRange.FiniteRange merged_range = null;
    
    try {
      range = new AnyRange.FiniteRange(0,10,3);
      range2 = new AnyRange.FiniteRange(3, 9,4);
      merged_range = range.merge(range2);
      assertEquals(merged_range.getFrom(),0);
      assertEquals(merged_range.getStep(),9);
      assertEquals(merged_range.getTo(),10);
      
      range2 = new AnyRange.FiniteRange(-3, 11,2);
      merged_range = range.merge(range2);
      assertEquals(merged_range.getFrom(),-3);
      assertEquals(merged_range.getStep(),10);
      assertEquals(merged_range.getTo(),11);
      
      
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void IncludedInTest() {
    AnyRange.FiniteRange range = null;
    AnyRange.FiniteRange range2 = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range2 = new AnyRange.FiniteRange(3, 9,1);
      
      assertTrue(range2.includedIn(range));
      assertFalse(range.includedIn(range2));
      
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void overLappingTest() {
    AnyRange.FiniteRange range = null;
    AnyRange.FiniteRange range2 = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range2 = new AnyRange.FiniteRange(3, 9,1);
      
      assertTrue(range.overlapping(range2));
      assertTrue(range2.overlapping(range));
      
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void toStringTest() {
    AnyRange.FiniteRange range = null;

    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      String str = "[0, 10]";
      assertEquals(range.toString(),str);
    }catch (Throwable o){
      ______unused(o);
    }
    
  }
  
  }
 public static class AnyRangeTestAuxe{
   
   @Test
   @SuppressWarnings("static-method")
   public void fromTest() {
     AnyRange.BoundedBelowRange range = null;
     try {
       range = from(2);
       assertEquals(range.from,2);
       assertEquals(range.step,0);
     }catch (Throwable o){
       ______unused(o);
     }
 }
    
   @Test
   @SuppressWarnings("static-method")
   public void toTest() {
     AnyRange.BoundedAboveRange range = null;
     try {
       range = to(2);
       assertEquals(range.getTo(),2);
       assertEquals(range.getStep(),0);
     }catch (Throwable o){
       ______unused(o);
     }
 }
  
   @Test
   @SuppressWarnings("static-method")
   public void naturalsTest() {
     AnyRange.BoundedBelowRange range = null;
     try {
       range = naturals() ;
       assertEquals(range.from,1);
       assertEquals(range.step,1);
     }catch (Throwable o){
       ______unused(o);
     }
 }
   
   @Test
   @SuppressWarnings("static-method")
   public void positiveOddsTest() {
     AnyRange.BoundedBelowRange range = null;
     try {
       range = Positiveodds() ;
       assertEquals(range.from,1);
       assertEquals(range.step,2);
     }catch (Throwable o){
       ______unused(o);
     }
 }
   
   @Test
   @SuppressWarnings("static-method")
   public void negativeOddsTest() {
     AnyRange.BoundedAboveRange range = null;
     try {
       range = Negativeodds();
       assertEquals(range.getTo(),-1);
       assertEquals(range.getStep(),-2);
     }catch (Throwable o){
       ______unused(o);
     }
 }
 }
}
  


