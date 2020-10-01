package com.foureverhh.service.impl;

import com.foureverhh.mapper.URLMapper;
import com.foureverhh.pojo.Url;
import com.foureverhh.service.UrlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UrlServiceImpl implements UrlService {
    @Resource
    private URLMapper urlMapper;
    @Override
    public List<Url> selbyRid(int rid) {
        return urlMapper.selByRid(rid);
    }

    @Override
    public List<Url> showAll() {
        return urlMapper.selAll();
    }


}
