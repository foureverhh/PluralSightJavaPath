package service.serviceImpl;



import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import org.apache.log4j.Logger;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        logger.debug(uname + "发起登录请求");
        User user = dao.checkUserLoginDao(uname,pwd);
        if(user != null){
            logger.debug(uname + "登录成功");
        }else {
            logger.debug(uname + "登录失败");
        }
        return user;
    }

    @Override
    public int resetPwdInfo(int id, String pwd) {
        logger.debug(id + " 发起密码修改");
        return dao.resetPwdInfo(id,pwd);
    }

    @Override
    public List<User> showAll(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = dao.showAll(req,resp);
        logger.debug("All users -> " + users);
        return users;
    }

    @Override
    public int registerUser(User user) {
        return dao.registerUser(user);
    }
}
