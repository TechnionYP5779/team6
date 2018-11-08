package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.function.*;

public class TruthTest {
  @SuppressWarnings("static-method") @Test public void TruthOfTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    BooleanSupplier assertionError = () -> {
      throw new AssertionError();
    };
    BooleanSupplier runtimeException = () -> {
      throw new RuntimeException();
    };
    // need somthing that implements throwable - Error or Exception - the last spits
    // an error in eclipse about handeling
    BooleanSupplier exception = () -> {
      throw new Error();
    };
    assertTrue(Truth.truthOf(null) == Truth.N);
    assertTrue(Truth.truthOf(t) == Truth.T);
    assertTrue(Truth.truthOf(f) == Truth.F);
    assertTrue(Truth.truthOf(assertionError) == Truth.X);
    assertTrue(Truth.truthOf(runtimeException) == Truth.R);
    assertTrue(Truth.truthOf(exception) == Truth.Ħ);
  }

  @SuppressWarnings("static-method") @Test public void NotTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    assertTrue(Truth.truthOf(t).not() == Truth.F);
    assertTrue(Truth.truthOf(f).not() == Truth.T);
  }

  @SuppressWarnings("static-method") @Test public void OrTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    assertTrue(Truth.truthOf(t).or(Truth.T) == Truth.T);
    assertTrue(Truth.truthOf(t).or(Truth.F) == Truth.T);
    assertTrue(Truth.truthOf(f).or(Truth.T) == Truth.T);
    assertTrue(Truth.truthOf(f).or(Truth.F) == Truth.F);
  }

  @SuppressWarnings("static-method") @Test public void AndTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    assertTrue(Truth.truthOf(t).and(Truth.T) == Truth.T);
    assertTrue(Truth.truthOf(t).and(Truth.F) == Truth.F);
    assertTrue(Truth.truthOf(f).and(Truth.T) == Truth.F);
    assertTrue(Truth.truthOf(f).and(Truth.F) == Truth.F);
  }

  @SuppressWarnings("static-method") @Test public void LetterOfTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    BooleanSupplier assertionError = () -> {
      throw new AssertionError();
    };
    BooleanSupplier runtimeException = () -> {
      throw new RuntimeException();
    };
    BooleanSupplier exception = () -> {
      throw new Error();
    };
    assertTrue(Truth.letterOf(t).equals("true"));
    assertTrue(Truth.letterOf(f).equals("false"));
    assertTrue(Truth.letterOf(assertionError).equals("Assertion exception"));
    assertTrue(Truth.letterOf(runtimeException).equals("Runtime exception"));
    assertTrue(Truth.letterOf(exception).equals("Throwable of some other kind"));
    assertTrue(Truth.letterOf(null).equals("Null pointer exception"));
  }

  @SuppressWarnings("static-method") @Test public void DesTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    BooleanSupplier assertionError = () -> {
      throw new AssertionError();
    };
    BooleanSupplier runtimeException = () -> {
      throw new RuntimeException();
    };
    BooleanSupplier exception = () -> {
      throw new Error();
    };
    Truth a = Truth.truthOf(t);
    assertTrue(a.description.equals("true"));
    a = Truth.truthOf(f);
    assertTrue(a.description.equals("false"));
    a = Truth.truthOf(assertionError);
    assertTrue(a.description.equals("Assertion exception"));
    a = Truth.truthOf(runtimeException);
    assertTrue(a.description.equals("Runtime exception"));
    a = Truth.truthOf(exception);
    assertTrue(a.description.equals("Throwable of some other kind"));
    a = Truth.truthOf(null);
    assertTrue(a.description.equals("Null pointer exception"));
  }
}
