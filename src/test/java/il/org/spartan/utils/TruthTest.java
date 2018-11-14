package il.org.spartan.utils;

import java.util.function.*;

import org.junit.*;

public class TruthTest {
  @Test @SuppressWarnings("static-method") public void TruthOfTest() {
    BooleanSupplier t = () -> true, f = () -> false, assertionError = () -> {
      throw new AssertionError();
    }, runtimeException = () -> {
      throw new RuntimeException();
    }, exception = () -> {
      throw new Error();
    };
    assert Truth.truthOf(null) == Truth.N;
    assert Truth.truthOf(t) == Truth.T;
    assert Truth.truthOf(f) == Truth.F;
    assert Truth.truthOf(assertionError) == Truth.X;
    assert Truth.truthOf(runtimeException) == Truth.R;
    assert Truth.truthOf(exception) == Truth.Ħ;
  }

  @Test @SuppressWarnings("static-method") public void NotTest() {
    BooleanSupplier f = () -> false;
    assert Truth.truthOf(() -> true).not() == Truth.F;
    assert Truth.truthOf(f).not() == Truth.T;
  }

  @Test @SuppressWarnings("static-method") public void OrTest() {
    BooleanSupplier t = () -> true, f = () -> false;
    assert Truth.truthOf(t).or(Truth.T) == Truth.T;
    assert Truth.truthOf(t).or(Truth.F) == Truth.T;
    assert Truth.truthOf(f).or(Truth.T) == Truth.T;
    assert Truth.truthOf(f).or(Truth.F) == Truth.F;
  }

  @Test @SuppressWarnings("static-method") public void AndTest() {
    BooleanSupplier t = () -> true, f = () -> false;
    assert Truth.truthOf(t).and(Truth.T) == Truth.T;
    assert Truth.truthOf(t).and(Truth.F) == Truth.F;
    assert Truth.truthOf(f).and(Truth.T) == Truth.F;
    assert Truth.truthOf(f).and(Truth.F) == Truth.F;
  }

  @Test @SuppressWarnings("static-method") public void LetterOfTest() {
    BooleanSupplier f = () -> false, assertionError = () -> {
      throw new AssertionError();
    }, runtimeException = () -> {
      throw new RuntimeException();
    }, exception = () -> {
      throw new Error();
    };
    assert "true".equals(Truth.letterOf(() -> true));
    assert "false".equals(Truth.letterOf(f));
    assert "Assertion exception".equals(Truth.letterOf(assertionError));
    assert "Runtime exception".equals(Truth.letterOf(runtimeException));
    assert "Throwable of some other kind".equals(Truth.letterOf(exception));
    assert "Null pointer exception".equals(Truth.letterOf(null));
  }

  @Test @SuppressWarnings("static-method") public void DesTest() {
    BooleanSupplier f = () -> false, assertionError = () -> {
      throw new AssertionError();
    }, runtimeException = () -> {
      throw new RuntimeException();
    }, exception = () -> {
      throw new Error();
    };
    Truth a = Truth.truthOf(() -> true);
    assert "true".equals(a.description);
    a = Truth.truthOf(f);
    assert "false".equals(a.description);
    a = Truth.truthOf(assertionError);
    assert "Assertion exception".equals(a.description);
    a = Truth.truthOf(runtimeException);
    assert "Runtime exception".equals(a.description);
    a = Truth.truthOf(exception);
    assert "Throwable of some other kind".equals(a.description);
    a = Truth.truthOf(null);
    assert "Null pointer exception".equals(a.description);
  }
}
