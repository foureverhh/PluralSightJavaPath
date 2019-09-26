package demo04;

import java.sql.*;


/*
* executeQuery() && resultSet test
* 330_JDBC
* close sequence: ResultSet--> Statement --> connection
* use ?useSSL=false to settle the ssl error
* */
public class Demo04 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
            ,"root"
            ,"!!8603122692167");
            String sql = "SELECT id,username,pwd FROM t_user where id>=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,2);//Return all rows with id > 2;
            //ps.setObject(1,2);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getString(3));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=rs){
                rs.close();
            }
            if(null!=ps){
                ps.close();
            }
            if(null!=connection){
                connection.close();
            }

        }
    }
}
