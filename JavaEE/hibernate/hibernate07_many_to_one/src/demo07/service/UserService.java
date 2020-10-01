package demo07.service;

import demo07.exception.UserException;
import demo07.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> list() throws UserException;
}
