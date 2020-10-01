package com.foureverhh.test;


import com.foureverhh.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest02 {
    public static void main(String[] args) {
        //1.读取hibernate.cfg.xml配置文件
        Configuration cfg = new Configuration().configure();
        //2.hibernate4.X 创建服务注册
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                       .applySettings(cfg.getProperties())
                                       .build();
        //3.hibernate4.X 新建SessionFactory对象
        //SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
        SessionFactory factory = cfg.buildSessionFactory();
        //生成一个注册机对象
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        //使用注册机机对象serviceRegistry创建sessionFactory
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        //4.创建session对象
        //Session session = factory.openSession();
         //hibernate 5.0 创建session对象
        Session session = sessionFactory.openSession();
        //5.获取数据
        //显示id为1的user
        User user = session.get(User.class,1);
        System.out.println(user);
        //释放资源
        session.close();
        factory.close();
    }
}
