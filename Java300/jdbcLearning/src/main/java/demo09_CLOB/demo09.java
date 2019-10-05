package demo09_CLOB;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
* 测试CLOB,文本大对象的使用
* 包含：讲字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值取出来的操作
* */
public class demo09 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reader reader = null;

        String user = "root";
        String pinCode = "!!8603122692167";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest?useSSL=false"
                    , user, pinCode);
            ps = conn.prepareStatement("SELECT * FROM t_user2 where id=?");
            ps.setObject(1, 102);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clob clob = rs.getClob("myInfo");
                reader = clob.getCharacterStream();
                char[] buffer = new char[32];
                int len;
                while (-1 != (len = reader.read(buffer))) {
                    System.out.println(new String(buffer, 0, len));
                }
              /*
                int temp = 0;
                while(-1!=(temp=r.read())){
                  System.out.print((char)temp);
              }
              */
            }
            /*
            ps = conn.prepareStatement("INSERT INTO t_user2 (username,myInfo) VALUES (?,?)");
            ps.setString(1,"Yuanheng");
            //get text from a file
            ps.setClob(2,new FileReader(new File("files/clob.txt")));
            //get string to database
            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aabbcc".getBytes()))));
            ps.executeUpdate();
            */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != rs) {
                rs.close();
            }
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

