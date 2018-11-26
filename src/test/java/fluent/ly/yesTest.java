package fluent.ly;

import org.junit.*;
/**
* For tested interface please see {@link fluent.ly.yes} .
*/
@SuppressWarnings("static-method") public class yesTest {
  @Test public void forgettingRunnable() {
    assert yes.forgetting(() -> {
      assert true;
    });
  }

  @Test public void forgettingArray() {
    assert yes.forgetting(box.it(10));
    assert yes.forgetting(box.it(10), box.it(9));
    assert yes.forgetting(box.it(10), box.it(9), box.it(8));
  }

  @Test public void ignoringBoolean() {
    assert yes.ignoring(true);
    assert yes.ignoring(false);
  }

  @Test public void ignoringDouble() {
    assert yes.ignoring(1.5);
  }

  @Test public void ignoringLong() {
    assert yes.ignoring(1L);
  }
}
