package com.foureverhh.study.springbootssojwt.controller;

import com.foureverhh.study.springbootssojwt.commons.JWTResponseData;
import com.foureverhh.study.springbootssojwt.commons.JWTResult;
import com.foureverhh.study.springbootssojwt.commons.JWTUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JWTController {
    @RequestMapping("/testAll")
    @ResponseBody
    public Object testAll(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWTResult result = JWTUtis.validateJWT(token);

        JWTResponseData responseData = new JWTResponseData();
        if(result.isSuccess()){
            responseData.setCode(200);
            responseData.setData(result.getClaims().getSubject);
            String newToken = JWTUtils.createJWT(result.getClaims().getId(),
                                                    result.getClaims().getIssuer(),
                                                    result.getClaims().getSubject(),
                                                    1*60*1000);
            responseData.setToken(newToken);
            return responseData;
        }else {
            responseData.setCode(500);
            responseData.setMsg("用户未登录");
            return responseData;
        }
    }
}
