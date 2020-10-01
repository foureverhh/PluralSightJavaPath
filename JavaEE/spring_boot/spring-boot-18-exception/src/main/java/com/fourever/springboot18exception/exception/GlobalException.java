package com.fourever.springboot17exception.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

//@Configuration spring boot 会将其作为配置信息加载，凡是有@Bean的都会被加载
@Configuration
public class GlobalException {
    /*
    * 该方法必须要有返回值，返回值类型必须是：SimpleMappingExceptionResolver
    * */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        /*
        * 设置异常与视图的映射关系
        * 参数一：异常的类型，必须是异常类型的全名
        * 参数二：相应异常发生，跳转至的视图名称
        * */
        mappings.put("java.lang.ArithmeticException","errorArithmetic");
        mappings.put("java.lang.NullPointerException","nullPointerError");
        resolver.setExceptionMappings(mappings);
        return resolver;
    }
}
