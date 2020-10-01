package com.foureverhh.controller;

import com.foureverhh.pojo.Menu;
import com.foureverhh.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MenuController {
    //spring mvc容器调用spring容器中的内容
    @Resource
    private MenuService menuServiceImpl;

    @RequestMapping("/showMenu")
    @ResponseBody
    public List<Menu> show(){
        return menuServiceImpl.showAllMenu();
    }

    @RequestMapping("/m")
    public String toMain(){

        return "main";
    }
}
