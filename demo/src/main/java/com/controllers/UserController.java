package com.controllers;

import com.model.City;
import com.model.User;
import com.services.UserService;
import com.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by inastase on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/id", method = RequestMethod.GET)
//    public User getUser(@PathVariable Long id){
//        return userService.findOne(id);
//    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.findAll();
    }

//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    public List<City> updateCity(@PathVariable String name){
//        User user = userService.findByName(name);
//        return user.getCities();
//    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public List<City> updateUserCity(@RequestBody City city,@PathVariable String name){
        userService.updateCities(city, name);
        User user = userService.findByName(name);
        return user.getCities();
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.PUT)
    public User addUser(@RequestBody User newUser){
        userService.save(newUser);
        User user = userService.findByName(newUser.getName());
        return user;
    }


}
