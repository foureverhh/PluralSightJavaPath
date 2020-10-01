import com.foureverhh.dao.UserDao;
import com.foureverhh.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//SpringJUnit4ClassRunner.class将Junit注入Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoImplTest {
   /*
    @Resource
    private UserDao userDaoImpl;
    */

    @Autowired
    private UserDao userDao;

    @PersistenceContext(name="entityManagerFactory")
    private EntityManager entityManager;


    @Test
    @Transactional
    @Rollback(value = false)
    public void testInsertUser(){
        User user = new User();
        user.setAge(24);
        user.setName("二蛋");
        userDao.save(user);
    }

    @Test
    public void test1(){
        System.out.println(userDao.getClass().getName());
        System.out.println(userDao.getClass().getSimpleName());
        System.out.println(userDao.getClass());
        //uerDao->org.springframework.data.jpa.repository.support.SimpleJpaRepository@2935fd2c
        System.out.println(userDao);

        //jpaRepositoryFactory 中的getRepository(UserDao.class)
        //可以帮助我们为UserDao接口生成实现类，而这个实现类是SimpleJpaRepository的一个代理对象
        //要求：被实现的接口（UserDao）必须是要继承Repository接口
        JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(entityManager);
        UserDao dao = jpaRepositoryFactory.getRepository(UserDao.class);
        System.out.println(dao);
        System.out.println(dao.getClass());
    }
}
