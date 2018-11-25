package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "null", "unused" }) public class FileUtilsTest {
  private ByteArrayOutputStream newErr;
  PrintStream originalErr = System.err;
  private BufferedReader reader;

  @Before public void redirectError() {
    newErr = new ByteArrayOutputStream();
    System.setErr(new PrintStream(newErr));
  }

  @After public void redirectErrorBack() {
    System.setErr(originalErr);
  }

  @Test public void findAllJavaFilesTest() {
    for (final String file : FileUtils.findAllJavaFiles(new String[] { "src/test/java", null }))
      azzert.that(true, is(file.endsWith(".java")));
    azzert.that(new ArrayList<>(), is(FileUtils.findAllJavaFiles(new String[] {})));
    azzert.that(new ArrayList<>(), is(FileUtils.findAllJavaFiles((String[]) null)));
  }

  @Test @SuppressWarnings("resource") public void readTest() {
    final String pathname = "tmpFile123";
    final File tmpFile123 = new File(pathname);
    if (tmpFile123.exists())
      return;
    try {
      tmpFile123.createNewFile();
    } catch (final IOException e) {// wont get here
    }
    final String data = "nonsense text";
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(pathname);
    } catch (final FileNotFoundException e1) {// wont get here
    }
    writer.print(data);
    writer.close();
    String contentFile = "";
    try {
      contentFile += FileUtils.read(tmpFile123);
    } catch (final IOException e) {// wont get here
    }
    tmpFile123.delete();
    assert contentFile.contains(data);
  }

  @Test public void writeToFileTest() {
    final File tmpFile123 = new File("tmpFile123");
    if (tmpFile123.exists())
      return;
    try {
      tmpFile123.createNewFile();
    } catch (final IOException e) {
      // wont get here
    }
    final String data = "sense text";
    try {
      FileUtils.writeToFile("tmpFile123", data);
    } catch (final FileNotFoundException e) {
      // wont get here
    }
    String contentFile = "";
    try {
      reader = new BufferedReader(new FileReader(tmpFile123));
      contentFile += reader.readLine();
      reader.close();
    } catch (final IOException e) {
      // wont get here
    }
    tmpFile123.delete();
    azzert.that(data, is(contentFile));
  }
}
