package com.foureverhh.service.impl;

import com.foureverhh.mapper.ElementMapper;
import com.foureverhh.pojo.Element;
import com.foureverhh.service.ElementService;
import com.foureverhh.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElementServiceImpl implements ElementService {
    @Resource
    private ElementMapper elementMapper;

    @Override
    public List<Element> selByRid(int id) {
        return elementMapper.selByRid(id);
    }
}
