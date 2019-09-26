package demo03;

import java.sql.*;

/*
* PreparedStatement
* */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
            ,"root"
            ,"!!8603122692167");


            String sql = "INSERT INTO t_user (username,pwd,regTime) VALUES (?,?,?)";//?占位符
            PreparedStatement ps= connection.prepareStatement(sql);
            Long currentDate = System.currentTimeMillis();
            ps.setString(1,"元亨a");
            ps.setString(2,"123456");
            /*ps.setObject(1,"hengheng");
            ps.setObject(2,"hh");*/
            ps.setDate(3,new Date(currentDate));
            //ps.setObject(3,new Date(currentDate));
            System.out.println("Insert a record");
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
