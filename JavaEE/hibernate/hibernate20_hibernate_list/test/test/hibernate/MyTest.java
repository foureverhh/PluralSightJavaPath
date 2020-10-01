package test.hibernate;

import demo20.pojo.Clz;
import demo20.pojo.Student;
import demo20.utils.HibernateUtil;
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
    Session session = null;
    @Before
    public void setup(){
        session = HibernateUtil.getSession();
    }

    @After
    public void teardown(){
        HibernateUtil.closeSession();
    }

    @Test
    public void createDB(){
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                        .applySettings(cfg.getProperties())
                                                        .build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
    }

    //一对多关联时，会多出n条更新语句
    //因为构建一的一端时，会给多的那一方添加外键
    @Test
    public void testInit(){
        Transaction tx = session.beginTransaction();
        try{

            Student s1 = new Student();
            s1.setName("张三");
            s1.setAge(23);
            s1.setSex("男");
            //设置学生的外键，如果不设置则没有外键值
            //s1.setClz(c1);
            Student s2 = new Student();
            s2.setName("李四");
            s2.setAge(22);
            s2.setSex("男");
            //s2.setClz(c2);
            Student s3 = new Student();
            s3.setName("王小蒙");
            s3.setAge(20);
            s3.setSex("女");
            //s3.setClz(c1);
            session.save(s1);
            session.save(s2);
            session.save(s3);
            Clz c1 = new Clz();
            c1.setName("208");
            c1.setAddress("B-2");
            //关联关系由一的方面的控制
            c1.getStudents().add(s1);
            c1.getStudents().add(s3);
            Clz c2 = new Clz();
            c2.setName("301");
            c2.setAddress("B-3");
            c2.getStudents().add(s2);
            session.save(c1);
            session.save(c2);
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                System.out.println(e.getMessage());
                tx.rollback();
            }
        }
    }

    @Test
    public void getClz(){
        Clz clz = session.get(Clz.class,1);
        System.out.println(clz);
    }
}
