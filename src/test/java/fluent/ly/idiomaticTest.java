package fluent.ly;

import static org.junit.Assert.*;
import org.junit.*;
//I admit, there is alot i don't understand in the idiomatic class...
public class idiomaticTest {
  @SuppressWarnings("static-method") @Test public void incaseTest() {
    assertTrue(Integer.valueOf(7).equals(idiomatic.incase((3>2),Integer.valueOf(7))));
    assertFalse(Integer.valueOf(7).equals(idiomatic.incase((2>3),Integer.valueOf(7))));
    assertTrue((idiomatic.incase((2>3),Integer.valueOf(7))==null));
  }
  @SuppressWarnings("static-method") @Test public void quoteTest() {
    assertTrue(idiomatic.quote(null).equals("<null reference>"));
    assertTrue(idiomatic.quote("my name is").equals("\'my name is\'"));
    assertTrue(idiomatic.quote("\'slim shady\'").equals("\'\'slim shady\'\'"));
  }
  //some of the class alrady has tests inside the class, as i said, i dont
  //really understand most of the stuff there atm ...
}
