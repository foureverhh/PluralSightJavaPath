package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    //一个项目只有一个SqlSessionFactory
    private static SqlSessionFactory factory;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        if(threadLocal.get() == null){
            threadLocal.set(factory.openSession());
        }
        return threadLocal.get();
    }

    public static void closeSession(){
        if(threadLocal.get() != null){
            threadLocal.get().close();
        }
        threadLocal.set(null);
    }
}
