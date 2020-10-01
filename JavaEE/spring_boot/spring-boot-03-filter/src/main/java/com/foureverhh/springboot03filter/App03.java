package com.foureverhh.springboot03filter;

import com.foureverhh.springboot03filter.filter.SecondFilter;
import com.foureverhh.springboot03filter.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App03 {
    public static void main(String[] args) {
        SpringApplication.run(App03.class, args);
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
        //bean.addUrlPatterns("/secondFilter");
        bean.addUrlPatterns(new String[]{"*.do", "/secondServlet"});
        return bean;
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        //bean.addUrlPatterns("/secondFilter");
        bean.addUrlMappings("/secondServlet");
        return bean;
    }
}
