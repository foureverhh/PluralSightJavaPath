import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
*
* CrudRepository接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RepositoryTest {

    @Autowired
    private UserDao userDao;

    /*
    * 添加单条数据
    * */
    @Test
    public void testAddOne(){
        User user = new User();
        user.setAge(21);
        user.setName("赵小丽");
        userDao.save(user);
    }

}
