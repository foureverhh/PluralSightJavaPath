package service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Log;
import pojo.PageInfo;
import service.MyLogService;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServiceImpl implements MyLogService {
    @Override
    public PageInfo showPage(int pageNumber, int pageSize) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        Map<String,Integer> map = new HashMap<>();
        map.put("pageStart",pageSize * (pageNumber-1));
        map.put("pageSize",pageSize);
        List<Log> logList = session.selectList("com.logMapper.selectByPage",map);
        long count = session.selectOne("com.logMapper.selectCount");
        long totalPages =(long) Math.ceil(count/pageSize);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(logList);
        pageInfo.setTotalPages(totalPages);
        return pageInfo;
    }
}
