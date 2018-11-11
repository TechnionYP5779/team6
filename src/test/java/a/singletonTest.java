package a;





import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class singletonTest {
 @Test public void list() {
    assertEquals(Collections.emptyList(), singleton.list(null));
    // T=int:
    assertEquals(Collections.singletonList(5), singleton.list(5));
    // T=string:
    assertEquals(Collections.singletonList("555"), singleton.list("555"));
    final Integer[] arr123 = new Integer[] { 1, 2, 3 };
    assertEquals(Collections.singletonList(arr123), singleton.list(arr123));
  }

  @Test public void array() {
    Assert.assertArrayEquals(new Integer[] { null }, singleton.array(null));
    // T=int:
    Assert.assertArrayEquals(Collections.singletonList(5).toArray(), singleton.array(5));
    // T=string:
    Assert.assertArrayEquals(Collections.singletonList("555").toArray(), singleton.array("555"));
    Assert.assertArrayEquals(Collections.singletonList(new Integer[] { 1, 2, 3 }).toArray(), singleton.array(new Integer[] { 1, 2, 3 }));
  }
}
