import demo25.pojo.Clz;
import demo25.pojo.Student;
import demo25.pojo.User;
import demo25.utils.HibernateUtil;
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
    public void getTest(){
        //get为即时加载，即立即到数据库中查询，获取数据时，如果不存在，则返回null
        User user = session.get(User.class, 1);
        System.out.println(user.getName());
        user = session.get(User.class, 10);
        System.out.println(user);
        //list()方法也为即时加载，即立即到数据库中查询，获取数据时，如果不存在，则返回null
        List<User> users = session.getNamedQuery("findAll").list();
        System.out.println(users.size());
    }

    @org.junit.Test
    public void testLoad(){
        User user = session.load(User.class,1);
        System.out.println(user.getId());
        System.out.println("----------");
        //此时才去数据库查询
        System.out.println(user.getName());
    }

    @org.junit.Test
    public void testGetStudent(){
        Student stu = session.get(Student.class,1);
        System.out.println(stu.getName() + ", " + stu.getAge());
        System.out.println("---------------------------------");
        System.out.println("Clz: " + stu.getClz());
    }

    @org.junit.Test
    public void testGetClz(){
        Clz clz = session.get(Clz.class,1);
        //clz.getStudents();
        System.out.println("--------extra lazy demo---------");
        System.out.println(clz.getStudents().size());
        System.out.println("--------我是懒加载-----------");
        for (Student s: clz.getStudents()) {
            System.out.println(s.getName());
        }
    }
}
