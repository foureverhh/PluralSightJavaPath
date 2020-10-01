package com.foureverhh.study.springbootssojwt.commons;

import java.util.HashMap;
import java.util.Map;

/*
* 用于模拟用户数据的。开发中应访问数据库验证用户
* */
public class JWTUsers {
    private static final Map<String, String> USERS = new HashMap<>(9);
    static {
        for (int i = 0; i < 10; i++) {
            USERS.put("admin"+i,"password"+i);
        }
    }

    //用户名和密码是否匹配
    public static boolean isLogin(String username, String password){
        if( null == username || username.trim().length() == 0){
            return false;
        }
        String obj = USERS.get(username);
        return null != obj && obj.equals(password);
    }
}
