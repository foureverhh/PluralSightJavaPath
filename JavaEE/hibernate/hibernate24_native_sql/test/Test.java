import demo24.pojo.Clz;
import demo24.pojo.Student;
import demo24.pojo.User;
import demo24.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;

import java.util.List;


public class Test {
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
            User u1 = new User();
            User u2 = new User();
            User u3 = new User();
            User u4 = new User();
            u1.setName("张三");
            u2.setName("李四");
            u3.setName("王五");
            u4.setName("赵六");
            u1.setAge(12);
            u2.setAge(23);
            u3.setAge(33);
            u4.setAge(45);
            session.save(u1);
            session.save(u2);
            session.save(u3);
            session.save(u4);
            Clz c1 = new Clz();
            c1.setName("208");
            c1.setAddress("B-2");
            Clz c2 = new Clz();
            c2.setName("301");
            c2.setAddress("B-3");
            session.save(c1);
            session.save(c2);
            Student s1 = new Student();
            s1.setName("张三");
            s1.setAge(23);
            s1.setSex("男");
            //设置学生的外键，如果不设置则没有外键值
            s1.setClz(c1);
            Student s2 = new Student();
            s2.setName("李四");
            s2.setAge(22);
            s2.setSex("男");
            s2.setClz(c2);
            Student s3 = new Student();
            s3.setName("王小蒙");
            s3.setAge(20);
            s3.setSex("女");
            s3.setClz(c1);
            session.save(s1);
            session.save(s2);
            session.save(s3);
           tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    @org.junit.Test
    public void testFindAll(){
        Transaction tx = session.beginTransaction();
        try{
            String sql = "select * from t_user_24";
            List<Object[]> users = (List<Object[]>) session.createSQLQuery(sql).list();
            for (Object[] u: users) {
                System.out.println(u[0] + ", " + u[1] + ", " + u[2]);
            }
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    @org.junit.Test
    public void testFindAll2Object(){
        Transaction tx = session.beginTransaction();
        try{
            String sql = "select * from t_user_24";
            List<User> users = (List<User>) session.createSQLQuery(sql).addEntity(User.class).list();
            for (User u: users) {
                System.out.println(u.getId() + ", " + u.getName()+ ", " + u.getAge());
            }
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    @org.junit.Test
    public void testPage(){
        Transaction tx = session.beginTransaction();
        try{
            String sql = "select * from t_user_24";
            List<User> users = (List<User>) session
                                            .createSQLQuery(sql)
                                            .addEntity(User.class)
                                            //(currentPage -1) * pageSize
                                            .setFirstResult(2)
                                            //pageSize
                                            .setMaxResults(2)
                                            .list();
            for (User u: users) {
                System.out.println(u.getId() + ", " + u.getName()+ ", " + u.getAge());
            }
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
        }
    }


    @org.junit.Test
    public void queryCondition(){
        String sql = "select * from t_user_24 where age > 25";
        List<User> users = session.createSQLQuery(sql).addEntity(User.class).list();
        for (User u: users) {
            System.out.println(u.getName() + ", " + u.getAge());
        }
    }

    //带参数的条件查询
    @org.junit.Test
    public void testCondition2() {
        String sql = "select * from t_user_24 where age > :queryAge";
        List<User> users = session.createSQLQuery(sql).setParameter("queryAge",25).addEntity(User.class).list();
        for (User u: users) {
            System.out.println(u.getName() + ", " + u.getAge());
        }
    }

    //xml 命名查询
    @org.junit.Test
    public void testNamedQuery(){
        List<Object[]> users =   session.getNamedNativeQuery("findUsers").list();
        for (Object[] u: users) {
            System.out.println(u[0] + ", " + u[1] + ", " + u[2]);
        }
    }

    // test filter
    @org.junit.Test
    public void testFilter(){
         session.enableFilter("userFilter").setParameter("age",30);
         List<User> users = session.createQuery("from User").list();
        for (User u: users) {
            System.out.println(u.getName() + ", " + u.getAge());
        }
    }
}
