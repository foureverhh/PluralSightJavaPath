package service;

import pojo.Log;
import pojo.PageInfo;

import java.io.IOException;

public interface MyLogService{
    PageInfo showPage(int pageNumber, int pageSize) throws IOException;
    int ins(Log log);
}
