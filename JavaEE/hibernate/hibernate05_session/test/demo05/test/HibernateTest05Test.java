package demo05.test;

import demo05.pojo.User;
import demo05.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateTest05Test {

    private Session session;
    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getSession();
    }

    @After
    public void tearDown() throws Exception {
        HibernateUtil.closeSession();
    }

    @Test
    public void testSession1(){
        Transaction tx = null;
        User user = null;
        try{
            //user处在内存中，处于顺势状态，transient
            user = new User();
            user.setName("蔡依林");
            user.setAge(40);
            tx = session.beginTransaction();
            //user处于持久状态,被session管理，可以直接从这个session缓存,而不需要访问数据库
            session.save(user);
           /*
           //此时user是从session中直接取出user，而不需要访问数据库
           user = session.get(User.class,4);
            System.out.println(user);*/
            //相当于数据已处于持久状态，但是又在内存的session中更改了age信息
            //对象处于持久状态时，提交事务前会将session中对象和数据库中的记录进行脏检查
            //如果不一致进行数据同步
            //setAge（23）会在tx.commit()时，自动触发update sql将数据库中的数字更改
            user.setAge(23);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            if(tx!=null){
                tx.rollback();
            }
        }

        //清除指定对象,user变成游离detach状态
        session.evict(user);
    }

    @Test
    public void testSession2(){
        Transaction tx = null;
        User user = null;
        try{
            tx = session.beginTransaction();
            //user对象被session管理，处于持久状态
            user = session.get(User.class,3);

            //调用clear以后，session不再管理user，user处于游离状态
            session.clear();
            user.setName("张");

            //session管理user，user处于持久状态
            session.update(user);

            //测试持久化，自动处理脏数据
            user.setName("哈");
            tx.commit();
            //delete,是user存在于transient状态，在数据库中没有representation

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}