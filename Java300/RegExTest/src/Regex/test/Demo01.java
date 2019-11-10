package Regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
    public static void main(String[] args) {
        //check string: sfsdf23323,是否符合\w+

        //表达式对象
        //Pattern p = Pattern.compile("\\w+");
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");

        //创建Matcher对象
        //Matcher m = p.matcher("sfsd/f&&23323");
        Matcher m = p.matcher("aa232**ssd445*sds223");
        boolean b1 = m.matches();//尝试将整个字符序列与该模式匹配
        //boolean b2 = m.find(); //该方法扫描输入的序列，查找与该模式匹配的一个子序列
        System.out.println(b1);
        //System.out.println(b2);
        int counter = 0;
        while (m.find()){
            counter++;
            //System.out.println(m.group());
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));

        }
        System.out.println(counter);
    }
}
