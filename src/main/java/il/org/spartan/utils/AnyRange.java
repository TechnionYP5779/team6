package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import static fluent.ly.forget.______unused;
public class AnyRange {
  
  @SuppressWarnings("serial") 
  /** we use when we encounter problems like invalid arguments , etc */
  public static class AnyRangeException extends Exception{
    //
  }
  
  public static class BoundedAboveRange{
    int to;
    int step; 
    
    BoundedAboveRange(int to_, int step_) throws AnyRangeException{
      if(step_>0) throw new AnyRangeException();
      to = to_;
      step = step_;
    }
    
    public void to (int to_){
      to = to_; 
   }
   
   public int getTo () {return to;}
   public int getStep () {return step;}
   
   public void step(final int step_) throws  AnyRangeException{
     if(step_>0) throw new AnyRangeException();
     step = step_;
   }
   
    public FiniteRange from (int from) throws  AnyRangeException{
      if (to<from)
        throw new AnyRangeException();
      return new FiniteRange(from,to,-step);
    }
    
    
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(to), fluent.ly.box.it(step));
    }
    
    @Override public int hashCode() {
      return to + step <= 0 ? to + step : -(to + step);
    }
    
    
    @Override public boolean equals(final Object ¢) {
      return ¢ instanceof BoundedAboveRange && to == ((BoundedAboveRange) ¢).to && step == ((BoundedAboveRange) ¢).step;
    }
    
    //in fact it doesn't throws
    @NotNull public BoundedAboveRange merge(final @NotNull BoundedAboveRange ¢) throws AnyRangeException {
      return new BoundedAboveRange((to > ¢.to ? to : ¢.to), (step < ¢.step ? step : ¢.step));
    }
  
    public boolean includedIn(final @NotNull BoundedAboveRange ¢) {
      return to <= ¢.to ;
    }
    
    @SuppressWarnings("static-method")
    public  boolean  overlapping(final @NotNull BoundedAboveRange ¢) {
      ______unused(¢);
      return true;
    }
    
  }
  
  public static class BoundedBelowRange{
    int from;
    int step;
    
    BoundedBelowRange(int from_, int step_)throws AnyRangeException {
      if(step_<0) throw new  AnyRangeException();
      from = from_;
      step = step_;
    }
    
    public void from (int from_){
      from = from_;
    }
    
    public int getFrom () {return from;}
    public int getStep () {return step;}
    
   
    public FiniteRange to (int to_) throws  AnyRangeException{
      if (to_<from) throw new AnyRangeException();
      return new FiniteRange(from,to_,step);
    }
    
    public void step(final int step_) throws  AnyRangeException{
      if(step_<0) throw new AnyRangeException();
      step = step_;
    }
    
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(step));
    }
    
    @Override public int hashCode() {
      return from + step >= 0 ? from + step : -(from + step);
    }
    
    @Override public boolean equals(final Object ¢) {
      return ¢ instanceof BoundedBelowRange && from == ((BoundedBelowRange) ¢).from && step == ((BoundedBelowRange) ¢).step;
    }
    
    //in fact it doesn't throws
    @NotNull public BoundedBelowRange merge(final @NotNull BoundedBelowRange ¢) throws AnyRangeException {
      return new BoundedBelowRange((from < ¢.from ? from : ¢.from), (step < ¢.step ? step : ¢.step));
    }
    
    public boolean includedIn(final @NotNull BoundedBelowRange ¢) {
      return from >=  ¢.from ;
    }
    
    @SuppressWarnings("static-method")
    public boolean overlapping(final @NotNull BoundedBelowRange ¢) {
      ______unused(¢);
      return true;
    }
  }
  
  public static class FiniteRange {
    int from;
    int to;
    int step; 
    
    FiniteRange(int from_,int to_,int step_) throws AnyRangeException{
      if(from_> to_ || step_< 0) throw new AnyRangeException ();
      from = from_;
      to = to_;
      step = step_;
    }
    
    public FiniteRange from (int from_) throws  AnyRangeException{
      if (to<from_)
        throw new AnyRangeException();
      return new FiniteRange(from_,to,-step);
    }
    
    public FiniteRange to (int to_) throws  AnyRangeException{
      if (to_<from) throw new AnyRangeException();
      return new FiniteRange(from,to_,step);
    }
    
    public int getFrom () {return from;}
    public int getStep () {return step;}
    public int getTo () {return to;} 
    
    @Override public boolean equals(final Object ¢) {
      return ¢ instanceof FiniteRange && from == ((FiniteRange) ¢).from && to == ((FiniteRange) ¢).to && step == ((FiniteRange) ¢).step;
    }

    @Override public int hashCode() {
      // Cantor pairing function
      return (int) (from + 0.5 * (to + from) * (to + from + 1));
    }

    public boolean includedIn(final @NotNull FiniteRange ¢) {
      return from >= ¢.from && to <= ¢.to;
    }
    
    //in fact it doesn't throws
    @NotNull public FiniteRange merge(final @NotNull FiniteRange ¢) throws AnyRangeException{
      return new FiniteRange((from < ¢.from ? from : ¢.from), (to > ¢.to ? to : ¢.to), (step < ¢.step ? step : ¢.step));
    }

    public boolean overlapping(final @NotNull FiniteRange ¢) {
      return from >= ¢.from || to <= ¢.to;
    }

    public int size() {
      return to - from;
    }

    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(to));
    }
    
    public void step(final int step_) throws AnyRangeException{
      if(step < 0) throw new AnyRangeException();
      step = step_;
    }
  }
  
  public static BoundedBelowRange from(int from) throws AnyRangeException{
    return new BoundedBelowRange(from,0);
  }
  
  public static BoundedAboveRange to(int to) throws AnyRangeException{
     return new BoundedAboveRange(to,0);
  }
  
  public static BoundedBelowRange naturals () throws AnyRangeException{
    return new BoundedBelowRange(1,1);
  }
  
  public static BoundedAboveRange Negativeodds () throws AnyRangeException{
    return new BoundedAboveRange(-1,-2);
  }
  
  public static BoundedBelowRange Positiveodds ()  throws AnyRangeException{
    return new BoundedBelowRange(1,2);
  }

}
