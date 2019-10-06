package demo11_JDBCUtils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class demo11 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //ResultSet resultSet = null;

        try {
        connection = JDBCUtil.getMysqlConn();
        preparedStatement = connection.prepareStatement("INSERT INTO t_user2 (username) VALUES (?)");
        preparedStatement.setObject(1,"haha");
        preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
          JDBCUtil.close(connection,preparedStatement);
        }

    }
}
