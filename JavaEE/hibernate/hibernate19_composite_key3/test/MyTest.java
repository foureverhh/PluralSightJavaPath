

import demo19.pojo.Result;
import demo19.pojo.Student;
import demo19.pojo.Subject;
import demo19.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumSet;


public class MyTest {
   private Session session = null;

    //SchemaExport 将对象转化为数据库表格
    @Test
    public void testCreateDB(){
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
    }

    @Before
    public void setUp(){
        session = HibernateUtil.getSession();
    }
    @After
    public void teardown(){
        HibernateUtil.closeSession();
    }


    @Test
    public void testInit(){
        Transaction tx = session.beginTransaction();
        try{
            Student stu1 = new Student();
            stu1.setAge(22);
            stu1.setName("张三");
            stu1.setSex("男");
            Subject sub1 = new Subject();
            sub1.setName("物理");
            session.save(stu1);
            session.save(sub1);
            Result result = new Result();
            result.setScore(70);
            result.setStudent(stu1);
            result.setSubject(sub1);
            session.save(result);
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                System.out.println(e.getMessage());
                tx.rollback();
            }
        }
    }

    //获得多的一端的信息时，可以操作一的那一端的信息拿出来
    @Test
    public void testGet(){
        //Student和Subject必须通过session来寻找，以防student和subject不存在
        Student stu = session.get(Student.class,1);
        stu.setId(1);
        Subject sub = session.get(Subject.class,1);
        sub.setId(1);
        Result r = new Result();
        r.setSubject(sub);
        r.setStudent(stu);
        Result result = session.get(Result.class,r);
        System.out.println(result.getScore());
    }
}
