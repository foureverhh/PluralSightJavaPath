package demo07_date;

import java.sql.*;
import java.util.Random;

import static java.time.LocalDate.now;

public class demo07 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;

        String user = "root";
        String pinCode = "!!8603122692167";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
                    ,user,pinCode);
            //conn.setAutoCommit(false);
            //ps1 = conn.prepareStatement("UPDATE t_user SET regTime=?,lastLoginTime=? WHERE id = ?");
            ps1 = conn.prepareStatement("INSERT INTO t_user2  (username,pwd,regTime,lastLogintime) VALUES (?,?,?,?)");
            for (int i = 1; i <=100 ; i++) {
                Random random = new Random();
                ps1.setObject(1,"user "+i);
                ps1.setObject(2,"pwd");
                Date date = new Date(System.currentTimeMillis()-random.nextInt(100000));
                ps1.setObject(3,date);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis()-random.nextInt(100000));
                ps1.setObject(4,timestamp);
                ps1.execute();
            }
            //conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=ps1){
                try {
                    ps1.close();
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
}
