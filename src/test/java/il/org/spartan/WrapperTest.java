package il.org.spartan;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("null")
public class WrapperTest {
  
  private Wrapper<Integer> nullWrap = new Wrapper<>();
  private Wrapper<Integer> oneWrap = new Wrapper<>(box.boxThis(1));
  private Wrapper<Integer> twoWrap = new Wrapper<>(box.boxThis(2));
  
  @Test public void testEquals() {
    assert nullWrap.equals(new Wrapper<>());
    assert !nullWrap.equals(oneWrap);
    assert oneWrap.equals(new Wrapper<>(box.boxThis(1)));
    assert !oneWrap.equals(twoWrap);
    assert !oneWrap.equals(nullWrap);
    assert !oneWrap.equals(new Wrapper<>(null));
    assert !oneWrap.equals(new Wrapper<>("hello"));
  }
  
  @Test public void testHash() {
    azzert.assertEquals(nullWrap.hashCode(), 0);
    azzert.assertEquals(oneWrap.hashCode(), 1);
    azzert.assertEquals(twoWrap.hashCode(), 2);
  }
  
  @Test public void testSet() {
    oneWrap.set(box.boxThis(5));
    azzert.assertEquals(oneWrap.get(), 5);
  }
  
  @Test public void testToString() {
    Assert.assertEquals(nullWrap + "", "null");
    Assert.assertEquals(oneWrap + "", "1");
  }
}
