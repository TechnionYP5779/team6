package fluent.ly;

import java.io.*;
import java.util.*;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("null") public class outTest {
  
  private ByteArrayOutputStream newOutPut;

  @Before public void redirectOutput() {
    newOutPut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(newOutPut));
  }
  
  @Test public void outOneTest() {
    String str = "For Test";
    Out.out(str);
    azzert.that(str, is(newOutPut + ""));
  }
  
  @Test public void outBooleanTest() {
    String str = "For Test";
    Out.out(str, true);
    Out.out(str, false);
    azzert.that(str + " = true\n" + str + " = false\n", is(newOutPut + ""));
  }
  
  @Test public void outCollectionTest() {
    String str = "For Test";
    String name = "name";
    final ArrayList<Object> arr = new ArrayList<>();
    
    //empty case
    Out.out(name, arr);
    azzert.that("No " + name + "\n", is(newOutPut + ""));
    newOutPut.reset();
    
    //one object case
    arr.add(str);
    Out.out(name, arr);
    azzert.that("Only 1 " + name + ": "+ str + "\n", is(newOutPut + ""));
    newOutPut.reset();
    
    //two object or more case
    for(int ¢ = 0; ¢ <=32; ++¢) 
      arr.add(str);
    
    Out.out(name, arr);
    String begin = "Total of " + arr.size() + " " + name + ":\n";
    String end = "";
    for(int ¢ = 0; ¢ <= 19; ++¢) 
      end += String.format("\t%2d) %s\n", box.it(¢+1), arr.get(¢)); 
    
    end += String.format("\t...\n");
    
    
    azzert.that(begin + end, is(newOutPut + ""));
  }
  
  @Test public void outIntTest() {
    String str = "For Test";
    Out.out(str, 1);
    Out.out(str, -1);
    azzert.that(str + " = 1\n" + str + " = -1\n", is(newOutPut + ""));
  }
  
  @Test public void outObjectTest() {
    String str = "For Test";
    Out.out(str, str);
    Out.out(str, "ab");
    azzert.that(str + " = " + str + "\n"
              + str + " = ab\n", is(newOutPut + ""));
  }
  
  @Test public void outObjectsArrTest() {
    String str = "For Test";
    String name = "name";
    
    //case empty
    Out.out(name, new String[0]);
    azzert.that("No " + name + "\n", is(newOutPut + ""));
    newOutPut.reset();
    
    //case 1 object
    String arr1[] = new String[1];
    arr1[0] = str;
    Out.out(name, arr1);
    azzert.that(String.format("Only one %s: %s\n", name, arr1[0]), is(newOutPut + ""));
    newOutPut.reset();
    
    //case 2 objects or more
    String arr2[] = new String[2];
    arr2[0] = str;
    arr2[1] = str;
    Out.out(name, arr2);
    azzert.that(String.format("Total of %d %s:\n\t%s\n",
          box.it(arr2.length), name, separate.these(arr2).by("\n\t")),
    is(newOutPut + ""));
  }
  
}
