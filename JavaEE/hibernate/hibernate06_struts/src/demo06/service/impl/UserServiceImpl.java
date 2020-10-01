package demo06.service.impl;

import demo06.dao.UserDao;
import demo06.dao.impl.UserDaoImpl;
import demo06.exception.UserException;
import demo06.pojo.User;
import demo06.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl = new UserDaoImpl();
    @Override
    public List<User> list() throws UserException {
        return userDaoImpl.list();
    }

}
