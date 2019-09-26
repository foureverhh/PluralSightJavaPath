package demo06_transaction;

import java.sql.*;

public class Demo06 {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        String user = "root";
        String pin ="!!8603122692167";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
            ,user,pin);

            connection.setAutoCommit(false);//Default value is true, connection commits transaction automatically

            ps1 = connection.prepareStatement("UPDATE t_user SET username=? WHERE id <= ?");
            ps1.setObject(1,"update1");
            ps1.setObject(2,10);
            System.out.println("Database updated");
            ps1.execute();
            Thread.sleep(4000);

            ps2 = connection.prepareStatement("UPDATE t_user SET username=? WHERE id >= ? AND id <= ?");
            ps2.setObject(1,"update1 again");
            ps2.setObject(2,10);
            ps2.setObject(3,20);
            //ps2.setObject(3,"error"); //When there is error,although the ps1 succeed, but will not commit either
            System.out.println("Database updated again");
            ps2.execute();
            connection.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if(null!=ps2){
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=ps1){
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
