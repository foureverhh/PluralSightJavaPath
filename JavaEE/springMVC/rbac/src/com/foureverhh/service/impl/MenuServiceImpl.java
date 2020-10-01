package com.foureverhh.service.impl;

import com.foureverhh.mapper.MenuMapper;
import com.foureverhh.pojo.Menu;
import com.foureverhh.pojo.User;
import com.foureverhh.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> showMenu(int rid) {
        System.out.println("showMenu -> " + rid);
        return menuMapper.selMenuByRid(rid,0);
    }
}
