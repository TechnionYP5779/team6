package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class lazyTest {
  @Test public void getTest() {
    final Supplier<@Nullable String> supp = new Supplier<@Nullable String>() {
      int i;

      @Override public String get() {
        ++i;
        return i + "";
      }
    };
    // compute supp.get with the lazy interface, therefore function get happens only
    // once
    final lazy<@Nullable String> newLazy = lazy.get(supp);
    azzert.that("1", is(newLazy.get()));
    azzert.that("1", is(newLazy.get()));
    // compute supp.get withOut the lazy interface, therefore function get happens
    // more than once
    azzert.that("2", is(supp.get()));
    azzert.that("3", is(supp.get()));
    // just for sureness compute get with lazy one more time
    azzert.that("1", is(newLazy.get()));
    // but i now equal to 3, therefore:
    azzert.that("4", is(supp.get()));
  }
}
