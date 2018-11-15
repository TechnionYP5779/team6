package a;



import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class singletonTest {
  @Test @SuppressWarnings("null") public void list() {
    assertCollectionsEqual(Collections.emptyList(), singleton.list(null));
    assertCollectionsEqual(Collections.singletonList(5), singleton.list(5));
    assertCollectionsEqual(Collections.singletonList("555"), singleton.list("555"));
    // assertCollectionsEqual(Collections.singletonList(new Integer[] { 1, 2, 3 }),
    // singleton.list(new Integer[] { 1, 2, 3 }));
  }

  @Test public void array() {
    assertArrayEquals(new Integer[] { null }, singleton.array(null));
    // T=int:
    assertArrayEquals(Collections.singletonList(5).toArray(), singleton.array(5));
    // T=string:
    assertArrayEquals(Collections.singletonList("555").toArray(), singleton.array("555"));
    assertArrayEquals(Collections.singletonList(new Integer[] { 1, 2, 3 }).toArray(), singleton.array(new Integer[] { 1, 2, 3 }));
  }
}
