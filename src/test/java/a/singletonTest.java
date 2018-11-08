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
    // T=int[]
    final Integer[] arr123 = new Integer[] { 1, 2, 3 };
    final List<Integer[]> excepted = Collections.singletonList(arr123);
    final List<Integer[]> actual = singleton.list(arr123);
    assertEquals(excepted, actual);
  }

  @Test public void array() {
    final Integer[] arr = new Integer[] { null };
    Assert.assertArrayEquals(arr, singleton.array(null));
    // T=int:
    Assert.assertArrayEquals(Collections.singletonList(5).toArray(), singleton.array(5));
    // T=string:
    Assert.assertArrayEquals(Collections.singletonList("555").toArray(), singleton.array("555"));
    // T=int[]
    final Integer[] arr123 = new Integer[] { 1, 2, 3 };
    final java.lang.Object[] excepted = Collections.singletonList(arr123).toArray();
    final java.lang.Object[] actual = singleton.array(arr123);
    Assert.assertArrayEquals(excepted, actual);
  }
}
