package service;
import dao.UserDao;
import pojo.User;

public class UserService {
    private UserDao  dao = new UserDao();
    public User checkNameAndPassword(String name, String pwd){
        return dao.checkNameAndPassword(name,pwd);
    }
}
