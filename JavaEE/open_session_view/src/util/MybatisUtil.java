package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    //factory实例化的过程是一个比较耗费性能的过程
    //保证有且只有一个工厂即可
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> sessionThreadLocal = new ThreadLocal<>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        if(sessionThreadLocal.get() == null) {
            SqlSession session = factory.openSession();
            sessionThreadLocal.set(session);
        }
        return sessionThreadLocal.get();
    }

    public static void closeSession(){
        SqlSession session = sessionThreadLocal.get();
        if(session != null)
            session.close();
        sessionThreadLocal.set(null);
    }
}
