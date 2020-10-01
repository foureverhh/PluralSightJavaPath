
import demo16.pojo.Employee;
import demo16.pojo.Links;
import demo16.utils.HibernateUtil;
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
    public void init(){
        Transaction tx = session.beginTransaction();
        try{
            Links links = new Links();
            links.setPhone("18663921612");
            links.setQq("313941586");
            links.setEmail("zfgg04@163.com");
            Employee employee = new Employee();
            employee.setAge(22);
            employee.setName("张三");
            employee.setLinks(links);
            session.save(employee);
            tx.commit();
        }catch (Exception e){
            if(tx!=null)
                tx.rollback();
        }
    }

    @org.junit.Test
    public void getInfo(){
        Employee employee = session.get(Employee.class,1);
        System.out.println(employee.getLinks().getEmail());
    }
}