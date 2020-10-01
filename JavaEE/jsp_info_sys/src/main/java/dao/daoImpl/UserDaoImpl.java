package dao.daoImpl;

import dao.UserDao;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/jsp_user_info_demo?serverTimezone=UTC";
    private String userName = "root";
    private String pin = "vps2020";

    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        User user = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,userName,pin);
            ps = conn.prepareStatement("SELECT * FROM t_user WHERE uname=? AND pwd=?");
            ps.setString(1,uname);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getString("birth"));
                user.setSex(rs.getString("sex"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int resetPwdInfo(int id,String newPwd) {
        int result = -1;
        try {
            String query = "UPDATE t_user SET pwd=? WHERE uid=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,userName,pin);
            ps = conn.prepareStatement(query);
            ps.setString(1,newPwd);
            ps.setInt(2,id);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<User> showAll(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = new ArrayList<User>();
        try {
            String query = "SELECT * FROM t_user";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, pin);
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getString("birth"));
                user.setSex(rs.getString("sex"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public int registerUser(User user) {
        int result = -1;
        try {
            String query = "INSERT INTO t_user VALUES (default,?,?,?,?,?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String birth = user.getBirth();
            String birthFormatted = birth.substring(birth.lastIndexOf("/")+1) + "-" +
                                    birth.substring(0,birth.indexOf("/")) + "-" +
                                    birth.substring(birth.indexOf("/")+1,birth.lastIndexOf("/"));
            conn = DriverManager.getConnection(url, userName, pin);
            ps = conn.prepareStatement(query);
            ps.setString(1,user.getUname());
            ps.setString(2,user.getPwd());
            ps.setString(3,user.getSex());
            ps.setInt(4,user.getAge());
            ps.setString(5,birthFormatted);
            System.out.println(birthFormatted);
            result = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
