package demo10;

import demo10.pojo.Card;
import demo10.pojo.Person;
import demo10.utils.HibernateUtil;
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

import java.util.EnumSet;

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
    public void createDB(){
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties())
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
    }

    @org.junit.Test
    public void testInit(){
        Transaction tx = session.beginTransaction();
        try{
            Card c1 = new Card();
            c1.setAddress("北京昌平");
            c1.setName("张三");
            Card c2 = new Card();
            c2.setAddress("北京海淀");
            c2.setName("李四");
            Person p1 = new Person();
            p1.setName("张三");
            p1.setSex("男");
            p1.setCard(c1);
            Person p2 = new Person();
            p2.setName("李四");
            p2.setSex("男");
            p2.setCard(c2);
            session.save(c1);
            session.save(c2);
            session.save(p1);
            session.save(p2);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
    }

    @org.junit.Test
    public void testGet(){
        Person p = session.get(Person.class,1);
        System.out.println(p.getName() + ", " + p.getCard().getAddress());
    }
}
