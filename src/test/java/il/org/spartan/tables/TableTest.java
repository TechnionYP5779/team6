package il.org.spartan.tables;

import fluent.ly.*;
import static fluent.ly.azzert.*;
import org.junit.Test;

import java.io.*;

@SuppressWarnings({"static-method", "resource", "null"}) public class TableTest {

    @Test
    public void testTable(){
        Table t = new Table(box.it(1));
         Table t2 = new Table("",TableRenderer.builtin.values());
        assert (t.equals(t2));
        t.close();
        t2.close();
    }

    @Test
    public void testTable2(){
        assertNotNull(new Table(box.it(2)));
    }

    @Test
    public void testTable3(){
        assertNotNull(new Table("2".getClass()));
    }


    @Test
    public void testTable4() {
        Table table = new Table("2".getClass());
        table.reset();
        table = new Table("bla bla ",TableRenderer.builtin.values());
        assertNotNull(table);
    }

    @Test
    public void testCreate(){
        Table table = new Table("hello", System.getProperty("user.dir"));
        assertNotNull(table);
        table.close();
        new File("hello.txt").delete();
        new File("hello.tex2").delete();
        new File("hello.tex").delete();
        new File("hello.markdown").delete();
        new File("hello.csv").delete();
    }


    @Test
    public void testCreate2(){
        Table table = new Table("1".getClass(),System.getProperty("user.dir"));
        assertNotNull(table);
        table.close();
        new File("hello.txt").delete();
        new File("hello.tex2").delete();
        new File("hello.tex").delete();
        new File("hello.markdown").delete();
        new File("hello.csv").delete();
    }


    @Test
    public void testCreate3(){
        Table table = new Table("1".getClass(), System.getProperty("user.dir"));
        assert table.baseName().contains("/");
        table.close();
        new File(".txt").delete();
        new File(".tex2").delete();
        new File(".tex").delete();
        new File(".markdown").delete();
        new File(".csv").delete();
    }

    @Test
    public void testClose(){
        Table table = new Table("1".getClass(),System.getProperty("user.dir"));
        assert table.add(Statistic.N,Statistic.NA).length() == 1;
        table.close();
        new File(".txt").delete();
        new File(".tex2").delete();
        new File(".tex").delete();
        new File(".markdown").delete();
        new File(".csv").delete();
    }

    @Test
    public void testColumn() {
        Table table = new Table("1".getClass(), System.getProperty("user.dir"));
        table.close();
        new File(".txt").delete();
        new File(".tex2").delete();
        new File(".tex").delete();
        new File(".markdown").delete();
        new File(".csv").delete();
        assert("{null=1, 1=0.9}".equals(table.col("1", 0.9) + ""));
        assert("{null=1, 1=0.9, 2=5}".equals(table.col("2", 5L) + ""));
        assert("{null=1, 1=0.9, 2=5, 3=10}".equals(table.col("3", 10) + ""));
    }

    @Test
    public void testNotStatistic(){
        Table table = new Table("1".getClass(), System.getProperty("user.dir"));
        azzert.that(table,is(table.noStatistics()));
        new File(".txt").delete();
        new File(".tex2").delete();
        new File(".tex").delete();
        new File(".markdown").delete();
        new File(".csv").delete();
        table.close();
    }
    
    @Test
    public void testremove(){
      Table table = new Table("1".getClass(), System.getProperty("user.dir"));
      table.add(Statistic.N,Statistic.NA);
      table.remove(Statistic.N,Statistic.NA);
      Table table2 = new Table("1".getClass(), System.getProperty("user.dir"));
      assertEquals(table,table2);
      table.close();
      table2.close();
    }

    @Test
    public void testNotStatistic2(){
        Table table = new Table("1".getClass(), System.getProperty("user.dir"));
        table.nl();
        azzert.that(2,is(table.length()));
        new File(".txt").delete();
        new File(".tex2").delete();
        new File(".tex").delete();
        new File(".markdown").delete();
        new File(".csv").delete();
        table.close();
    }


    @Test
    public void testDescription(){
        Table table = new Table("1".getClass(), System.getProperty("user.dir"));
        assert table.description().contains("Table named  produced");
        new File(".txt").delete();
        new File(".tex2").delete();
        new File(".tex").delete();
        new File(".markdown").delete();
        new File(".csv").delete();
        table.close();

    }


}
