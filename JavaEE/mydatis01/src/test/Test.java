package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Flower;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
            //工厂设计模式
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            session = factory.openSession();

            List<Flower> list= session.selectList("a.b.selectAll");
            for(Flower f: list){
                System.out.println(f);
            }
            Flower flower = session.selectOne("a.b.selectById");
            System.out.println("session.selectOne()->" + flower);
            System.out.println("\n");

            int count = session.selectOne("a.b.countAll");
            System.out.println("There are " + count + " kinds of flowers.");
            System.out.println("\n");

            //把数据库中某个列的值当做map的key
            Map<Object,Object> map = session.selectMap("a.b.c","name");
            for(Map.Entry<Object,Object> entry: map.entrySet()){
                System.out.println(entry.getKey() + " ->" + entry.getValue());
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
