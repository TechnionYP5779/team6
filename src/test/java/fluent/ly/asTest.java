package fluent.ly;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


@SuppressWarnings("null") public class asTest {

    @SuppressWarnings("static-method") @Test public void asTestEmptyIterator(){
        Iterator<Integer> resIter = as.asIterable().iterator();
        assertFalse(resIter.hasNext());
    }

    @SuppressWarnings("static-method") @Test public void asTestNotEmptyIterator(){
        Iterator<Integer> resIter = as.asIterable(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)).iterator();
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(1),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(2),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(3),resIter.next());
        assertFalse(resIter.hasNext());
    }

    @SuppressWarnings("static-method") @Test public void asTestbit(){
        assertEquals(1,as.bit(true));
        assertEquals(0,as.bit(false));
    }

    @SuppressWarnings("static-method") @Test public void asTestEmptyIntegerList(){
        List<Integer> res = as.ingeterList();
        assertEquals(new ArrayList<Integer>(), res);
    }

    @SuppressWarnings("static-method") @Test public void asTestNotEmptyIntegerList(){
        List<Integer> res = as.ingeterList(1,2,3);
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(3));
        assertEquals(list, res);
    }

    @SuppressWarnings("static-method") @Test public void asTestIntArray(){
        int[] arr = {1,2,3,4};
        int[] res = as.intArray(1,2,3,4);
        assertArrayEquals(arr,res);
    }

    @SuppressWarnings("static-method") @Test public void asTestIterator(){
        Iterator<Integer> resIter = as.iterator(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3));
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(1),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(2),resIter.next());
        assertTrue(resIter.hasNext());
        assertEquals(Integer.valueOf(3),resIter.next());
        assertFalse(resIter.hasNext());
    }

    @SuppressWarnings("static-method") @Test public void asTestlist(){
        List<String> res= as.list("A","B","C");
        List<String> list  = Arrays.asList("A","B","C");
        assertEquals(list,res);
    }

    @SuppressWarnings("static-method") @Test public void asTestSet(){
        Set<Integer> set = new HashSet<>();
        set.add(Integer.valueOf(1));
        set.add(Integer.valueOf(2));
        set.add(Integer.valueOf(3));
        Set<? extends Integer> res = as.set(Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3),Integer.valueOf(2),Integer.valueOf(3)//
            ,Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3));
        assertEquals(set,res);
    }

    @SuppressWarnings("static-method") @Test public void asTestString(){
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
