package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

/** For tested interface please see {@link fluent.ly.singleton} . */
@SuppressWarnings("static-method") public class singletonTest {
  @Test public void list() {
    List<Object> empty = Collections.emptyList();
    List<Integer> l1 = Collections.singletonList(box.it(5));
    List<String> l2 = Collections.singletonList("555");
    if (empty == null || l1 == null || l2 == null)
      return;
    assertCollectionsEqual(empty, singleton.list(null));
    assertCollectionsEqual(l1, singleton.list(box.it(5)));
    assertCollectionsEqual(l2, singleton.list("555"));
    // assertCollectionsEqual(Collections.singletonList(new Integer[] { 1, 2, 3 }),
    // singleton.list(new Integer[] { 1, 2, 3 }));
  }

  @Test public void array() {
    assertArrayEquals(new Integer[] { null }, singleton.array(null));
    // T=int:
    assertArrayEquals(Collections.singletonList(box.it(5)).toArray(), singleton.array(box.it(5)));
    // T=string:
    assertArrayEquals(Collections.singletonList("555").toArray(), singleton.array("555"));
    assertArrayEquals(Collections.singletonList(new Integer[] { box.it(1), box.it(2), box.it(3) }).toArray(),
        singleton.array(new Integer[] { box.it(1), box.it(2), box.it(3) }));
  }
}
