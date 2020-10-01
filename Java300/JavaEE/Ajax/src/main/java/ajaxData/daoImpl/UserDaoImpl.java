package ajaxData.daoImpl;

import ajaxData.dao.UserDao;
import ajaxData.model.User;
import ajaxData.utils.JDBCConnection;

import java.io.Closeable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    ResultSet resultSet = null;
    @Override
    public User getUserInfoService(String name) {
        User user = null;
        try {
            JDBCConnection jdbcConnection = new JDBCConnection();
            resultSet = jdbcConnection.getResultSet("ajaxData","users",name);
            if(resultSet.next()){
                user = new User(resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getFloat(3),
                                resultSet.getString(4),
                                resultSet.getString(5));
            }
            System.out.println("userDaoImpl: user -> " + user);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }


}
