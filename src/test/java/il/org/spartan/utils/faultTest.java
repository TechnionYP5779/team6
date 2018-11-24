package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "null" }) public class faultTest {
  @Test public void doneTest() {
    final String expectedOutput = fault.trace(new AssertionError()) + "\n   END stack trace: .................]]]\n-----this is all I know.";
    final int indexExpectedOutput = expectedOutput.indexOf("at java.base");
    final String finalOutput = fault.done() + "";
    azzert.that(expectedOutput.substring(indexExpectedOutput), is(finalOutput.substring(finalOutput.indexOf("at java.base"))));
  }

  @Test public void dumpTest() {
    azzert.that("\n FAULT: this should not have happened!\n-----To help you fix the code, here is some info", is(fault.dump()));
  }

  @Test public void dump2Test() {
    azzert.that("\n floor=[" + 8 + "]", is(fault.dump("floor", box.it(8))));
  }

  @Test public void specificallyTest() {
    final String expectedOutput = "\n FAULT: this should not have happened!\n floors\n"
        + "-----To help you fix the code, here is some info\n String=[a]\n String=[b]\n String=[c]\n   ";
    String finalOutput = fault.specifically("floors", (Object[]) new String[] { "a", "b", "c" }) + "";
    finalOutput = finalOutput.substring(0, finalOutput.indexOf("Stack trace"));
    azzert.that(expectedOutput, is(finalOutput));
  }

  @Test public void unreachableTest() {
    azzert.that(false, is(fault.unreachable()));
  }

  @Test public void boolTest() {
    azzert.that(false, is(fault.bool(null)));
  }
}
