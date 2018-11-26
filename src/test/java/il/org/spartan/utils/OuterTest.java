package il.org.spartan.utils;


import org.junit.*;


import fluent.ly.*;

@SuppressWarnings({"static-method","null"}) public class OuterTest {
 
  @Test(expected = IllegalArgumentException.class) public void consExceTest() {
    (new Outer<>(null)).inner = box.boxThis(5);
   }
  
  @Test public void equalsTest() {
    Outer<Integer> iout1a = new Outer<>(box.boxThis(1));
    assert iout1a.equals((Object)iout1a);
    assert !iout1a.equals((Object)box.boxThis(1));
    assert !iout1a.equals(new Outer<>(box.boxThis(1.0)));
    assert !iout1a.equals(new Outer<>(box.boxThis(6.0)));
    assert !iout1a.equals(new Outer<>(box.boxThis(2)));
    assert iout1a.equals(new Outer<>(box.boxThis(1)));
    Outer<Integer> ioutna = new Outer<>(box.boxThis(4));
    ioutna.inner=null;
    Outer<Integer> ioutnb = new Outer<>(box.boxThis(5));
    assert !ioutna.equals(ioutnb);
    ioutnb.inner=null;
    assert ioutna.equals(ioutnb);
   }
  @Test public void cloneTest() throws CloneNotSupportedException {
    (new Outer<>(box.boxThis(1))).clone();
  }
  @Test public void getTest() {
    azzert.that((new Outer<>(box.boxThis(1))).get(), azzert.is(1));
  }
  
  @Test public void hashTest() {
    assert (new Outer<>(box.boxThis(1))).hashCode() != (new Outer<>(box.boxThis(2))).hashCode();
  }
  
  @Test(expected = IllegalArgumentException.class) public  void setTest() {
    Outer<Integer> iout1 = new Outer<>(box.boxThis(1));
    iout1.set(box.boxThis(2));
    azzert.that(iout1.inner, azzert.is(2));
    iout1.set(null);
  }
  
  @Test public void stringTest(){
    azzert.that(new Outer<>(box.boxThis(1)) + "", azzert.is("1"));
  }
  
  @Test public void wrappterTest() {
    Outer.Wrapper<Integer> wr = new Outer.Wrapper<>();
    azzert.isNull(wr.inner);
    azzert.isNull(wr.inner);
    azzert.that(wr + "", azzert.is("null"));
    azzert.that(wr.hashCode(), azzert.is(0));
    azzert.isNull(wr.get());
    assert wr.equals(new Outer.Wrapper<>());
    Outer.Wrapper<Integer> wr2 = new Outer.Wrapper<>(box.boxThis(2));
    assert !wr.equals(wr2);
    wr.set(box.boxThis(1));
    azzert.that(wr + "", azzert.is("1"));
    azzert.that(wr.hashCode(), azzert.is(box.boxThis(1).hashCode()));
    Outer.Wrapper<Integer> wr1 = new Outer.Wrapper<>(box.boxThis(1));
    assert wr1.equals(wr);
    assert !wr1.equals(new Outer.Wrapper<>());
    assert !wr1.equals(wr2);
  }
  @Test(expected = CloneNotSupportedException.class) public void wrpCloneTest() throws CloneNotSupportedException {
    azzert.that(new Outer.Wrapper<>(box.boxThis(5)).clone().inner,azzert.is(box.boxThis(5)));
    azzert.isNull(new Outer.Wrapper<Integer>().clone().inner);
  }
}
