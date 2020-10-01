package demo14.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static Configuration cfg = null;
    private static ServiceRegistry serviceRegistry = null;
    private static SessionFactory factory = null;
    private static ThreadLocal<Session> sessionLocal = null;

    static {
        cfg = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder()
                              .applySettings(cfg.getProperties())
                              .build();
        //sessionFactory是一个重量级对象，在一个应用中只需一个就好，是一个进程级别的变量，操作完不要释放掉，即不要close
        //session是线程级别的
        //factory = cfg.buildSessionFactory(serviceRegistry);
        factory = cfg.buildSessionFactory();
        sessionLocal = new ThreadLocal<>();
    }
    public static Session getSession(){
        if(sessionLocal.get()!=null && !sessionLocal.get().isOpen()){
            sessionLocal.set(null);
        }
        if(sessionLocal.get() == null){

            sessionLocal.set( factory.openSession());
        }
        return sessionLocal.get();
    }

    public static void closeSession(){
        if(sessionLocal.get()!=null){
            sessionLocal.get().close();
        }
        sessionLocal.set(null);
    }
}
