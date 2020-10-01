package com.foureverhh.service.impl;

import com.foureverhh.mapper.UserMapper;
import com.foureverhh.pojo.User;
import com.foureverhh.service.ElementService;
import com.foureverhh.service.MenuService;
import com.foureverhh.service.UrlService;
import com.foureverhh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ElementService elementServiceImpl;
    @Resource
    private MenuService menuServiceImpl;
    @Resource
    private UrlService urlServiceImpl;
    @Override
    public User login(User user) {
        //User currentUser = userMapper.selByUser(user);
        User currentUser = userMapper.selUser(user);
        if(currentUser != null){
            int rid = currentUser.getRid();
            System.out.println("Rid -> " + rid);
            System.out.println("Rid " + rid + " menu -> " + menuServiceImpl.showMenu(rid));
            currentUser.setMenus(menuServiceImpl.showMenu(rid));
            System.out.println("Rid " + rid + " element -> " + elementServiceImpl.selByRid(rid));
            currentUser.setElements(elementServiceImpl.selByRid(rid));
            currentUser.setUrls(urlServiceImpl.selbyRid(rid));
        }
        return currentUser;
    }

    @Override
    public Map<String, Object> loginMap(User user) {
        Map<String,Object> map = new HashMap<>();
        User currentUser = userMapper.selUser(user);
        if(currentUser!=null){
            int rid = currentUser.getRid();
            currentUser.setMenus(menuServiceImpl.showMenu(rid));
            currentUser.setElements(elementServiceImpl.selByRid(rid));
            currentUser.setUrls(urlServiceImpl.selbyRid(rid));
            map.put("user",currentUser);
        }
        map.put("allUrl",urlServiceImpl.showAll());
        return map;
    }

 /*   @Override
    public User myLogin(User user) {
        User currentUser = userMapper.selUser(user);
        if(currentUser!=null){
            currentUser.setMenus(menuServiceImpl.showMenu(currentUser.getRid()));
        }
        return currentUser;
    }*/


}
