
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobinHoodTest {
    @Test
    public void RobinHood1() throws Exception {
        //2 10 9 10 30 40 2 79
        RobinHood hash = new RobinHood(10);
        hash.insert(9);
        assertEquals("0 0 0 0 0 0 0 0 0 9", hash.toString());
        hash.insert(10);
        assertEquals("10 0 0 0 0 0 0 0 0 9", hash.toString());
        hash.insert(30);
        assertEquals("30 10 0 0 0 0 0 0 0 9", hash.toString());
        hash.insert(40);
        assertEquals("40 30 10 0 0 0 0 0 0 9", hash.toString());
        hash.insert(2);
        assertEquals("40 30 10 2 0 0 0 0 0 9", hash.toString());
        hash.insert(79);
        assertEquals("9 40 30 10 2 0 0 0 0 79", hash.toString());
    }

}