package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.prune.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("null") public class prune2Test {
  @NotNull final String @NotNull [] nonNullArray = { "1", "2", "4" };
  @NotNull final String @NotNull [] alternatingArray = new String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final Supplier<List<String>> x = () -> {
    final List<String> $ = an.empty.list();
    $.add(null);
    $.add(null);
    $.add(null);
    $.add(null);
    $.add(null);
    $.add("A");
    $.add(null);
    $.add(null);
    $.add(null);
    $.add("B");
    $.add(null);
    $.add("C");
    $.add(null);
    $.add(null);
    $.add(null);
    $.add(null);
    return $;
  };
  @NotNull private final List<String> sparseCollection = new Supplier<List<String>>() {
    @Override public List<String> get() {
      @NotNull final List<String> $ = an.empty.list();
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("A");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("B");
      $.add(null);
      $.add("C");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      return $;
    }
  }.get();

  @Test public void testNotNullArrayItems() {
    azzert.that(nulls(nonNullArray)[0], is("1"));
    azzert.that(nulls(nonNullArray)[1], is("2"));
    azzert.that(nulls(nonNullArray)[2], is("4"));
  }

  @Test public void testNotNullArrayLength() {
    azzert.that(nulls(nonNullArray).length, is(nonNullArray.length));
  }

  @Test public void testPruneArrayAltenatingItems() {
    azzert.that(nulls(alternatingArray)[0], is("A"));
    azzert.that(nulls(alternatingArray)[1], is("B"));
    azzert.that(nulls(alternatingArray)[2], is("C"));
  }

  @Test public void testPruneArrayAltenatingLength() {
    azzert.that(nulls(alternatingArray).length, is(3));
  }

  @Test public void testPruneSparseCollectionContents() {
    final @NotNull String[] a = nulls(sparseCollection).toArray(new String[3]);
    azzert.that(a[0], is("A"));
    azzert.that(a[1], is("B"));
    azzert.that(a[2], is("C"));
    azzert.that(a.length, is(3));
  }

  @Test public void testPruneSparseCollectionLength() {
    azzert.that(nulls(sparseCollection).size(), is(3));
  }

  @Test public void testPrunNotNull() {
    assert nulls(sparseCollection) != null;
  }
  
  @Test public static void testShrink() {
    azzert.that(shrink(new Object[10]).length, is(0));
  }
  
}
