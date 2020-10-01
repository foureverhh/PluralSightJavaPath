package com.demo;

import com.foureverhh.pojo.mybatis_provide.User;
import com.foureverhh.pojo.one_to_one.Person;
import com.foureverhh.service.PersonService;
import com.foureverhh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PersonService personService = ac.getBean("personService",PersonService.class);
        List<Person> people = personService.selectPersons();
        for (Person person: people) {
            System.out.println(person);
        }

        System.out.println("----------------------");

        people = personService.selectAll();
        for (Person person: people) {
            System.out.println(person);
        }

        System.out.println("----------------------");

        UserService userService = ac.getBean("userService",UserService.class);
        User newUser = new User();
        newUser.setUsername("周星星");
        newUser.setPassword("123456");
        int insertResult = userService.insertUser(newUser);
        System.out.println("userInsert result: " + insertResult);
        System.out.println("---------------------------");
        //Map<String,List<User>> userMap = new HashMap<>();
        Map<String,Object> userMap = new HashMap<>();
        List<User> users = new ArrayList<>();
        users.add(new User("C","c"));
        users.add(new User("D","d"));
        userMap.put("users",users);
        insertResult = userService.insertBatchUser(userMap);
        System.out.println("userBatchInsert result: " + insertResult);
    }
}
