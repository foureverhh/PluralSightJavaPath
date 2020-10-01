package service.impl;

import com.logMapper.LogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Log;
import pojo.PageInfo;
import service.MyLogService;
import util.MybatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServiceImpl implements MyLogService {

    @Override
    public PageInfo showPage(int pageNumber, int pageSize) throws IOException {
        //使用filter中的threadlocal中的session替代

       /* InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();*/
        SqlSession session = MybatisUtil.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
       /* Map<String,Integer> map = new HashMap<>();
        map.put("pageStart",pageSize * (pageNumber-1));
        map.put("pageSize",pageSize);
        List<Log> logList = session.selectList("com.logMapper.selectByPage",map);
        long count = session.selectOne("com.logMapper.selectCount");*/
        int pageStart = pageSize * (pageNumber-1);
        List<Log> logList = mapper.selectByPage(pageStart,pageSize);
        long count = mapper.selectCount();
        long totalPages =(long) Math.ceil(count/pageSize);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(logList);
        pageInfo.setTotalPages(totalPages);
        return pageInfo;
    }


    @Override
    public int ins(Log log) {
        SqlSession session = MybatisUtil.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        return mapper.insLog(log);
    }
}
