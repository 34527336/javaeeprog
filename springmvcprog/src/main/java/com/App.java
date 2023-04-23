package com;

import com.config.SpringConfig;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        System.out.println(userService.getById(2));

    }
}
