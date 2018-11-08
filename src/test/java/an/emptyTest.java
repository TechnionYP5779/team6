package an;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class emptyTest {
  @Test public void emptyTestlist() {
    final List<Integer> list = empty.list();
    assertEquals(0, list.size());
  }

  @Test public void emptyTestIterable() {
    final Iterator<Object> iter = empty.iterable().iterator();
    assertFalse(iter.hasNext());
    assertNull(iter.next());
  }
}
