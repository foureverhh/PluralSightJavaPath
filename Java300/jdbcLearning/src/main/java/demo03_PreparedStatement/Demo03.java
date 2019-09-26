package demo03_PreparedStatement;

import java.sql.*;

/*
* PreparedStatement  jdbc 329
* */
public class Demo03 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
            ,"root"
            ,"!!8603122692167");

            String sql = "INSERT INTO t_user ( username, pwd, regTime) VALUES (?,?,?)";//?占位符
            ps= connection.prepareStatement(sql);
            Long currentDate = System.currentTimeMillis();
            ps.setString(1,"元亨a");
            ps.setString(2,"123456");
            /*ps.setObject(1,"hengheng");
            ps.setObject(2,"hh");*/
            ps.setDate(3,new Date(currentDate));
            //ps.setObject(3,new Date(currentDate));
            System.out.println("Insert a record");
            //ps.execute(); //execute() would return a boolean value
            int count = ps.executeUpdate(); //executeUpdate() would return a how many rows data have been insert/update/delete
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null != ps){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!= connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
