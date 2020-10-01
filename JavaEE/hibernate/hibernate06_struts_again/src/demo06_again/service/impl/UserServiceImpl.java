package demo06_again.service.impl;

import demo06_again.dao.UserDao;
import demo06_again.dao.impl.UserDaoImpl;
import demo06_again.exception.UserException;
import demo06_again.pojo.User;
import demo06_again.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl = new UserDaoImpl();
    @Override
    public List<User> list() throws UserException {
        return userDaoImpl.list();
    }

}
