package ajaxData.serviceImpl;

import ajaxData.dao.UserDao;
import ajaxData.daoImpl.UserDaoImpl;
import ajaxData.model.User;
import ajaxData.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    @Override
    public User getUserInfoService(String name) {
        return dao.getUserInfoService(name);
    }
}
