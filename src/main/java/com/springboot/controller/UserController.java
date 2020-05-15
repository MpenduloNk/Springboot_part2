package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Component
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

//    @RequestMapping(method =  RequestMethod.GET)
    @RequestMapping(value="/all",method = RequestMethod.GET )
    public Collection<User> getALLUsers(){
        return this.userServiceImpl.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") int id){
        return this.userServiceImpl.findUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteUserById(@PathVariable("id") int id){
        return this.userServiceImpl.deleteUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user){
        userServiceImpl.insertUser(user);
    }

   @Cacheable("name")
    public String getUser(int id) {
        User user = userServiceImpl.findUserById(id);
        String name = user.getName();
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return "Hello "+ name;
    }

    public String removeUser(int id){
        User user = userServiceImpl.deleteUserById(id);
        String name = user.getName();
        return name + " removed";
    }

//    public String addUser(User s){
//        User user = userService.insertUser(s.setName("Nathi"));
//        String name = user.getName();
//        return name + " entered";
//    }
}
