package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "unused", "null" }) public class dumpTest {
  private ByteArrayOutputStream newOutPut;

  @Before public void redirectOutput() {
    newOutPut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(newOutPut));
  }

  @Test public void goClassTest() {
    dump.go(Integer.class);
    azzert.that(
        "\n\n--IDENTIFICATION--\nSimple Name = Integer\nCanonical Name = java.lang.Integer\nName = java.lang.Integer\n"
            + "toString = class java.lang.Integer\nsuper class = class java.lang.Number\ngeneric super class = class java.lang.Number\n"
            + "class = class java.lang.Class\nNo component type\nNo class loader\n--MODIFIERS--\n"
            + "Package = package java.lang, Java Platform API Specification, version 1.8\nModifiers (decimal form) = 17\n"
            + "Modifiers (binary form) = +1+16\nIsSynthetic = false\nIsPrimitive = false\nIsFinal = true\nIsAbstract = false\n"
            + "IsStatic = false\nIsStrictfp = false\n--Visibility--\nIsPublic = true\nIsPrivate = false\nIsProtected = false\n"
            + "--MEMBERS\nTotal of 5 fields:\n\tpublic static final int java.lang.Integer.MIN_VALUE\n"
            + "\tpublic static final int java.lang.Integer.MAX_VALUE\n\tpublic static final java.lang.Class java.lang.Integer.TYPE\n"
            + "\tpublic static final int java.lang.Integer.SIZE\n\tpublic static final int java.lang.Integer.BYTES\nTotal of 54 methods:\n"
            + "\tpublic static int java.lang.Integer.numberOfLeadingZeros(int)\n\tpublic static int java.lang.Integer.numberOfTrailingZeros(int)\n"
            + "\tpublic static int java.lang.Integer.bitCount(int)\n\tpublic boolean java.lang.Integer.equals(java.lang.Object)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toString(int,int)\n\tpublic java.lang.String java.lang.Integer.toString()\n"
            + "\tpublic static java.lang.String java.lang.Integer.toString(int)\n\tpublic static int java.lang.Integer.hashCode(int)\n"
            + "\tpublic int java.lang.Integer.hashCode()\n\tpublic static int java.lang.Integer.min(int,int)\n"
            + "\tpublic static int java.lang.Integer.max(int,int)\n\tpublic static int java.lang.Integer.reverseBytes(int)\n"
            + "\tpublic int java.lang.Integer.compareTo(java.lang.Integer)\n\tpublic int java.lang.Integer.compareTo(java.lang.Object)\n"
            + "\tpublic byte java.lang.Integer.byteValue()\n\tpublic short java.lang.Integer.shortValue()\n"
            + "\tpublic int java.lang.Integer.intValue()\n\tpublic long java.lang.Integer.longValue()\n"
            + "\tpublic float java.lang.Integer.floatValue()\n\tpublic double java.lang.Integer.doubleValue()\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.valueOf(int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static java.lang.String java.lang.Integer.toHexString(int)\n\tpublic static int java.lang.Integer.compare(int,int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.reverse(int)\n\tpublic static int java.lang.Integer.sum(int,int)\n"
            + "\tpublic static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException\n"
            + "\tpublic static long java.lang.Integer.toUnsignedLong(int)\n\tpublic static int java.lang.Integer.compareUnsigned(int,int)\n"
            + "\tpublic static int java.lang.Integer.divideUnsigned(int,int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)\n"
            + "\tpublic static int java.lang.Integer.highestOneBit(int)\n\tpublic static int java.lang.Integer.lowestOneBit(int)\n"
            + "\tpublic static int java.lang.Integer.parseUnsignedInt(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.parseUnsignedInt(java.lang.String,int) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.remainderUnsigned(int,int)\n\tpublic static int java.lang.Integer.rotateLeft(int,int)\n"
            + "\tpublic static int java.lang.Integer.rotateRight(int,int)\n\tpublic static int java.lang.Integer.signum(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toBinaryString(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toOctalString(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toUnsignedString(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toUnsignedString(int,int)\n"
            + "\tpublic final void java.lang.Object.wait() throws java.lang.InterruptedException\n"
            + "\tpublic final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException\n"
            + "\tpublic final native void java.lang.Object.wait(long) throws java.lang.InterruptedException\n"
            + "\tpublic final native java.lang.Class java.lang.Object.getClass()\n\tpublic final native void java.lang.Object.notify()\n"
            + "\tpublic final native void java.lang.Object.notifyAll()\nTotal of 2 constructors:\n\tpublic java.lang.Integer(int)\n"
            + "\tpublic java.lang.Integer(java.lang.String) throws java.lang.NumberFormatException\nTotal of 11 declared fields:\n"
            + "\tpublic static final int java.lang.Integer.MIN_VALUE\n\tpublic static final int java.lang.Integer.MAX_VALUE\n"
            + "\tpublic static final java.lang.Class java.lang.Integer.TYPE\n\tstatic final char[] java.lang.Integer.digits\n"
            + "\tstatic final char[] java.lang.Integer.DigitTens\n\tstatic final char[] java.lang.Integer.DigitOnes\n"
            + "\tstatic final int[] java.lang.Integer.sizeTable\n\tprivate final int java.lang.Integer.value\n"
            + "\tpublic static final int java.lang.Integer.SIZE\n\tpublic static final int java.lang.Integer.BYTES\n"
            + "\tprivate static final long java.lang.Integer.serialVersionUID\nTotal of 52 declared methods:\n"
            + "\tpublic static int java.lang.Integer.numberOfLeadingZeros(int)\n\tpublic static int java.lang.Integer.numberOfTrailingZeros(int)\n"
            + "\tpublic static int java.lang.Integer.bitCount(int)\n\tpublic boolean java.lang.Integer.equals(java.lang.Object)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toString(int,int)\n\tpublic java.lang.String java.lang.Integer.toString()\n"
            + "\tpublic static java.lang.String java.lang.Integer.toString(int)\n\tpublic static int java.lang.Integer.hashCode(int)\n"
            + "\tpublic int java.lang.Integer.hashCode()\n\tpublic static int java.lang.Integer.min(int,int)\n"
            + "\tpublic static int java.lang.Integer.max(int,int)\n\tpublic static int java.lang.Integer.reverseBytes(int)\n"
            + "\tpublic int java.lang.Integer.compareTo(java.lang.Integer)\n\tpublic int java.lang.Integer.compareTo(java.lang.Object)\n"
            + "\tpublic byte java.lang.Integer.byteValue()\n\tpublic short java.lang.Integer.shortValue()\n"
            + "\tpublic int java.lang.Integer.intValue()\n\tpublic long java.lang.Integer.longValue()\n"
            + "\tpublic float java.lang.Integer.floatValue()\n\tpublic double java.lang.Integer.doubleValue()\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.valueOf(int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static java.lang.String java.lang.Integer.toHexString(int)\n\tpublic static int java.lang.Integer.compare(int,int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tstatic void java.lang.Integer.getChars(int,int,char[])\n\tpublic static int java.lang.Integer.reverse(int)\n"
            + "\tstatic int java.lang.Integer.stringSize(int)\n\tpublic static int java.lang.Integer.sum(int,int)\n"
            + "\tpublic static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException\n"
            + "\tpublic static long java.lang.Integer.toUnsignedLong(int)\n\tpublic static int java.lang.Integer.compareUnsigned(int,int)\n"
            + "\tpublic static int java.lang.Integer.divideUnsigned(int,int)\n"
            + "\tstatic int java.lang.Integer.formatUnsignedInt(int,int,char[],int,int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)\n"
            + "\tpublic static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)\n"
            + "\tpublic static int java.lang.Integer.highestOneBit(int)\n\tpublic static int java.lang.Integer.lowestOneBit(int)\n"
            + "\tpublic static int java.lang.Integer.parseUnsignedInt(java.lang.String) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.parseUnsignedInt(java.lang.String,int) throws java.lang.NumberFormatException\n"
            + "\tpublic static int java.lang.Integer.remainderUnsigned(int,int)\n\tpublic static int java.lang.Integer.rotateLeft(int,int)\n"
            + "\tpublic static int java.lang.Integer.rotateRight(int,int)\n\tpublic static int java.lang.Integer.signum(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toBinaryString(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toOctalString(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toUnsignedString(int)\n"
            + "\tpublic static java.lang.String java.lang.Integer.toUnsignedString(int,int)\n"
            + "\tprivate static java.lang.String java.lang.Integer.toUnsignedString0(int,int)\nTotal of 2 declared constructors:\n"
            + "\tpublic java.lang.Integer(int)\n\tpublic java.lang.Integer(java.lang.String) throws java.lang.NumberFormatException\n"
            + "--CLASS SIGNATURE--\nOnly one interfaces: interface java.lang.Comparable\nNo annotations\nNo type parameters\n"
            + "No declared annotations\nOnly one generic interfaces: java.lang.Comparable<java.lang.Integer>\n--CONTAINERS--\n"
            + "Only one declared classes: class java.lang.Integer$IntegerCache\nNo declaring class\nNo enclosing class\n"
            + "No enclosing constructor\nNo enclosing method\n--CLASS MEMBERS--\nNo public classes\n"
            + "Only one declared classes: class java.lang.Integer$IntegerCache\nNo declared annotations\n---------------------------\n",
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
