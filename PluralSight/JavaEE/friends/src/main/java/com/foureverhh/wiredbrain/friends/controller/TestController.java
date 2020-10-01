package com.foureverhh.wiredbrain.friends.controller;

import com.foureverhh.wiredbrain.friends.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private FriendService friendService;
    @Autowired
    public TestController(FriendService friendService) {
        this.friendService = friendService;
    }
    @RequestMapping("/friends/{id}")
    public String findById(@PathVariable int id, Model model){
        model.addAttribute("friend",friendService.findById(id));
        return "index";
    }
}
