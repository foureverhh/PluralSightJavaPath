import demo15.pojo.Permission;
import demo15.pojo.Role;
import demo15.utils.HibernateUtil;
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
import java.util.Set;

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
            Role r1 = new Role();
            r1.setName("普通用户");
            Role r2 = new Role();
            r2.setName("会员");
            Permission p1 = new Permission();
            p1.setName("用户查看");
            Permission p2 = new Permission();
            p2.setName("用户添加");
            Permission p3 = new Permission();
            p3.setName("用户删除");
            Permission p4 = new Permission();
            p4.setName("用户修改");
            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);
            //设置关系
            r1.getPermissions().add(p1);
            r1.getPermissions().add(p2);
            r2.getPermissions().add(p1);
            r2.getPermissions().add(p2);
            r2.getPermissions().add(p3);
            r2.getPermissions().add(p4);
            session.save(r1);
            session.save(r2);
            tx.commit();
        }catch (Exception e){
            if(tx!=null)
                tx.rollback();
        }
    }

    @org.junit.Test
    public void getInfo(){
        Role r = session.get(Role.class,1);
        System.out.println(r.getName() + ", permissions: ");
        Set<Permission> permissions = r.getPermissions();
        for (Permission p: permissions) {
            System.out.println(p.getName());
        }

        Permission p = session.get(Permission.class,1);
        System.out.println(p.getName() + " roles :");
        Set<Role> roles = p.getRoles();
        for (Role role: roles) {
            System.out.println(role.getName());
        }
    }
}