package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;

import org.junit.*;
/**
* For tested class please see {@link fluent.ly.file} .
*/
@SuppressWarnings( "static-method" ) public class fileTest {
  @Test public void renameToCSVTest() {
    final String path1 = "tmpFile123";
    final File file1 = new File(path1), file2 = new File(path1 + ".csv");
    if (file1.exists() || file1.isDirectory() || file2.exists() || file2.isDirectory())
      return;
    try {
      file1.createNewFile();
      file2.createNewFile(); // for more code coverage, will be deleted soon
    } catch (final IOException $) {
      azzert.that($, is(new IOException()));
    }
    file.renameToCSV(path1);
    String content = "";
    try {
      content = file.read(path1 + ".csv");
    } catch (final IOException $) {
      azzert.that($, is(new IOException()));
    }
    azzert.that("", is(content));
    new File(path1 + ".csv").delete();
  }
}
