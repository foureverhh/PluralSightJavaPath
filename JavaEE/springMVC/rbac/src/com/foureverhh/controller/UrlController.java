package com.foureverhh.controller;

import com.foureverhh.pojo.Url;
import com.foureverhh.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UrlController {
    @Resource
    private UrlService urlServiceImpl;
    @RequestMapping("/showAllUrl")
    public String showAll(HttpSession session){
        List<Url> allUrl = urlServiceImpl.showAll();
        session.setAttribute("allUrl",allUrl);
        return "redirect:/main.jsp";
    }

}
