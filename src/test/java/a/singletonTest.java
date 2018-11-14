package a;

import java.util.*;

import org.junit.*;

import static fluent.ly.azzert.*;

@SuppressWarnings({ "static-method", "boxing" }) public class singletonTest {
 @SuppressWarnings("null") @Test public void list() {
    assertCollectionsEqual(Collections.emptyList(), singleton.list(null));
    // T=int:
    assertCollectionsEqual(Collections.singletonList(5), singleton.list(5));
    // T=string:
    assertCollectionsEqual(Collections.singletonList("555"), singleton.list("555"));
    final Integer[] arr123 = new Integer[] { 1, 2, 3 };
    assertCollectionsEqual(Collections.singletonList(arr123), singleton.list(arr123));
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

