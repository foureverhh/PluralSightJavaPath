package demo07.test;


import demo07.pojo.Clz;
import demo07.pojo.Student;
import demo07.pojo.User;
import demo07.utils.HibernateUtil;
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
    public void testSave(){
        Transaction tx = session.beginTransaction();
        try{
            User user = new User();
            user.setName("张三");
            user.setAge(12);
            session.save(user);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    @Test
    public void testInit(){
        Transaction tx = session.beginTransaction();
        try{
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
                System.out.println(e.getMessage());
                tx.rollback();
            }
        }
    }

    //获得多的一端的信息时，可以操作一的那一端的信息拿出来
    @Test
    public void testGet(){
        //hibernate查询 d为1的student
        Student s = session.get(Student.class,1);
        System.out.println(s.getName()+ "------" + s.getAge());
        System.out.println(s.getName() + "------" + s.getClz().getName());

        Clz clz = session.get(Clz.class,1);
    }
}
