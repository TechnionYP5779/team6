package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.idiomatic.*;

import org.junit.*;

public class idiomaticTest {
  @Test @SuppressWarnings("static-method") public void incaseTest() {
    assert Integer.valueOf(7).equals(idiomatic.incase(3 > 2, Integer.valueOf(7)));
    assert !Integer.valueOf(7).equals(idiomatic.incase(2 > 3, Integer.valueOf(7)));
    assert idiomatic.incase(2 > 3, Integer.valueOf(7)) == null;
  }

  @Test @SuppressWarnings("static-method") public void quoteTest() {
    assert "<null reference>".equals(idiomatic.quote(null));
    assert "\'my name is\'".equals(idiomatic.quote("my name is"));
    assert "\'\'slim shady\'\'".equals(idiomatic.quote("\'slim shady\'"));
  }

  @Test public void use0() {
    assert new idiomatic.Storer<>(this) != null;
  }

  @Test @SuppressWarnings("static-method") public void use08() {
    isNull(unless(true).eval(() -> new Object()));
  }

  @Test @SuppressWarnings("static-method") public void use09() {
    assert unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new idiomatic.Storer<>(this) != null;
    new idiomatic.Storer<>(this).when(true);
  }

  @Test @SuppressWarnings("static-method") public void use10() {
    assert when(true).eval(() -> new Object()) != null;
  }

  @Test @SuppressWarnings("static-method") public void use11() {
    isNull(when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    assert take(this) != null;
    isNull(take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(take(this).when(true), is(this));
  }

  @Test public void use4() {
    isNull(take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(take(this).unless(false), is(this));
  }

  @Test public void use6() {
    isNull(take(this).unless(true));
  }

  @Test public void use7() {
    isNull(take(this).unless(true));
    isNull(take(null).unless(true));
    isNull(take(null).unless(false));
  }
}
