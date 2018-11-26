package il.org.spartan.tables;
import static fluent.ly.azzert.*;
import il.org.spartan.utils.Accumulator.Counter;
import org.junit.*;
/**
* For tested class please see {@link il.org.spartan.tables.Row} .
*/
class ExtendsRow extends Row<ExtendsRow>{
  private static final long serialVersionUID = 1;

  
  @Override protected ExtendsRow reset() {
    return null;
  }

  @Override protected ExtendsRow self() {
    return null;
  }

}


public class RowTest {
  @Test
  @SuppressWarnings("static-method")
  public void colTest() {
    ExtendsRow exe = new ExtendsRow();
    exe.col(new Counter("team6"));
    assertEquals(exe.size(),1);
    
    Object obj = exe.col( new Counter("project year"),new Counter("234311"));
    assertEquals(exe.size(),3);
    assertNull(obj);
    
    exe.col("key*");
    exe.col("key**",'a');
    exe.col("key***",1.1);
    exe.col("key****",1);
    exe.col("key*****",Integer.valueOf(1));
    exe.col("key******",Long.valueOf(1));
    exe.col("key*******",new Counter("234311"));
    assertEquals(exe.size(),10);
    
    Object [] array = {new Counter("project year")};
    exe.col("key********",array,0);
    assertEquals(exe.size(),11);
    
    exe.col("key*********",array);
    assertEquals(exe.size(),12);
    
    exe.col("key**********","13 items");
    assertEquals(exe.size(),13);
    
    assertNull(exe.reset());
    assertNull(exe.self());
  }
}
