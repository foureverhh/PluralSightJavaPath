package demo11_JDBCUtils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    static Properties pros = null; //get access to db.properties

    static {
        pros = new Properties();
        try {
            //pros.load(new FileInputStream("db.properties"));
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConn(){
        Connection connection = null;
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            connection = DriverManager.getConnection(pros.getProperty("mysqlURL")
                    ,pros.getProperty("mysqlUser")
                    ,pros.getProperty("mysqlPwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getOracleConn(){
        Connection connection = null;
        try {
            Class.forName(pros.getProperty("oracleDriver"));
            connection = DriverManager.getConnection(pros.getProperty("oracleURL")
                    ,pros.getProperty("oracleUser")
                    ,pros.getProperty("oraclePwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)  {
       if(resultSet!=null){
           try {
               resultSet.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       if(preparedStatement!=null){
           try {
               preparedStatement.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       if(connection!=null){
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement) {
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection) {

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
