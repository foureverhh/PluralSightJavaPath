import com.foureverhh.test.LeapYear;
import com.foureverhh.test.WordWrap;
import org.junit.Assert;
import org.junit.Test;

public class WordWrapTest {
    public static final int LINE_LENGTH = 5;
    //A method that breaks words on specified space with new line. like a word processor would.

    @Test
    public void lineShouldWrapIfOverLineLength(){
        String result = WordWrap.wrap("The Sleepy",LINE_LENGTH);
        Assert.assertEquals("The S\nleepy",result);
    }

    @Test
    public void shortLinesShouldNotWrap(){
        String result = WordWrap.wrap("The",LINE_LENGTH);
        Assert.assertEquals("The",result);
    }

    @Test
    public void longerLineShouldWrapTwice(){
        String result = WordWrap.wrap("The Sleepy Brow",LINE_LENGTH);
        Assert.assertEquals("The S\nleepy\n Brow",result);
    }
    @Test
    public void evenLongerLineShouldWrapThrice(){
        String result = WordWrap.wrap("The Sleepy Brown Fox",LINE_LENGTH);
        Assert.assertEquals("The S\nleepy\n Brow\nn Fox",result);
    }
}

