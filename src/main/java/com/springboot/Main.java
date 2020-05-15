package com.springboot;

import com.springboot.controller.UserController;
import com.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.applet.AppletContext;
@EnableCaching
@SpringBootApplication
public class Main {
    @Autowired
    public UserServiceImpl userServiceImpl;

    public static void main(String[] args) {

        ApplicationContext cxt = SpringApplication.run(Main.class, args);
        UserController userController = cxt.getBean(UserController.class);

        System.out.println(userController.getUser(1));

        System.out.println(userController.removeUser(3));

    }
}
