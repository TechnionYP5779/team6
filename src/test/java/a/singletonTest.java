package a;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class singletonTest {
  @Test @SuppressWarnings("null") public void list() {
    assertCollectionsEqual(Collections.emptyList(), singleton.list(null));
    assertCollectionsEqual(Collections.singletonList(Box.it(5)), singleton.list(Box.it(5)));
    assertCollectionsEqual(Collections.singletonList("555"), singleton.list("555"));
    // assertCollectionsEqual(Collections.singletonList(new Integer[] { 1, 2, 3 }),
    // singleton.list(new Integer[] { 1, 2, 3 }));
  }

  @Test public void array() {
    assertArrayEquals(new Integer[] { null }, singleton.array(null));
    // T=int:
    assertArrayEquals(Collections.singletonList(Box.it(5)).toArray(), singleton.array(Box.it(5)));
    // T=string:
    assertArrayEquals(Collections.singletonList("555").toArray(), singleton.array("555"));
    assertArrayEquals(Collections.singletonList(new Integer[] { Box.it(1), Box.it(2), Box.it(3) }).toArray(),
        singleton.array(new Integer[] { Box.it(1), Box.it(2), Box.it(3) }));
  }
}
