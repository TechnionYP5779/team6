package il.org.spartan;

import fluent.ly.*;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


import static fluent.ly.azzert.is;
import static fluent.ly.azzert.isNull;
import static il.org.spartan.Utils.cantBeNull;
import static il.org.spartan.Utils.mustBeNull;
import static il.org.spartan.utils.Permutation.swap;
import static org.junit.Assert.assertArrayEquals;

@SuppressWarnings({"null" ,"static-method"}) public class UtilsTest {
  @NotNull public static Integer[] intToIntegers(final int... is) {
    final Integer @NotNull [] $ = new Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }

  @Test @SuppressWarnings("unchecked") public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
    azzert.aye(ss.contains("A"));
  }

  @Test public void cantBeNullOfNull() {
    try {
      cantBeNull(null);
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void cantBeNullTypical() {
    assert cantBeNull(new Object()) != null;
  }

  @Test public void isNullTypical() {
    try {
      isNull(mustBeNull(null));
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void mustBeNullOfNotNull() {
    try {
      mustBeNull(new Object());
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void quoteEmptyString() {
    azzert.that(idiomatic.quote(""), is("''"));
  }

  @Test public void quoteNull() {
    azzert.that(idiomatic.quote(null), is("<null reference>"));
  }

  @Test public void quoteSimpleString() {
    azzert.that(idiomatic.quote("A"), is("'A'"));
  }

  @Test public void swapDegenerate() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 1);
    assertArrayEquals(as.array("A", "B", "C", "D"), ss);
  }

  @Test public void swapTypical() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 2);
    assertArrayEquals(as.array("A", "C", "B", "D"), ss);
  }

  @Test public void swapTypicalCase() {
    final Integer @NotNull [] $ = intToIntegers(29, 1, 60);
    swap($, 0, 1);
    assertArrayEquals(intToIntegers(1, 29, 60), $);
  }
}
