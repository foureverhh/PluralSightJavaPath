package Regex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher("aa232**ssd445*sds223");
        //Replace
        String newStr = m.replaceAll("#");
        System.out.println(newStr);
        //split
        String[] strings = newStr.split("[\\#\\*]+");
        System.out.println(Arrays.toString(strings));
    }
}
