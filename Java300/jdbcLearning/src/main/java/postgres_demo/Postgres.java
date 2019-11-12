package postgres_demo;

import java.sql.*;

public class Postgres {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String username = "foureverhh";
        String pwd = "";
        String postgresql_url = "jdbc:postgresql://localhost:5432/foureverhh";
        Connection connection = null;
        PreparedStatement ps1 = null;
        Statement ps2 = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(postgresql_url,
                    username,
                    pwd);
            ps1 = connection.prepareStatement("INSERT INTO test (firstname,lastname) VALUES (?,?)");
            ps1.setObject(1,"first");
            ps1.setObject(2,"second");
            ps1.execute();

            ps2 = connection.createStatement();
            rs = ps2.executeQuery("SELECT * FROM test");
            while (rs.next()){
                System.out.println(rs.getInt(1)+"->"+rs.getString(2)+"->"+rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
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
