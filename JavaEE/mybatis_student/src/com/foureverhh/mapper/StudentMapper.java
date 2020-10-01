package com.foureverhh.mapper;

import com.foureverhh.pojo.PageInfo;
import com.foureverhh.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selByPage(PageInfo pageInfo);
    long selCountByPageInfo(PageInfo pageInfo);
 }
