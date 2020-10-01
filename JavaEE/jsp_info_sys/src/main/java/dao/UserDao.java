package dao;

import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserDao {
    User checkUserLoginDao(String uname,String pwd);
    int resetPwdInfo(int id,String newPwd);

    List<User> showAll(HttpServletRequest req, HttpServletResponse resp);

    int registerUser(User user);
}
