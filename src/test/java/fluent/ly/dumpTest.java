package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "unused", "null" }) public class dumpTest {
  private ByteArrayOutputStream newOutPut;

  public class SomeMethods {
    public void getA() {// can be empty
    }

    public void isA() {// can be empty
    }

    public void size() {// can be empty
    }

    public void toA() {// can be empty
    }
  }

  PrintStream originalStream = System.out;

  @Before public void redirectOutput() {
    newOutPut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(newOutPut));
  }

  @After public void redirectOutputAgain() {
    System.setOut(originalStream);
  }

  @Test public void goClassTest() {
    dump.go(SomeMethods.class);
    assert (newOutPut + "").contains("\n\n--IDENTIFICATION--\n");
    assert (newOutPut + "").contains("Simple Name = SomeMethods");
    assert (newOutPut + "").contains("IsAbstract = false");
    assert (newOutPut + "").contains("public void fluent.ly.dumpTest$SomeMethods.size()");
  }

  @Test public void goListTest() {
    final ArrayList<Integer> ls = new ArrayList<Integer>();
    ls.add(box.it(1));
    ls.add(box.it(2));
    ls.add(box.it(3));
    ls.add(box.it(3));
    dump.go(ls, " of some nums");
    azzert.that(
        "Exploring list of some nums\n\n--BEGIN Integer object: 1\nClass canonical name = java.lang.Integer\n"
            + "Class name = java.lang.Integer\n--END OBJECT--\n\n\n\n--BEGIN Integer object: 2\n"
            + "Class canonical name = java.lang.Integer\nClass name = java.lang.Integer\n--END OBJECT--\n\n\n\n"
            + "--BEGIN Integer object: 3\nClass canonical name = java.lang.Integer\nClass name = java.lang.Integer\n--END OBJECT--\n"
            + "\n\n\n--BEGIN Integer object: 3\nClass canonical name = java.lang.Integer\nClass name = java.lang.Integer\n--END OBJECT--\n\n",
        is(newOutPut + ""));
  }

  @Test public void goObjectTest() {
    SomeMethods c1 = new SomeMethods();
    dump.go(c1, "HELLO");
    String dynamicMethodsOrder = "";
    for (final @NotNull Method m : c1.getClass().getMethods()) {
      if (m.getParameterTypes().length != 0)
        continue;
      String name = m.getName();
      if (!"getClass".equals(name) && !"toString".equals(name))
        if (name.matches("^get[A-Z].*$"))
          dynamicMethodsOrder += "A = null\n";
        else if (name.matches("^is[A-Z].*$"))
          dynamicMethodsOrder += "A = null\n";
        else if ("size".equals(name))
          dynamicMethodsOrder += "size = null\n";
        else if (name.matches("^to[A-Z].*$"))
          dynamicMethodsOrder += "toA = null\n";
    }
    azzert.that("HELLO\n\n--BEGIN SomeMethods object: " + c1 + "\nClass canonical name = fluent.ly.dumpTest.SomeMethods\n"
        + "Class name = fluent.ly.dumpTest$SomeMethods\n" + dynamicMethodsOrder + "--END OBJECT--\n\n", is(newOutPut + ""));
  }

  @Test public void goObjectStringParameter() {
    dump.go("HELLO");
    assert (newOutPut + "").contains("--BEGIN String object: HELLO");
    assert (newOutPut + "").contains("Class canonical name = java.lang.String");
    assert (newOutPut + "").contains("--END OBJECT--");
  }

  @Test public void goObjectNull() {
    dump.go((Object) null, "stringA");
    assert (newOutPut + "").contains("stringA");
    assert (newOutPut + "").contains("NULL");
  }

  @Test public void goArray() {
    Object[] arr = new Object[3];
    arr[0] = "1";
    arr[0] = "2";
    arr[0] = "3";
    dump.go(arr);
    assert (newOutPut + "").contains("Total of 3 elements");
  }

  @Test public void goArrayAndMoreParameters() {
    Object[] arr = new Object[3];
    arr[0] = "1";
    arr[0] = "2";
    arr[0] = "3";
    dump.go(arr, "stringA", "stringB");
    assert (newOutPut + "").contains("stringA");
    assert (newOutPut + "").contains("stringB");
    assert (newOutPut + "").contains("Total of 3 elements");
  }
}
