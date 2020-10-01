package com.foureverhh.demo.controller;

import com.foureverhh.demo.pojo.User;
import com.foureverhh.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @RequestMapping("/regis")
    public String insertDemo(User user, Model model){
        System.out.println(user.getUsername() + "， " + user.getPassword());
        int result = userServiceImpl.insertUser(user);
        model.addAttribute("msg",result);
        model.addAttribute("user",user);
        return "main";
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public List<User> showAllDemo(){
        List<User> users = userServiceImpl.showAll();
        return users;
    }

    @RequestMapping("/findUserById")
    public String findUserById(Integer id,Model model){
        User user = userServiceImpl.findUserById(id);
        if(user != null){
            model.addAttribute("targetUser",user);
        }
        return "updateUser";
    }

    @RequestMapping("/editUser")
    public String editUser(User user,Model model){
        int result = userServiceImpl.updateUser(user);
        User editedUser;
        if(result != 0) {
            editedUser = userServiceImpl.findUserById(user.getId());
            model.addAttribute("editedUser",editedUser);
        }
        return "ok";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUser(Integer id){
        int result = userServiceImpl.deleteUserById(id);
        if(result != 0) {
            return "ok";
        }
       return "error";
    }
}
