package com.foureverhh.controller;

import com.foureverhh.pojo.Menu;
import com.foureverhh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @RequestMapping("getMenu")
    @ResponseBody
    public List<Menu> getMenu(HttpSession session){
        User user = (User) session.getAttribute("user");
        return user.getMenus();

    }
}
