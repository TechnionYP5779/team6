package an;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

public class emptyTest {
  @Test @SuppressWarnings("static-method") public void emptyTestlist() {
    assertEquals(0, empty.list().size());
  }

  @Test @SuppressWarnings("static-method") public void emptyTestIterable() {
    final Iterator<Object> iter = empty.iterable().iterator();
    assert !iter.hasNext();
    assertNull(iter.next());
  }
}
