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
    map.put(Box.it(1), Box.it('a'));
    map.put(Box.it(2), Box.it('b'));
    map.put(Box.it(3), Box.it('c'));
    azzert.that(count.of(map.keySet()), is(3));
    map.put(Box.it(1), Box.it('z'));
    azzert.that(count.of(map.keySet()), is(3));
    map.remove(Box.it(3), Box.it('z'));
    azzert.that(count.of(map.keySet()), is(3));
    map.remove(Box.it(3), Box.it('c'));
    azzert.that(count.of(map.keySet()), is(2));
    map.clear();
    assertZero(count.of(map.keySet()));
  }

  @Test public void ofStack() {
    final Stack<Double> stack = new Stack<>();
    assertZero(count.of(stack)); // stack == []
    stack.push(Box.it(1.0));
    azzert.that(count.of(stack), is(1)); // stack == [1.0]
    stack.push(Box.it(2.0));
    stack.push(Box.it(3.0));
    azzert.that(count.of(stack), is(3)); // stack == [1.0,2.0,3.0]
    stack.pop();
    azzert.that(count.of(stack), is(2)); // stack == [1.0,2.0]
    stack.clear();
    assertZero(count.of(stack)); // stack == []
  }
}
