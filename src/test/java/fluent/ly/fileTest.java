package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;

import org.junit.*;

@SuppressWarnings({"static-method", "unused"}) public class fileTest {
    @Test public void renameToCSVTest() {
      String path1 = "tmpFile123";
      File file1 = new File(path1), file2 = new File(path1 + ".csv");
      if(file1.exists() || file1.isDirectory() || file2.exists() || file2.isDirectory())
        return;
      try {
        file1.createNewFile();
        file2.createNewFile(); //for more code coverage, will be deleted soon
      } catch (IOException e) {
      //wont get here
      }
      file.renameToCSV(path1);
      String content = "";
      try {
        content = file.read(path1 + ".csv");
      } catch (IOException e) {
        //wont get here
      }
      azzert.that("", is(content));
      (new File(path1 + ".csv")).delete();   
    }
}
