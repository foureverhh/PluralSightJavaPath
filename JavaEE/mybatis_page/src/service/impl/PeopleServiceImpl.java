package service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.PageInfo;
import pojo.People;
import service.PeopleService;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleServiceImpl implements PeopleService {
    public List<People> selectPage(int pageStart, int pageSize) throws IOException {
        List<People> people = null;
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        Map<String,Integer> map = new HashMap<>();
        map.put("pageStart",pageSize*(pageStart-1));
        map.put("pageSize",pageSize);
        try {
            people = session.selectList("com.mybatis.selectPage", map);
        }catch (Exception e){
            session.rollback();
        }
        session.commit();
        session.close();
        return people;
    }

    @Override
    public PageInfo showPage(int pageNumber,int pageSize) throws IOException {
        //建立mybatis，mysql，session
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNumber);
        long allItems = session.selectOne("com.mybatis.selectCount");
        pageInfo.setTotal((long) Math.ceil(allItems/pageNumber));
        Map<String,Integer> map = new HashMap<>();
        map.put("pageStart",pageSize * (pageNumber-1));
        map.put("pageSize",pageSize);
        List<People> list = session.selectList("com.mybatis.selectByPage",map);

        System.out.println(list);

        pageInfo.setCurrentList(list);
        session.close();
        return pageInfo;
    }
}
