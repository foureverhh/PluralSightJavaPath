
import demo17.pojo.Result;
import demo17.utils.HibernateUtil;
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
            Result r = new Result();
            r.setStuId(1);
            r.setSubId(1);
            r.setScore(70);
            session.save(r);
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
        Result r = new Result();
        r.setSubId(1);
        r.setStuId(1);
        //r为被序列化的带有id信息得Result instance
        Result result = session.get(Result.class,r);
        System.out.println(result.getScore());

    }
}
