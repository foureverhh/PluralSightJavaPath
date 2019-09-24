package dateDemo.demo02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss 本年第w周,本月第W周");
        Date d = new Date();
        String formattedDate = df.format(d); //Convert date as formatted string
        System.out.println(formattedDate);

        String date = "1977-7-7";
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date wantedDate = df2.parse(date);
            System.out.println(wantedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
