package com.foureverhh.service.impl;

import com.foureverhh.mapper.FilesMapper;
import com.foureverhh.pojo.Client;
import com.foureverhh.pojo.Files;
import com.foureverhh.service.FilesService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FilesServiceImpl implements FilesService {
    @Resource
    private FilesMapper filesMapper;
    @Override
    public List<Files> showAll() {
        return filesMapper.selAllFiles();
    }

    @Override
    public int updCount(int id, Client client,String fileName) {
        Logger logger = Logger.getLogger(FilesServiceImpl.class);
        logger.info(client.getUsername()+"下载了"+fileName);
       return filesMapper.updCountById(id);
    }
}
