package demo10_blob;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo10 {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(new File("files/newImage.jpeg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String pinCode = "!!8603122692167";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
                    ,user,pinCode);
  /*          ps = conn.prepareStatement("INSERT INTO t_user2 (username,headImg) VALUES (?,?)");
            ps.setObject(1,"test blob");
            ps.setBlob(2,new FileInputStream(new File("files/headImag.jpeg")));
            ps.executeUpdate();*/

            ps = conn.prepareStatement("SELECT headImg FROM t_user2 WHERE id = ?");
            ps.setObject(1,105);
            rs = ps.executeQuery();
            while (rs.next()){
                Blob blob = rs.getBlob("headImg");
                inputStream = blob.getBinaryStream();
                byte[] buffer = new byte[1024];
                int len;
                while(-1!=(len = inputStream.read(buffer))){
                    //System.out.println(new String(buffer,0,len));

                   outputStream.write(buffer,0,len);
                   outputStream.flush();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=rs){
                rs.close();
            }
            if(null!=ps){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
