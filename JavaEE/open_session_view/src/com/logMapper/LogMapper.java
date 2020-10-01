package com.logMapper;

import org.apache.ibatis.annotations.Param;
import pojo.Log;

import java.util.List;

public interface LogMapper {
    int insLog(Log log);
    List<Log> selectByPage(@Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
    long selectCount();
}
