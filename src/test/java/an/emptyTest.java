package an;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;


public class emptyTest {

    @Test public void emptyTestlist(){
        List<Integer> list = empty.list();
        assertEquals( 0, list.size());
    }

    @Test public void emptyTestIterable(){
        Iterator<Object> iter = empty.iterable().iterator();
        assertFalse(iter.hasNext());
        assertNull(iter.next());
    }
}
