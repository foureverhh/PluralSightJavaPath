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
        //JDK动态代理，instance为基于LogMapper.class的proxy为实现类的实例
    /*    LogMapper logMapper = session.getMapper(LogMapper.class);
        List<Log> logList = logMapper.selectAll();
        for(Log log : logList){
            System.out.println(log);
        }*/


        LogMapper logMapper = session.getMapper(LogMapper.class);
       /* List<Log> list = new ArrayList<>();
        list = logMapper.selectByAccInAccOut("3","1");
        for(Log log : list){
            System.out.println(log);
        }*/
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("receiver account no.");
        String accIn = input.nextLine();
        System.out.println("sender account no.");
        String accOut = input.nextLine();
        /*System.out.println("first ends");
        System.out.println("----------");
        list = logMapper.selectByAccInAndAccOut(accIn,accOut);
        for(Log log : list){
            System.out.println(log);
        }
        System.out.println("second ends");*/

     /*   Log log = new Log();
        log.setId(1);
        log.setAccOut(accOut);
        log.setAccIn(accIn);
        System.out.println("update result: " + logMapper.upd(log));
        session.commit();*/

      /*  List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(logMapper.selIn(list));*/
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <10000 ; i++) {
            list.add(i);
        }
        System.out.println(logMapper.ins(list));
        session.commit();
        session.close();

    }
}
