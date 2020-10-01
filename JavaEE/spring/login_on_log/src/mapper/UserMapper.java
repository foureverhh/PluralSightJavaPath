package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserMapper {
    //@Select("select * from user where username=#{username} and password=#{password}")
    User selUserByNameAndPwd(User user);

    //@Select("select * from user")
    List<User> selAll();

    int insert(User user);
}
