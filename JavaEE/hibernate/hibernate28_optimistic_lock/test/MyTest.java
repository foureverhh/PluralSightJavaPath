
import demo28.pojo.User;
import demo28.utils.HibernateUtil;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;



public class MyTest {
    Session session = null;
    @Before
    public void setup(){
        session = HibernateUtil.getSession();
    }

    @After
    public void teardown(){
        HibernateUtil.closeSession();
    }

    @org.junit.Test
    public void initDB(){
        Transaction tx = session.beginTransaction();
        try{
           User user = new User();
           user.setName("张学友");
           user.setAge(53);
           session.save(user);
           tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }


    @org.junit.Test
    public void testOptimistic(){
        User user1 = session.get(User.class,1);
            //修改了HibernateUtil，每次产生新的session,及新的线程
            Session s2 = HibernateUtil.getSession();
            User user2 = s2.get(User.class,1);
            user2.setAge(30);
            s2.beginTransaction();
            s2.update(user2);
            s2.getTransaction().commit();
        user1.setAge(20);
        session.beginTransaction();
        session.update(user1);
        session.getTransaction().commit();
    }

    @org.junit.Test
    public void testPessimistic(){
        User user1 = session.get(User.class,1, LockOptions.UPGRADE);
            //修改了HibernateUtil，每次产生新的session,及新的线程
            Session s2 = HibernateUtil.getSession();
            User user2 = s2.get(User.class,1);
            user2.setAge(10);
            //整个进程卡在这里，因为s2的事务在等着session中事务提交完，才能继续运行，但是此时，session的事务提交在最后才能执行
            s2.beginTransaction();
            s2.update(user2);
            s2.getTransaction().commit();
        session.getTransaction().commit();
    }
    @org.junit.Test
    public void testLoad(){

    }

    @org.junit.Test
    public void testGetStudent(){

    }

    @org.junit.Test
    public void testGetClz(){

    }
}
