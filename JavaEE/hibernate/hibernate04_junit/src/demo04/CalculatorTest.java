package demo04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = null;

    @Before
    public void setup(){
        calculator = new Calculator();
        System.out.println("I am before");
    }
    @Test
    public void testAdd1() {
        Assert.assertEquals(3,(int) calculator.add(1,2) );
    }

    @Test
    public void testAdd2() {
        assertNull(calculator.add(null, 2));
    }
}