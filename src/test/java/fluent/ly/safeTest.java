package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;
/**
* For tested enum please see {@link fluent.ly.safe} .
*/
@SuppressWarnings("static-method") public class safeTest {
  @Test public void doubleDivTest() {
    azzert.that(box.it(1.0), is(safe.div(1.5, 1.5)));
    azzert.that(box.it(1.0), is(safe.div(1.5, 0.0)));
  }
}
