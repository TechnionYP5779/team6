package il.org.spartan.iterables;

import an.iterable;
import fluent.ly.azzert;
import org.junit.Test;

import static il.org.spartan.Utils.contains;
import static il.org.spartan.iterables.iterables.count;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("static-method") public class iterablesTest {

    @Test
    public void containsDegenerate() {
        azzert.nay(contains("Hello"));
    }

    @Test public void containseturnsFalseTypical() {
        azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
    }

    @Test public void containsSimple() {
        azzert.aye("", contains("Hello", "e"));
    }

    @Test public void containsTypical() {
        azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
    }

    @Test public void containsWithNulls() {
        azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
    }

    @Test public void countDoesNotIncludeNull() {
        assertEquals(3, count(iterable.over(null, "One", null, "Two", null, "Three")));
    }

    @Test public void countEmpty() {
        assertEquals(0, count(iterables.<String> empty()));
    }

    @Test public void countSingleton() {
        assertEquals(1, count(iterable.singleton(new Object())));
    }

    @Test public void countThree() {
        assertEquals(3, count(iterable.over("One", "Two", "Three")));
    }
}
