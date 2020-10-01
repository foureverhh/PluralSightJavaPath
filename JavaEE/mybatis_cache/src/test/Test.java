package test;

import mapper.LogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        List<Log> list = session.selectList("mapper.LogMapper.selectAll");
        System.out.println("Round 1 -> " + list.size());
        list = session.selectList("mapper.LogMapper.selectAll");
        System.out.println("Round 2 -> " + list.size());
        //commit（）和close()以后，sqlsession缓存内容转至sqlsessionfactory的二级缓存
        session.commit();
        session.close();

        SqlSession session1 = factory.openSession();
        list = session1.selectList("mapper.LogMapper.selectAll");
        System.out.println("Round 1 -> " + list.size());
        list = session1.selectList("mapper.LogMapper.selectAll");
        System.out.println("Round 2 -> " + list.size());
        session1.commit();
        session1.close();

        System.out.println("query finished!");
    }
}
