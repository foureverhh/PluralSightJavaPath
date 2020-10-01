import com.foureverhh.dao.UserDao;
import com.foureverhh.dao.UserRepository;
import com.foureverhh.pojo.User;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/*
*
* JpaSpecificationExecutor接口测试
*
* */
//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyRepositoryTest {

    @Autowired
    private UserDao userDao;

 /*   @Resource
    private UserRepository userDaoImpl;
*/
    @Autowired
    private UserDao userDaoImpl;

   //根据用户Id查询用户
    @Test
    public void findUserByIdTestUserDao(){
        User user = userDao.findUserById(10);
        System.out.println(user.getName() + " with id -> " + user.getId());
    }

    //根据用户Id查询用户
    @Test
    public void findUserByIdTestUserRepository(){
        User user = userDaoImpl.findUserById(10);
        System.out.println(user.getName() + " with id -> " + user.getId());
    }
}
