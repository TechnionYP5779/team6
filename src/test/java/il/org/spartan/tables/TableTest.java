package il.org.spartan.tables;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.*;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "resource", "null" }) public class TableTest {
  @Test public void testTable() {
    final Table t = new Table(box.it(1));
    final Table t2 = new Table("", TableRenderer.builtin.values());
    assert t.equals(t2);
    t.close();
    t2.close();
  }

  @Test public void testTable2() {
    assertNotNull(new Table(box.it(2)));
  }

  @Test public void testTable3() {
    assertNotNull(new Table("2".getClass()));
  }

  @Test public void testTable4() {
    Table table = new Table("2".getClass());
    table.reset();
    table = new Table("bla bla ", TableRenderer.builtin.values());
    assertNotNull(table);
  }

  @Test public void testCreate() {
    final Table table = new Table("hello", System.getProperty("user.dir"));
    assertNotNull(table);
    table.close();
    new File("hello.txt").delete();
    new File("hello.tex2").delete();
    new File("hello.tex").delete();
    new File("hello.markdown").delete();
    new File("hello.csv").delete();
  }

  @Test public void testCreate2() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    assertNotNull(table);
    table.close();
    new File("hello.txt").delete();
    new File("hello.tex2").delete();
    new File("hello.tex").delete();
    new File("hello.markdown").delete();
    new File("hello.csv").delete();
  }

  @Test public void testCreate3() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    assert table.baseName().contains(System.getProperty("file.separator"));
    table.close();
    new File(".txt").delete();
    new File(".tex2").delete();
    new File(".tex").delete();
    new File(".markdown").delete();
    new File(".csv").delete();
  }

  @Test public void testClose() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    assert table.add(Statistic.N, Statistic.NA).length() == 1;
    table.close();
    new File(".txt").delete();
    new File(".tex2").delete();
    new File(".tex").delete();
    new File(".markdown").delete();
    new File(".csv").delete();
  }

  @Test public void testColumn() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    table.close();
    new File(".txt").delete();
    new File(".tex2").delete();
    new File(".tex").delete();
    new File(".markdown").delete();
    new File(".csv").delete();
    assert "{null=1, 1=0.9}".equals(table.col("1", 0.9) + "");
    assert "{null=1, 1=0.9, 2=5}".equals(table.col("2", 5L) + "");
    assert "{null=1, 1=0.9, 2=5, 3=10}".equals(table.col("3", 10) + "");
  }

  @Test public void testNotStatistic() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    azzert.that(table, is(table.noStatistics()));
    new File(".txt").delete();
    new File(".tex2").delete();
    new File(".tex").delete();
    new File(".markdown").delete();
    new File(".csv").delete();
    table.close();
  }

  @Test public void testremove() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    table.add(Statistic.N, Statistic.NA);
    table.remove(Statistic.N, Statistic.NA);
    final Table table2 = new Table("1".getClass(), System.getProperty("user.dir"));
    assertEquals(table, table2);
    table.close();
    table2.close();
  }

  @Test public void testNotStatistic2() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    table.nl();
    azzert.that(2, is(table.length()));
    new File(".txt").delete();
    new File(".tex2").delete();
    new File(".tex").delete();
    new File(".markdown").delete();
    new File(".csv").delete();
    table.close();
  }

  @Test public void testDescription() {
    final Table table = new Table("1".getClass(), System.getProperty("user.dir"));
    assert table.description().contains("Table named  produced");
    new File(".txt").delete();
    new File(".tex2").delete();
    new File(".tex").delete();
    new File(".markdown").delete();
    new File(".csv").delete();
    table.close();
  }
}
