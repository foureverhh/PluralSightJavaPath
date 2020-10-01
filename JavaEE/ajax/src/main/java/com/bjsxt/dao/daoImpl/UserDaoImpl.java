package com.bjsxt.dao.daoImpl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private final String ROOT = "root";
    private final String PIN = "vps2020";
    private final String URL = "jdbc:mysql://localhost:3306/jsp_user_info_demo?serverTimezone=UTC";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    @Override
    public User getUserInfoService(String name) {
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,ROOT,PIN);
            String sql = "SELECT * FROM users WHERE name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUid(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPrice(rs.getDouble(3));
                user.setLoc(rs.getString(4));
                user.setDesc(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                rs.close();
                ps.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return user;
    }
}
