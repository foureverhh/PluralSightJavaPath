package demo05.test;


import demo05.pojo.User;
import demo05.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTest05 {
    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
      /*
            //insert user
            User user = new User();
            user.setName("郭富城");
            user.setAge(50);
            //保存数据
            session.save(user);
            */

            /*
            //查询user
            User user = session.get(User.class,2);
            */
            //提交事务

            //update user,更改id为2的user年龄为54
            User user = session.get(User.class,2);
            user.setAge(54);
            session.save(user);
            tx.commit();
            user = session.get(User.class,2);
            System.out.println(user);
        }catch (Exception e){
            if(tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        }finally {
            HibernateUtil.closeSession();
        }

     /*   //1.读取hibernate.cfg.xml配置文件
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
        //显示id为1的user
        User user = session.get(User.class,1);
        System.out.println(user);
        //释放资源
        session.close();
        factory.close();*/
    }
}
