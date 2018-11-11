package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class countTest {
  @Test(expected = NullPointerException.class) public void ofNull() {
    assertEquals(count.of(null), 0); // null == []
  }

  @Test(expected = NullPointerException.class) public void ofNullList() {
    assertEquals(count.of(null), 0);
  }

  @Test public void ofStringList() {
    final List<String> list = new ArrayList<>();
    assertEquals(count.of(list), 0); // list == []
    list.add("a");
    assertEquals(count.of(list), 1); // list == ["a"]
    list.add("b");
    assertEquals(count.of(list), 2); // list == ["a","b"]
    list.remove("b");
    assertEquals(count.of(list), 1); // list == ["a"]
    list.remove("?");
    assertEquals(count.of(list), 1); // list == ["a"]
    list.clear();
    assertEquals(count.of(list), 0); // list == []
    list.addAll(Arrays.asList("1,2,3,4,5".split(",")));
    assertEquals(count.of(list), 5); // list == ["1","2","3","4","5"]
  }

  @Test @SuppressWarnings("boxing") public void ofIntegerCharacterMap() {
    final Map<Integer, Character> map = new HashMap<>();
    assertEquals(count.of(map.keySet()), 0);
    map.put(1, 'a');
    map.put(2, 'b');
    map.put(3, 'c');
    assertEquals(count.of(map.keySet()), 3);
    map.put(1, 'z');
    assertEquals(count.of(map.keySet()), 3);
    map.remove(3, 'z');
    assertEquals(count.of(map.keySet()), 3);
    map.remove(3, 'c');
    assertEquals(count.of(map.keySet()), 2);
    map.clear();
    assertEquals(count.of(map.keySet()), 0);
  }

  @Test public void ofStack() {
    final Stack<Double> stack = new Stack<>();
    assertEquals(count.of(stack), 0); // stack == []
    stack.push(Double.valueOf(1.0));
    assertEquals(count.of(stack), 1); // stack == [1.0]
    stack.push(Double.valueOf(2.0));
    stack.push(Double.valueOf(3.0));
    assertEquals(count.of(stack), 3); // stack == [1.0,2.0,3.0]
    stack.pop();
    assertEquals(count.of(stack), 2); // stack == [1.0,2.0]
    stack.clear();
    assertEquals(count.of(stack), 0); // stack == []
  }
}
