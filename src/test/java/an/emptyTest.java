package an;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test  public void emptyTestlist() {
    azzert.that(0, is(empty.list().size()));
  }

  @Test public void emptyTestIterable() {
    final Iterator<Object> iter = empty.iterable().iterator();
    assert !iter.hasNext();
    assertNull(iter.next());
  }
}
