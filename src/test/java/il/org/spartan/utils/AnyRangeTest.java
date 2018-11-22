package il.org.spartan.utils;
import static fluent.ly.azzert.*;
import static fluent.ly.forget.______unused;
import org.junit.*;
import static il.org.spartan.utils.AnyRange.*;

public class AnyRangeTest{

   public static class BoundedAboveRangeTest {
    @Test @SuppressWarnings("static-method") public void consTest1() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, 10);
      } catch (Throwable ¢) {
        ______unused(¢);
        return;
      }
      ______unused(range);
      assert false;
    }

    @Test @SuppressWarnings("static-method") public void consTest2() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        assertEquals(range.getTo(), 0);
        assertEquals(range.getStep(), -10);
      } catch (Throwable ¢) {
        ______unused(¢);
        assert false;
      }
    }

    @Test @SuppressWarnings("static-method") public void toTest() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range.to(5);
        assertEquals(range.getTo(), 5);
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings("static-method") public void fromTest1() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range.from(5);
      } catch (Throwable ¢) {
        ______unused(¢);
        return;
      }
      assert false;
    }

    @Test @SuppressWarnings("static-method") public void fromTest2() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range.from(-5);
      } catch (Throwable ¢) {
        ______unused(¢);
        assert false;
      }
    }

    @Test @SuppressWarnings("static-method") public void stepTest() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        try {
          range.step(3);
        } catch (Throwable ¢) {
          ______unused(¢);
          return;
        }
        assert false;
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings("static-method") public void hashCodeTest() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        assertEquals(range.hashCode(), -10);
        range = new AnyRange.BoundedAboveRange(3, -1);
        assertEquals(range.hashCode(), -2);
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings("static-method") public void mergeTest() {
      AnyRange.BoundedAboveRange range = null, range2 = null, merged_range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(3, -9);
        merged_range = range.merge(range2);
        assertEquals(merged_range.getTo(), 3);
        assertEquals(merged_range.getStep(), -10);
        range2 = new AnyRange.BoundedAboveRange(-3, -19);
        merged_range = range.merge(range2);
        assertEquals(merged_range.getTo(), 0);
        assertEquals(merged_range.getStep(), -19);
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings("static-method") public void IncludedInTest() {
      AnyRange.BoundedAboveRange range = null, range2 = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(3, -9);
        assert range.includedIn(range2);
        assert !range2.includedIn(range);
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings("static-method") public void overLappingTest() {
      AnyRange.BoundedAboveRange range = null, range2 = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        range2 = new AnyRange.BoundedAboveRange(3, -9);
        assert range.overlapping(range2);
        assert range2.overlapping(range);
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings({ "static-method", "unlikely-arg-type" }) public void euaqlsTest() {
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
      } catch (Throwable ¢) {
        ______unused(¢);
      }
    }

    @Test @SuppressWarnings("static-method") public void toStringTest() {
      AnyRange.BoundedAboveRange range = null;
      try {
        range = new AnyRange.BoundedAboveRange(0, -10);
        assertEquals(range + "", "[0, -10]");
      } catch (Throwable ¢) {
        ______unused(¢);
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
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
      
      ______unused(range);
      assert false;
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void consTest2() {
      AnyRange.BoundedBelowRange  range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange (0, 10);
        assertEquals(range.getFrom(),0);
        assertEquals(range.getStep(),10);
      }catch (Throwable ¢){
        ______unused(¢);
        assert false;
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
      }catch (Throwable ¢){
        ______unused(¢);
      }
     
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest1() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range.to(-5);
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
     assert false;
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest2() {
      AnyRange.BoundedBelowRange range = null;
      
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range.to(5);
      }catch (Throwable ¢){
        ______unused(¢);
        assert false;
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
        }catch (Throwable ¢){
          ______unused(¢);
          return;
        }
        assert false;
        
      }catch (Throwable ¢){
        ______unused(¢);
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
        
      }catch (Throwable ¢){
        ______unused(¢);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void mergeTest() {
      AnyRange.BoundedBelowRange range = null, range2 = null, merged_range = null;
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
        
      }catch (Throwable ¢){
        ______unused(¢);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void IncludedInTest() {
      AnyRange.BoundedBelowRange range = null, range2 = null;
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range2 = new AnyRange.BoundedBelowRange(3, 9);
        
        assert range2.includedIn(range);
        assert !range.includedIn(range2);
        
      }catch (Throwable ¢){
        ______unused(¢);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void overLappingTest() {
      AnyRange.BoundedBelowRange range = null, range2 = null;
      try {
        range = new AnyRange.BoundedBelowRange(0, 10);
        range2 = new AnyRange.BoundedBelowRange(3, 9);
        
        assert range.overlapping(range2);
        assert range2.overlapping(range);
        
      }catch (Throwable ¢){
        ______unused(¢);
      }
      
    }
    
    @Test
    @SuppressWarnings({ "static-method", "unlikely-arg-type" })
    public void euaqlsTest() {
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
      }catch (Throwable ¢){
        ______unused(¢);
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void toStringTest() {
      AnyRange.BoundedAboveRange range = null;

      try {
        range = new AnyRange.BoundedAboveRange(0, 10);
        assertEquals(range + "", "[0, 10]");
      }catch (Throwable ¢){
        ______unused(¢);
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
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
      
      ______unused(range);
      assert false;
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void consTest2() {
      AnyRange.FiniteRange range = null;
      
      
      try { // invalid step , should be negative
        range = new AnyRange.FiniteRange(0, 1,-1);
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
      
      ______unused(range);
      assert false;
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
      }catch (Throwable ¢){
        ______unused(¢);
        assert false;
      }
      
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest1() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        range.from(15);
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
     assert false;
    }
    
    @Test
    @SuppressWarnings("static-method")
    public void fromTest2() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        range.from(5);
        assertEquals(range.getFrom(),5);
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
      assert false;
    }
    
    
    @Test
    @SuppressWarnings("static-method")
    public void toTest() {
      AnyRange.FiniteRange range = null;
      
      try {
        range = new AnyRange.FiniteRange(0, 10,1);
        range.to(-5);
      }catch (Throwable ¢){
        ______unused(¢);
       return;
      }
      assert false;
    }
  
  
  @Test
  @SuppressWarnings("static-method")
  public void toTest1() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range.to(5);
      assertEquals(range.getTo(),5);
    }catch (Throwable ¢){
      ______unused(¢);
      return;
    }
  }
  
  @Test
  @SuppressWarnings({ "static-method", "unlikely-arg-type" })
  public void euaqlsTest() {
    AnyRange.FiniteRange range = null, range2 = null;
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range2 = new AnyRange.FiniteRange(0, 9,1);
      
      assert !range.equals(Integer.valueOf(1));
      
      assert !range.equals(range2);
      
      range2 = new AnyRange.FiniteRange(1, 10,1);
      assert !range.equals(range2);
      
      range2 = new AnyRange.FiniteRange(0, 10,2);
      assert !range.equals(range2);
      
      range2 = new AnyRange.FiniteRange(0, 10,1);
      assert range.equals(range2);
    }catch (Throwable ¢){
      ______unused(¢);
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
      }catch (Throwable ¢){
        ______unused(¢);
        return;
      }
      assert false;
      
    }catch (Throwable ¢){
      ______unused(¢);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void hashCodeTest() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      assertEquals(range.hashCode(),55);
      
    }catch (Throwable ¢){
      ______unused(¢);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void sizeTest() {
    AnyRange.FiniteRange range = null;
    
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      assertEquals(range.size(),10);
      
    }catch (Throwable ¢){
      ______unused(¢);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void mergeTest() {
    AnyRange.FiniteRange range = null, range2 = null, merged_range = null;
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
      
      
    }catch (Throwable ¢){
      ______unused(¢);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void IncludedInTest() {
    AnyRange.FiniteRange range = null, range2 = null;
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range2 = new AnyRange.FiniteRange(3, 9,1);
      
      assert range2.includedIn(range);
      assert !range.includedIn(range2);
      
    }catch (Throwable ¢){
      ______unused(¢);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void overLappingTest() {
    AnyRange.FiniteRange range = null, range2 = null;
    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      range2 = new AnyRange.FiniteRange(3, 9,1);
      
      assert range.overlapping(range2);
      assert range2.overlapping(range);
      
    }catch (Throwable ¢){
      ______unused(¢);
    }
    
  }
  
  @Test
  @SuppressWarnings("static-method")
  public void toStringTest() {
    AnyRange.FiniteRange range = null;

    try {
      range = new AnyRange.FiniteRange(0, 10,1);
      assertEquals(range + "", "[0, 10]");
    }catch (Throwable ¢){
      ______unused(¢);
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
     }catch (Throwable ¢){
       ______unused(¢);
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
     }catch (Throwable ¢){
       ______unused(¢);
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
     }catch (Throwable ¢){
       ______unused(¢);
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
     }catch (Throwable ¢){
       ______unused(¢);
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
     }catch (Throwable ¢){
       ______unused(¢);
     }
 }
 }
}
  


