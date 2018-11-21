package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

public class faultTest {  
  @Test public void doneTest() {
    String expectedOutput = "";
    expectedOutput += fault.trace(new AssertionError());
    expectedOutput += "\n   END stack trace: .................]]]\n-----this is all I know.";
    int indexExpectedOutput = expectedOutput.indexOf("at sun");
    
    String finalOutput = "";
    finalOutput += fault.done();
    int indexFinalOutput = finalOutput.indexOf("at sun");
   
    azzert.that(expectedOutput.substring(indexExpectedOutput), is(finalOutput.substring(indexFinalOutput)));
  }   
  
  @Test public void dumpTest() {
    azzert.that("\n FAULT: this should not have happened!\n-----To help you fix the code, here is some info", is(fault.dump()));
  }
  
  @Test public void dump2Test() {
    String name = "floor";
    int value = 8;
    azzert.that( "\n " + name + "=[" + value + "]", is(fault.dump(name,value)));
  }
  
  @Test public void specificallyTest() {
    String name = "floors";
    String expectedOutput = "";
    expectedOutput +="\n" + 
        " FAULT: this should not have happened!\n" + 
        " floors\n" + 
        "-----To help you fix the code, here is some info\n" + 
        " String=[a]\n" + 
        " String=[b]\n" + 
        " String=[c]\n   ";
    
    String finalOutput = "";
    finalOutput += fault.specifically(name, new String[]{"a", "b", "c"});
    int endWith = finalOutput.indexOf("Stack trace");
    finalOutput = finalOutput.substring(0, endWith);
    
    azzert.that(expectedOutput, is(finalOutput));
  }
  
  @Test public void unreachableTest() {
    azzert.that(false, is(fault.unreachable()));
  }
  
  @Test public void boolTest() {
    azzert.that(false, is(fault.bool(null)));
  }
  

}
