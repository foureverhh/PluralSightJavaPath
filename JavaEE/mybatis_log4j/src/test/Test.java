package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import pojo.People;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        Logger logger = Logger.getLogger(Test.class);

    /*    List<People> people = session.selectList("com.peopleMapper.selectAll");
        logger.info("people -> " + people);

        People idOne = session.selectOne("com.peopleMapper.selectIdOne");
        logger.info("people id=1  -> " + idOne);

        People p = session.selectOne("com.peopleMapper.selectById",2);
        logger.info("people id=2  -> " + p);

        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","张三");*/

/*        p = session.selectOne("com.peopleMapper.selectByMapId",map);
        logger.info("people selectByMapId -> " + p);*/

        /*p = session.selectOne("com.peopleMapper.selectByName",map);
        logger.info("people selectByName-> " + p);*/

  /*      //每页显示几个
        int pageSize = 3;
        //显示第几页的
        int pageNumber = 2;
        Map<String,Object> paginationMap = new HashMap<>();
        paginationMap.put("pageSize",pageSize);
        paginationMap.put("pageStart",pageSize*(pageNumber-1));

        people = session.selectList("com.peopleMapper.pagination",paginationMap);
        logger.info("Pagination page " + pageNumber +" people -> " + people);*/

        People newP = new People();
        newP.setName("赵四2");
        newP.setAge(23);
        int insertResult = -1;
        insertResult = session.insert("com.peopleMapper.insertNew",newP);
        logger.info("Insert result: " + insertResult);
        newP.setName("赵四3");

        insertResult = session.insert("com.peopleMapper.insertNew",newP);
        logger.info("Insert result: " + insertResult);
        session.commit();
        session.close();
    }
}
