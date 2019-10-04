package demo07_date;

import com.sun.codemodel.internal.JForEach;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class demo08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String user = "root";
        String pinCode = "!!8603122692167";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
                    ,user,pinCode);

            ps = conn.prepareStatement("SELECT * FROM t_user2 WHERE lastLoginTime > ? AND lastLoginTime < ? ORDER BY lastLoginTime");
            Timestamp start  = new Timestamp(strToDate("2019-10-02 13:15:00"));
            Timestamp end = new Timestamp(strToDate("2019-10-02 13:16:00"));
            ps.setObject(1,start);
            ps.setObject(2,end);

            rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()){
                System.out.println(
                        rs.getInt(1)
                        +"->"+rs.getString(2)
                        +"->"+rs.getString(3)
                        +"->"+rs.getDate(4)
                        +"->"+rs.getTimestamp(5)
                );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=ps){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static long strToDate(String dateString){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss" );
        try {
            return format.parse(dateString).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
