package demo11_JDBCUtils;


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

        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("mysqlURL")
                    ,pros.getProperty("mysqlUser")
                    ,pros.getProperty("mysqlPwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Connection getMysqlConn1(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false&serverTimezone=UTC"
                    ,"root"
                    ,"!!8603122692167");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

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

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(Connection connection, PreparedStatement preparedStatement) {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
