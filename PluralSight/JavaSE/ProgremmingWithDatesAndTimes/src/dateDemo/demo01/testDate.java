package dateDemo.demo01;

import java.util.Date;

/*
*
* */
public class testDate {
    public static void main(String[] args) {
        Date date = new Date();
        long t = System.currentTimeMillis();
        System.out.println(date);
        Date d2 = new Date(1000);
        System.out.println(d2);
    }
}
