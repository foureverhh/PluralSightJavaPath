package demo05_batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
* JDBC_331
* connection.setAutoCommit(false);
* statement.addBatch()
* statement.executeBatch()
* connection.commit()
* */
public class Demo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
            ,"root"
            ,"!!8603122692167");

            connection.setAutoCommit(false); //Set commit to manual
            statement = connection.createStatement();

            for(int i = 0; i<20000;i++){
                statement.addBatch("INSERT INTO t_user (username,pwd,regTime) VALUES ('user"+i+"','666',now())");
            }

            statement.executeBatch();
            connection.commit();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!= statement){
                try {
                    statement.close();
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
