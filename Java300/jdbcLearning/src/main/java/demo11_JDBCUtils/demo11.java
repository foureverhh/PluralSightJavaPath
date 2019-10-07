package demo11_JDBCUtils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class demo11 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet resultSet = null;

        try {
        conn = JDBCUtil.getMysqlConn();
        ps = conn.prepareStatement("INSERT INTO t_user2 (username) VALUES (?)");
        ps.setObject(1,"haha");
        ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
          JDBCUtil.close(conn,ps);

           /* if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
        }

    }
}
