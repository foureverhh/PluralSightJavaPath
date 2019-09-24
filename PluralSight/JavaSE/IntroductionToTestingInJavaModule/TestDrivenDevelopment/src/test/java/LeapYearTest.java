import com.foureverhh.test.LeapYear;
import org.junit.Assert;
import org.junit.Test;

public class LeapYearTest {
    //a year is a leap year if it is divisible by four
    //but, years divisible by 100, are not leap years.
    //except years divisible by 400

    @Test
    public void leapYearsAreDivisibleByFour(){
        Assert.assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour(){
        Assert.assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearsAreNotDivisibleByOneHundred(){
        Assert.assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearsAreDivisibleByFourHundred(){
        Assert.assertTrue(LeapYear.isLeapYear(2000));
    }
}
