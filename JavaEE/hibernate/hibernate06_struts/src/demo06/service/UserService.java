package demo06.service;

import demo06.exception.UserException;
import demo06.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> list() throws UserException;
}
