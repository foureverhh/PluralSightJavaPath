import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;
import java.util.List;

/*
*
* Repository接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaRepositoryTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName());
        }
    }

    @Test
    public void testAge(){
        List<User> users = userDao.findAgeGreaterThan(20);
        for(User user : users){
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getAge());
        }
    }


}
