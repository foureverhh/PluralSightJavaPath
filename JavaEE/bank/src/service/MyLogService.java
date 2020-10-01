package service;

import pojo.PageInfo;

import java.io.IOException;

public interface MyLogService{
    PageInfo showPage(int pageNumber, int pageSize) throws IOException;
}
