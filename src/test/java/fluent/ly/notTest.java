package fluent.ly;

import org.junit.*;

/** For tested interface please see {@link fluent.ly.not} . */
@SuppressWarnings("static-method") public class notTest {
  @Test public void in() {
    final Integer[] intArray = new Integer[2];
    intArray[0] = intArray[1] = box.it(3);
    assert not.in(box.it(2), intArray);
    assert !not.in(box.it(3), intArray);
  }

  @Test public void nil() {
    assert !not.nil(null);
    Integer[] intArray = new Integer[2];
    intArray[0] = intArray[1] = box.it(3);
    assert not.nil(intArray);
    intArray = null;
    assert !not.nil(intArray);
  }
}
