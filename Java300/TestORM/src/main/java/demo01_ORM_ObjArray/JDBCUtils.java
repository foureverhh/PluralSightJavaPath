package demo01_ORM_ObjArray;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static Properties pros = null;
    static {
        try {
        pros = new Properties();
        pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConnection(){
        Connection conn = null;
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            conn = DriverManager.getConnection(pros.getProperty("mysqlURL")
                    ,pros.getProperty("mysqlUName")
                    ,pros.getProperty("mysqlPwd"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getMysqlConnection1(){
        Connection conn = null;
        try {
            //Class.forName(pros.getProperty("mysqlDriver"));
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?useSSL=false&serverTimezone=UTC"
                    ,"root"
                    ,"!!8603122692167");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){

        try {
            if(null!=rs) {
                rs.close();
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        try {
                if(null!=ps) {
                    ps.close();
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }


        try {
                if(null!=conn) {
                    conn.close();
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }

    }

    public static void close(Connection conn, Statement ps){
        try {
            if(null!=ps) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            if(null!=conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            if(null!=conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
