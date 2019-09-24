package calendarDemo.demo01;


import com.sun.xml.internal.xsom.XSUnionSimpleType;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarDemo01 {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(2010,1,10,12,23,40);
        Date time = c.getTime();
        TimeZone timeZone = c.getTimeZone();
        //System.out.println("Calendar is: "+c+", Time is:"+time);

        c.set(Calendar.YEAR,2020);
        c.set(Calendar.MONTH,1);//February
        c.set(Calendar.DAY_OF_WEEK,1);//Sunday
        c.setTime(new Date());
        time = c.getTime();
        System.out.println(time);
        System.out.println(Calendar.MONDAY);


        //Calculate date
        c.add(Calendar.DATE,5);
        System.out.println(c.getTime());
    }
}
