package ServiceImpl;

import model.User;
import service.UserService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    private final Map<String,User> users = new ConcurrentHashMap<String, User>();
    
    public User getUser(String username) {
        return null;
    }

    public void saveUser(User user) {

    }
}
