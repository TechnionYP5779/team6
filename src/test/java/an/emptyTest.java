package an;

import org.junit.Test;

import java.util.Iterator;


import static org.junit.Assert.*;

public class emptyTest {
  @Test @SuppressWarnings("static-method") public void emptyTestlist() {
    assertEquals(0, empty.list().size());
  }

  @Test @SuppressWarnings("static-method") public void emptyTestIterable() {
    Iterator<Object> iter = empty.iterable().iterator();
    assert !iter.hasNext();
    assertNull(iter.next());
  }
}
