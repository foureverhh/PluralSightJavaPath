package com.foureverhh.test;


import com.foureverhh.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
    public static void main(String[] args) {
        //1.读取hibernate.cfg.xml配置文件
        Configuration cfg = new Configuration().configure();
        //2.创建服务注册
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                       .applySettings(cfg.getProperties())
                                       .build();
        //3.新建SessionFactory对象
        SessionFactory factory = cfg.buildSessionFactory();
        //4.创建session对象
        Session session = factory.openSession();
        //5.获取数据
        User user = session.get(User.class,1);
        System.out.println(user);
        //释放资源
        session.close();
        factory.close();
    }
}
