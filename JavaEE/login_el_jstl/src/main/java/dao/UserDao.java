package dao;

import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> users;

    public UserDao() {
        users = new ArrayList<>();
        users.add(new User(1,"name1","pwd1"));
        users.add(new User(2,"name2","pwd3"));
    }

    public User checkNameAndPassword(String name,String pwd){
        User item = null;
        for (User user : users){
            if(user.getName().equals(name) && user.getPwd().equals(pwd)){
                item = user;
                break;
            }
        }
        return item;
    }
}
