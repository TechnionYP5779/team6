package il.org.spartan;

import static fluent.ly.azzert.*;

import java.io.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import fluent.ly.Out;

// did more tests than necessary, for better understanding the code
@SuppressWarnings({ "static-method", "unused", "null" }) public class CSVTest {
  @Test public void unescapeTest() {
    azzert.that("\n \r \t , \\ ", is(CSV.unescape("\\n \\r \\t \\. \\\\ \\w")));
    azzert.that("\\0", is(CSV.escape(null)));
  }

  @Test public void escapeTest() {
    azzert.that("\\n \\r \\t \\. \\\\", is(CSV.escape("\n \r \t , \\")));
  }

  @Test public void combineClassTest() {
    final Class<?>[] cs = new Class<?>[3];
    cs[0] = this.getClass();
    cs[1] = this.getClass();
    cs[2] = this.getClass();
    azzert.that(CSV.combine(cs), is("il.org.spartan.CSVTest,il.org.spartan.CSVTest,il.org.spartan.CSVTest"));
  }

  enum Mood {
    HAPPY, SAD, SATISFIED, ANXIETY, OK
  }

  @Test public void combineEnumTest() {
    azzert.that(CSV.combine(Mood.values()), is("HAPPY,SAD,SATISFIED,ANXIETY,OK"));
  }

  @Test public void splitStringTest() {
    azzert.that(new String[0], is(CSV.split("")));
    String[] strArrRes = new String[3];
    strArrRes[0] = "aa";
    strArrRes[1] = String.format("\n");
    strArrRes[2] = " \\";
    String[] strArrToCheck = CSV.split("aa" + ',' + "\\n" + ',' + " \\\\");
    for (int ¢ = 0; ¢ < strArrRes.length; ++¢)
      azzert.that(strArrRes[¢], is(strArrToCheck[¢]));
  }

  @Test public void splitEnumTest() {
    azzert.that(CSV.split(Mood.class, "HAPPY,SAD,SATISFIED,ANXIETY,OK"), is(Mood.values()));
  }

  // will edit this test later
  @Test public void saveAndLoadTest() {
    final File file = new File("tmpFile123");
    String[][] data = new String[2][];
    String[] str1 = new String[2], str2 = new String[2];
    str1[0] = "some ";
    str1[1] = "data";
    str2[0] = "more";
    str2[1] = "data";
    data[0] = str1;
    data[1] = str2;
    try {
      CSV.save(file, data);
    } catch (IOException e) {
      // wont get here
    }
    String[][] result = null;
    try {
      result = CSV.load(file);
    } catch (IOException e) {
      // wont get here
    }
    for (int ¢ = 0; ¢ < data.length; ++¢)
      azzert.that(result[¢], is(data[¢]));
    file.delete();
  }

  @Test public void splitToClassesTest() {
    final Class<?>[] cs = CSV.splitToClasses("il.org.spartan.CSVTest,il.org.spartan.CSVTest,il.org.spartan.CSVTest");
    for (int ¢ = 0; ¢ < cs.length; ++¢)
      azzert.that(cs[¢], is(this.getClass()));
  }
}
