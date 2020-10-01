package demo07.service.impl;

import demo07.dao.UserDao;
import demo07.dao.impl.UserDaoImpl;
import demo07.exception.UserException;
import demo07.pojo.User;
import demo07.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl = new UserDaoImpl();
    @Override
    public List<User> list() throws UserException {
        return userDaoImpl.list();
    }

}
