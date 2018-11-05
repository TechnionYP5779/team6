package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;


import java.util.function.*;

public class TruthTest {
  @SuppressWarnings("static-method") @Test public void TruthOfTest() {
    BooleanSupplier t = () -> true;
    BooleanSupplier f = () -> false;
    BooleanSupplier assertionError = () -> {throw new AssertionError();};
    BooleanSupplier runtimeException = () -> {throw new RuntimeException();};
    //need somthing that implements throwable - Error or Exception - the last spits an error in eclipse about handeling
    BooleanSupplier exception = () -> {throw new Error();}; 
    assertTrue(Truth.truthOf(null) == Truth.N);
    assertTrue(Truth.truthOf(t) == Truth.T);
    assertTrue(Truth.truthOf(f) == Truth.F);
    assertTrue(Truth.truthOf(assertionError) == Truth.X);
    assertTrue(Truth.truthOf(runtimeException) == Truth.R);
    assertTrue(Truth.truthOf(exception) == Truth.Ħ);
  }
}
