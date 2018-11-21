package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;
import java.lang.reflect.*;
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
  
  @Before public void redirectOutput() {
    newOutPut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(newOutPut));
  }

  @Test public void goClassTest() {
    dump.go(SomeMethods.class);
    
    azzert.that(
       "\n" + 
       "\n" + 
       "--IDENTIFICATION--\n" + 
       "Simple Name = SomeMethods\n" + 
       "Canonical Name = fluent.ly.dumpTest.SomeMethods\n" + 
       "Name = fluent.ly.dumpTest$SomeMethods\n" + 
       "toString = class fluent.ly.dumpTest$SomeMethods\n" + 
       "super class = class java.lang.Object\n" + 
       "generic super class = class java.lang.Object\n" + 
       "class = class java.lang.Class\n" + 
       "No component type\n" + 
       "class loader = " + SomeMethods.class.getClassLoader() + "\n" + 
       "--MODIFIERS--\n" + 
       "Package = package fluent.ly\n" + 
       "Modifiers (decimal form) = 1\n" + 
       "Modifiers (binary form) = +1\n" + 
       "IsSynthetic = false\n" + 
       "IsPrimitive = false\n" + 
       "IsFinal = false\n" + 
       "IsAbstract = false\n" + 
       "IsStatic = false\n" + 
       "IsStrictfp = false\n" + 
       "--Visibility--\n" + 
       "IsPublic = true\n" + 
       "IsPrivate = false\n" + 
       "IsProtected = false\n" + 
       "--MEMBERS\n" + 
       "No fields\n" + 
       "Total of 13 methods:\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.size()\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.getA()\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.isA()\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.toA()\n" + 
       "\tpublic final void java.lang.Object.wait() throws java.lang.InterruptedException\n" + 
       "\tpublic final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException\n" + 
       "\tpublic final native void java.lang.Object.wait(long) throws java.lang.InterruptedException\n" + 
       "\tpublic boolean java.lang.Object.equals(java.lang.Object)\n" + 
       "\tpublic java.lang.String java.lang.Object.toString()\n" + 
       "\tpublic native int java.lang.Object.hashCode()\n" + 
       "\tpublic final native java.lang.Class java.lang.Object.getClass()\n" + 
       "\tpublic final native void java.lang.Object.notify()\n" + 
       "\tpublic final native void java.lang.Object.notifyAll()\n" + 
       "Only one constructors: public fluent.ly.dumpTest$SomeMethods(fluent.ly.dumpTest)\n" + 
       "Total of 2 declared fields:\n" + 
       "\tfinal fluent.ly.dumpTest fluent.ly.dumpTest$SomeMethods.this$0\n" + 
       "\tprivate static transient boolean[] fluent.ly.dumpTest$SomeMethods.$jacocoData\n" + 
       "Total of 5 declared methods:\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.size()\n" + 
       "\tprivate static boolean[] fluent.ly.dumpTest$SomeMethods.$jacocoInit()\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.getA()\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.isA()\n" + 
       "\tpublic void fluent.ly.dumpTest$SomeMethods.toA()\n" + 
       "Only one declared constructors: public fluent.ly.dumpTest$SomeMethods(fluent.ly.dumpTest)\n" + 
       "--CLASS SIGNATURE--\n" + 
       "No interfaces\n" + 
       "No annotations\n" + 
       "No type parameters\n" + 
       "No declared annotations\n" + 
       "No generic interfaces\n" + 
       "--CONTAINERS--\n" + 
       "No declared classes\n" + 
       "declaring class = class fluent.ly.dumpTest\n" + 
       "enclosing class = class fluent.ly.dumpTest\n" + 
       "No enclosing constructor\n" + 
       "No enclosing method\n" + 
       "--CLASS MEMBERS--\n" + 
       "No public classes\n" + 
       "No declared classes\n" + 
       "No declared annotations\n" + 
       "---------------------------\n" + 
       "",
        is(newOutPut + ""));
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
}
