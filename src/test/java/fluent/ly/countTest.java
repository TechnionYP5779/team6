package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class countTest {
  @Test(expected = NullPointerException.class) public void ofNull() {
    assertZero(count.of(null)); // null == []
  }

  @Test(expected = NullPointerException.class) public void ofNullList() {
    assertZero(count.of(null));
  }

  @Test public void ofStringList() {
    final List<String> list = new ArrayList<>();
    assertZero(count.of(list)); // list == []
    list.add("a");
    assertEquals(count.of(list), 1); // list == ["a"]
    list.add("b");
    assertEquals(count.of(list), 2); // list == ["a","b"]
    list.remove("b");
    assertEquals(count.of(list), 1); // list == ["a"]
    list.remove("?");
    assertEquals(count.of(list), 1); // list == ["a"]
    list.clear();
    assertZero(count.of(list)); // list == []
    list.addAll(Arrays.asList("1,2,3,4,5".split(",")));
    assertEquals(count.of(list), 5); // list == ["1","2","3","4","5"]
  }

  @Test @SuppressWarnings("boxing") public void ofIntegerCharacterMap() {
    final Map<Integer, Character> map = new HashMap<>();
    assertZero(count.of(map.keySet()));
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
    assertZero(count.of(map.keySet()));
  }

  @Test public void ofStack() {
    final Stack<Double> stack = new Stack<>();
    assertZero(count.of(stack)); // stack == []
    stack.push(Box.box(1.0));
    assertEquals(count.of(stack), 1); // stack == [1.0]
    stack.push(Box.box(2.0));
    stack.push(Box.box(3.0));
    assertEquals(count.of(stack), 3); // stack == [1.0,2.0,3.0]
    stack.pop();
    assertEquals(count.of(stack), 2); // stack == [1.0,2.0]
    stack.clear();
    assertZero(count.of(stack)); // stack == []
  }
}
