import com.foureverhh.dao.UserDao;

import com.foureverhh.pojo.Role;
import com.foureverhh.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*
*
* 一对一测试接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyRepositoryTest {

    @Autowired
    private UserDao userDao;

    /*
    * 添加用户，同时添加角色
    * */
    @Test
    public void oneToOneTest1(){
        //创建角色
        Role role = new Role();
        role.setRoleName("管理员");
        //创建用户
        User user = new User();
        user.setAge(30);
        user.setName("赵小刚");
        //建立关系
        role.setUser(user);
        user.setRole(role);
        //保存数据
        userDao.save(user);
    }

    /*
    * 根据用户ID查询用户，同时查询用户角色
    * */
    @Test
    public void oneToOneFindUserAndRoleByIdTest(){
        User user = userDao.findById(11).get();
        System.out.println(user.getId() + ", " + user.getName() + ", " + user.getRole().getRoleName());
    }

}
