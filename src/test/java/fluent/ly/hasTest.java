package fluent.ly;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class hasTest {
  @Nullable private final String nul = null;

  @Test public void seriesA01() {
    assert has.nulls(nul);
  }

  @Test public void seriesA02() {
    assert !has.nulls("A");
  }
}
