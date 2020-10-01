package com.foureverhh.service;

import com.foureverhh.pojo.PageInfo;

public interface StudentService {
    PageInfo showPage(String sName,String tName,String pageSize, String pageNumber);
}
