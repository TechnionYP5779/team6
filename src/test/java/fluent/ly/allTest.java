package fluent.ly;

import java.util.*;

import org.junit.*;

/** For tested enum please see {@link fluent.ly.all} . */
@SuppressWarnings("static-method") public class allTest {
  @Test public void notNullIterable() {
    assert !all.notNull((Iterable<Integer>) null);
    final List<Integer> intlist = new ArrayList<>();
    assert all.notNull(intlist);
    intlist.add(null);
    assert !all.notNull(intlist);
    intlist.add(box.it(3));
    assert !all.notNull(intlist);
    intlist.set(0, box.it(0));
    assert all.notNull(intlist);
  }

  @Test @SuppressWarnings("null") public void notNullArray() {
    assert !all.notNull((Integer[]) null);
    final Integer[] intArray = new Integer[3];
    assert !all.notNull(intArray);
    intArray[0] = intArray[1] = box.it(3);
    assert !all.notNull(intArray);
    intArray[2] = box.it(3);
    assert all.notNull(intArray);
  }
}
