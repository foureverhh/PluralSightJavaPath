import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;
import com.mchange.util.AssertException;
import javafx.scene.control.Alert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoImplTest {
    @Resource
    private UserDao userDaoImpl;

    @Test
    @Transactional //在测试类中使用事务管理，默认是rollback
    @Rollback(false) //取消自动回滚
    public void testInsertUser(){
        User user = new User();
        user.setName("王小利");
        user.setAge(24);
        userDaoImpl.insertUser(user);
    }

    @Test
    @Transactional //在测试类中使用事务管理，默认是rollback
    @Rollback(false) //取消自动回滚
    public void testUpdateUser(){
        User user = new User();
        user.setId(5);
        user.setName("王五");
        user.setAge(12);
        userDaoImpl.updateUser(user);
    }

    @Test
    @Transactional //在测试类中使用事务管理，默认是rollback
    @Rollback(false) //取消自动回滚
    public void testFindUser(){
        User user =  userDaoImpl.selectUserById(4);
        Assert.assertEquals("王小利",user.getName());
    }

    @Test
    @Transactional //在测试类中使用事务管理，默认是rollback
    @Rollback(false) //取消自动回滚
    public void testDeleteUser(){
        User user = new User();
        user.setId(4);
        //user.setName("李四");
        //user.setAge(12);
        userDaoImpl.deleteUser(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSelectUserByName(){
        List<User> users = userDaoImpl.selectUserByName("李四");
        System.out.println(users.get(0).getName());
    }

    @Test
    @Transactional
    public void testSelectUserByNameInSql(){
        List<User> users = userDaoImpl.selectUserByNameInSql("李四");
        System.out.println(users.get(0).getName());
    }

    @Test
    @Transactional
    public void testSelectUserByNameByCriteria(){
        List<User> users = userDaoImpl.selectUserByNameInByCriteria("李四");
        System.out.println(users.get(0).getName());
    }
}
