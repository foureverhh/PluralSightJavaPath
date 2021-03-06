package service;

import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    User checkUserLoginService(String uname, String pwd);
    int resetPwdInfo(int id,String pwd);

    List<User> showAll(HttpServletRequest req, HttpServletResponse resp);

    int registerUser(User user);
}
