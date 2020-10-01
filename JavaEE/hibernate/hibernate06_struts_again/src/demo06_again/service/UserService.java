package demo06_again.service;

import demo06_again.exception.UserException;
import demo06_again.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> list() throws UserException;
}
