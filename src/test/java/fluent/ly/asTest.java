package fluent.ly;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class asTest {

    @Test public void asTestEmptyIterator(){
        Iterator<Integer> resIter = as.asIterable().iterator();
        assertFalse(resIter.hasNext());
    }

    @Test public void asTestNotEmptyIterator(){
        Iterator<Integer> resIter = as.asIterable(1,2,3).iterator();
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(1),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(2),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(3),resIter.next());
        assertFalse(resIter.hasNext());
    }

    @Test public void asTestbit(){
        assertEquals(1,as.bit(true));
        assertEquals(0,as.bit(false));
    }

    @Test public void asTestEmptyIntegerList(){
        List<Integer> res = as.ingeterList();
        assertEquals(new ArrayList<Integer>(), res);
    }

    @Test public void asTestNotEmptyIntegerList(){
        List<Integer> res = as.ingeterList(1,2,3);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list, res);
    }

    @Test public void asTestIntArray(){
        int[] arr = {1,2,3,4};
        int[] res = as.intArray(1,2,3,4);
        assertArrayEquals(arr,res);
    }

    @Test public void asTestIterator(){
        Iterator<Integer> resIter = as.iterator(1,2,3);
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(1),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(2),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(3),resIter.next());
        assertFalse(resIter.hasNext());
    }

    @Test public void asTestlist(){
        List<String> res= as.list("A","B","C");
        List<String> list  = Arrays.asList("A","B","C");
        assertEquals(list,res);
    }

    @Test public void asTestSet(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<? extends Integer> res = as.set(1,1,2,3,2,3,1,2,3);
        assertEquals(set,res);
    }

    @Test public void asTestString(){
        String res = as.string(null);
        assertEquals("null",res);

        res = as.string("test");
        assertEquals("test", res);

        res = as.string('b');
        assertEquals("b",res);

        Object obj = new Object();
        res = as.string(obj);
        assertEquals(obj.toString(), res);

    }

}
