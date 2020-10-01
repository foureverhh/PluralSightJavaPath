import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
*
* CrudRepository接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CrudRepositoryTest {

    @Autowired
    private UserDao userDao;

    /*
    * 添加单条数据
    * */
    //CrudRepository的save()自带事务管理功能
    //不需要再额外加@Transactional 和 @Rollback(false)
    @Test
    public void testAddOne(){
        User user = new User();
        user.setAge(21);
        user.setName("赵小丽");
        userDao.save(user);
    }

    /*
    * 批量添加
    * */
    @Test
    public void testAddIterable(){
        User user1 = new User();
        user1.setAge(22);
        user1.setName("赵小丽");

        User user2 = new User();
        user2.setAge(25);
        user2.setName("王小虎");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        userDao.saveAll(users);
    }

    /*
    * 根据Id查询
    * */
    @Test
    public void testQueryById(){
        User user = userDao.findById(10).get();
        System.out.println(user.getName());
    }

    /*
     * 查询所有
     * */
    @Test
    public void testQueryAll(){
        List<User> users = (List<User>) userDao.findAll();
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName());
        }
    }

    @Test
    public void testDeleteById(){
       userDao.deleteById(9);
    }

    @Test
    public void testUpdate1(){
        User user = new User();
        user.setId(8);
        user.setAge(24);
        user.setName("赵晓丽");
        userDao.save(user);
    }

    @Test
    public void testUpdate2(){
        User user =  userDao.findById(8).get();
        user.setAge(26);
        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testUpdate3(){
        User user =  userDao.findById(8).get();
        user.setName("赵晓红");
    }
}
