package com.foureverhh.service.impl;

import com.foureverhh.mapper.ClientMapper;
import com.foureverhh.pojo.Client;
import com.foureverhh.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientMapper clientMapper;
    @Override
    public int insRegister(Client client) {
        return clientMapper.insertClient(client);
    }
}
