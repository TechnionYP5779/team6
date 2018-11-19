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
    azzert.that(count.of(list), is(1)); // list == ["a"]
    list.add("b");
    azzert.that(count.of(list), is(2)); // list == ["a","b"]
    list.remove("b");
    azzert.that(count.of(list), is(1)); // list == ["a"]
    list.remove("?");
    azzert.that(count.of(list), is(1)); // list == ["a"]
    list.clear();
    assertZero(count.of(list)); // list == []
    list.addAll(Arrays.asList("1,2,3,4,5".split(",")));
    azzert.that(count.of(list), is(5)); // list == ["1","2","3","4","5"]
  }

  @Test public void ofIntegerCharacterMap() {
    final Map<Integer, Character> map = new HashMap<>();
    assertZero(count.of(map.keySet()));
    map.put(Box.box(1), Box.box('a'));
    map.put(Box.box(2), Box.box('b'));
    map.put(Box.box(3), Box.box('c'));
    azzert.that(count.of(map.keySet()), is(3));
    map.put(Box.box(1), Box.box('z'));
    azzert.that(count.of(map.keySet()), is(3));
    map.remove(Box.box(3), Box.box('z'));
    azzert.that(count.of(map.keySet()), is(3));
    map.remove(Box.box(3), Box.box('c'));
    azzert.that(count.of(map.keySet()), is(2));
    map.clear();
    assertZero(count.of(map.keySet()));
  }

  @Test public void ofStack() {
    final Stack<Double> stack = new Stack<>();
    assertZero(count.of(stack)); // stack == []
    stack.push(Box.box(1.0));
    azzert.that(count.of(stack), is(1)); // stack == [1.0]
    stack.push(Box.box(2.0));
    stack.push(Box.box(3.0));
    azzert.that(count.of(stack), is(3)); // stack == [1.0,2.0,3.0]
    stack.pop();
    azzert.that(count.of(stack), is(2)); // stack == [1.0,2.0]
    stack.clear();
    assertZero(count.of(stack)); // stack == []
  }
}
