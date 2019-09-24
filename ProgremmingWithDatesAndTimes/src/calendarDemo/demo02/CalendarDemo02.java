package calendarDemo.demo02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo02 {
    public static void main(String[] args) throws ParseException {
        String temp = "2013-5-10";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(temp);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,1);
        calendar.setTime(date);

        int today = calendar.get(Calendar.DATE);
        System.out.println(date);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        int maxDate = calendar.getActualMaximum(Calendar.DATE);
        System.out.printf("%10s%10s%10s%10s%10s%10s%10s\n","日","一","二","三","四","五","六");
        for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
            System.out.printf("%10s","  ");
        }
        for (int i = 1; i <=maxDate; i++) {
            if(i ==today){
                System.out.printf("%10s","*"+Integer.toString(i));
            }else {
                System.out.printf("%10s",Integer.toString(i));
            }

            if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
                System.out.println();
            calendar.add(Calendar.DATE,1);
        }
    }
}
