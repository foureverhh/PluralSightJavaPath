package demo06_again.action;

import com.opensymphony.xwork2.Action;
import demo06_again.exception.UserException;
import demo06_again.pojo.User;
import demo06_again.service.UserService;
import demo06_again.service.impl.UserServiceImpl;

import java.util.List;

public class UserAction {
    private UserService userService = new UserServiceImpl();
    private List<User> list =null;

    //业务方法
    public String list() throws UserException {
        list = userService.list();
        return Action.SUCCESS;
    }
    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
