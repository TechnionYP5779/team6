package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import static fluent.ly.forget.______unused;
public class AnyRange {
  public enum RangeType {BOUNDEDABOVERANGE,BOUNDEDBELOWRANGE,FINITE}
  int from;
  int to;
  int step;
  RangeType type;
  
  AnyRange (int from_,int to_,int step_,RangeType type_){
    from = from_;
    to = to_;
    step = step_;
    type = type_;
  }

  @SuppressWarnings("serial") 
  /** we use when we encounter problems like invalid arguments , etc */
  public static class AnyRangeException extends Exception{
    //
  }
  
  public class BoundedAboveRange{
    public FiniteRange from (int from_) throws  AnyRangeException{
      if (to<from)
        throw new AnyRangeException();
      from = from_;
      return new FiniteRange();
    }
    
    public void step(final int step_) throws  AnyRangeException{
      if(step_>0) throw new AnyRangeException();
      step = step_;
    }
    
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(to), fluent.ly.box.it(step));
    }
    
    @Override public int hashCode() {
      return (to + step) > 0 ? -(to + step) :  (to + step);
    }
    
    AnyRange asAnyRange () {
      return new AnyRange (-1,to,step,RangeType.BOUNDEDABOVERANGE);
    }
    
    @Override public boolean equals(final Object ¢) {
      if (¢ instanceof BoundedAboveRange) 
       return this.asAnyRange().equals( ((BoundedAboveRange)¢).asAnyRange() );
      
      return true;
    }
    
    @NotNull public BoundedAboveRange merge(final @NotNull BoundedAboveRange ¢) {
      AnyRange range = ¢.asAnyRange();
      int to_ = to > range.to ? to : range.to;
      int step_ = step < range.step ? step : range.step;
      return new AnyRange(-1,to_,step_,RangeType.BOUNDEDABOVERANGE).new BoundedAboveRange();
    }
    
    public boolean includedIn(final @NotNull BoundedAboveRange ¢) {
      return to <= ¢.asAnyRange().to ;
    }
    
    public boolean overlapping(final @NotNull BoundedAboveRange ¢) {
      ______unused(¢);
      return true;
    }
    
  }
  public class BoundedBelowRange{
    public FiniteRange to (int to_) throws  AnyRangeException{
      if (to_<from)
        throw new AnyRangeException();
      to = to_;
      return new FiniteRange();
    }
    
    public void step(final int step_) throws  AnyRangeException{
      if(step_<0) throw new AnyRangeException();
      step = step_;
    }
    
    @Override public String toString() {
      return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(step));
    }
    
    @Override public int hashCode() {
      return (step + to) < 0 ? -(step + to) :  (step + to);
    }
    
    AnyRange asAnyRange () {
      return new AnyRange (from,-1,step,RangeType.BOUNDEDBELOWRANGE);
    }
    
    @Override public boolean equals(final Object ¢) {
      if (¢ instanceof BoundedBelowRange) 
       return this.asAnyRange().equals( ((BoundedBelowRange)¢).asAnyRange() );
      
      return true;
    }
    
    @NotNull public BoundedBelowRange merge(final @NotNull BoundedBelowRange ¢) {
      AnyRange range = ¢.asAnyRange();
      int from_ = from < range.from ? from : range.from;
      int step_ = step < range.step ? step : range.step;
      return new AnyRange(from_,-1,step_,RangeType.BOUNDEDBELOWRANGE).new BoundedBelowRange();
    }
    
    public boolean includedIn(final @NotNull BoundedBelowRange ¢) {
      return from >=  ¢.asAnyRange().from ;
    }
    
    public boolean overlapping(final @NotNull BoundedBelowRange ¢) {
      ______unused(¢);
      return true;
    }
  }
  
  public class FiniteRange{
    AnyRange asAnyRange () {
      return new AnyRange (from,to,step,RangeType.FINITE);
    }
    
    @Override public boolean equals(final Object ¢) {
      if (¢ instanceof FiniteRange) 
       return this.asAnyRange().equals( ((FiniteRange)¢).asAnyRange() );
      
      return true;
    }

    @Override public int hashCode() {
      // Cantor pairing function
      return (int) (from + 0.5 * (to + from) * (to + from + 1));
    }

    public boolean includedIn(final @NotNull FiniteRange ¢) {
      AnyRange range = ¢.asAnyRange();
      return from >= range.from && to <= range.to;
    }

    @NotNull public FiniteRange merge(final @NotNull FiniteRange ¢) {
      AnyRange range = ¢.asAnyRange();
      int from_ = from < range.from ? from : range.from;
      int to_ = to > range.to ? to : range.to;
      int step_ = step < range.step ? step : range.step;
      return new AnyRange(from_,to_,step_,RangeType.FINITE).new FiniteRange();
    }

    public boolean overlapping(final @NotNull FiniteRange ¢) {
      AnyRange range = ¢.asAnyRange();
      return from >= range.from || to <= range.to;
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
  
  public BoundedBelowRange from(int from_) throws AnyRangeException{
    if(step < 0) throw new AnyRangeException();
    from = from_;
    step = 0;
    return new BoundedBelowRange();
  }
  
  public BoundedAboveRange to(int to_) throws AnyRangeException{
    if(step > 0) throw new AnyRangeException();
    to = to_;
    step = 0;
    return new BoundedAboveRange();
  }
  
  public BoundedBelowRange naturals () {
    from = 1;
    step = 1;
    return new BoundedBelowRange();
  }
  
  public BoundedAboveRange Negativeodds () {
    from = -1;
    step = -2;
    return new BoundedAboveRange();
  }
  
  public BoundedBelowRange Posistiveodds () {
    from = 1;
    step = 2;
    return new BoundedBelowRange();
  }
  
int getFrom () {return from;}
int getTo() {return to;}
int getStep() {return step;}

@Override public boolean equals(final Object o) {
  if ( ! (o instanceof AnyRange)) return false;
  
  AnyRange range = (AnyRange) o;
  if(type != range.type) return false;
    switch (type) {
      case BOUNDEDABOVERANGE: if(to != range.to || step != range.step) return false;
                              break;
      case BOUNDEDBELOWRANGE: if(from != range.from || step != range.step) return false;
                              break;
      case FINITE: if(from != range.from || to != range.to || step != range.step) return false;
                   break;
   }
  
    return true;
}

@Override public int hashCode() {
  return super.hashCode();
}
 
}
