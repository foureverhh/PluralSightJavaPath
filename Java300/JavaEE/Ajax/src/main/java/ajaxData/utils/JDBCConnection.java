package ajaxData.utils;

import java.io.Closeable;
import java.sql.*;

public class JDBCConnection {

    private  String url = "jdbc:mysql://localhost:3306/";
    private String userName = "root";
    private String pwd = "vps2020";
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection getConnection(String databaseName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url+databaseName+"?useTimezone=true&serverTimezone=UTC",userName,pwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet getResultSet(String databaseName,String tableName,String userName){
        try {
            ps = getConnection(databaseName).prepareStatement("SELECT * FROM " + tableName + " WHERE uname = ?");
            ps.setString(1,userName);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return rs;
    }

    public void closeAll(Closeable...item){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
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
}
