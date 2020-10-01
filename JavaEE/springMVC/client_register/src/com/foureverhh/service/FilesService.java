package com.foureverhh.service;

import com.foureverhh.pojo.Client;
import com.foureverhh.pojo.Files;

import java.util.List;

public interface FilesService {
    //显示全部
    List<Files> showAll();
    //更新id,更新下载次数
    int updCount(int id, Client client,String fileName);
}
