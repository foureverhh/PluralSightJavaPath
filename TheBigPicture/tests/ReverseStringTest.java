import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {
    ReverseString test = new ReverseString("Time");
    @Test
    public void getOriginString() {

        assertEquals("Time",test.getOriginString());
    }

    @Test
    public void reverse() {
        assertEquals("emiT",test.reverse());
    }
}