
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearProbingTest {
    @Test
    public void LinearTest1() throws Exception {
        LinearProbing hash = new LinearProbing(10);
        hash.insert(2);
        assertEquals("0 0 2 0 0 0 0 0 0 0", hash.toString());
        hash.insert(3);
        assertEquals("0 0 2 3 0 0 0 0 0 0", hash.toString());
        hash.insert(12);
        assertEquals("0 0 2 3 12 0 0 0 0 0", hash.toString());
        hash.delete(3);
        assertEquals("0 0 2 X 12 0 0 0 0 0", hash.toString());
    }

    @Test
    public void LinearTest2() throws Exception {
        //1 10 1 2 3 4 -3 20
        LinearProbing hash = new LinearProbing(10);
        hash.insert(1);
        assertEquals("0 1 0 0 0 0 0 0 0 0", hash.toString());
        hash.insert(2);
        assertEquals("0 1 2 0 0 0 0 0 0 0", hash.toString());
        hash.insert(3);
        assertEquals("0 1 2 3 0 0 0 0 0 0", hash.toString());
        hash.insert(4);
        assertEquals("0 1 2 3 4 0 0 0 0 0", hash.toString());
        hash.delete(3);
        assertEquals("0 1 2 X 4 0 0 0 0 0", hash.toString());
        hash.insert(22);
        assertEquals("0 1 2 22 4 0 0 0 0 0", hash.toString());
    }

    @Test
    public void LinearTest3() throws Exception {
        //1 10 15 15 25 35 -35 45 -8
        LinearProbing hash = new LinearProbing(10);
        hash.insert(15);
        assertEquals("0 0 0 0 0 15 0 0 0 0", hash.toString());
        hash.insert(15);
        assertEquals("ERROR: valor ya existe", hash.toString());
        hash.insert(25);
        assertEquals("0 0 0 0 0 15 25 0 0 0", hash.toString());
        hash.insert(35);
        assertEquals("0 0 0 0 0 15 25 35 0 0", hash.toString());
        hash.delete(35);
        assertEquals("0 0 0 0 0 15 25 X 0 0", hash.toString());
        hash.insert(45);
        assertEquals("0 0 0 0 0 15 25 45 0 0", hash.toString());
        hash.delete(8);
        assertEquals("0 0 0 0 0 15 25 45 0 0", hash.toString());




    }
}