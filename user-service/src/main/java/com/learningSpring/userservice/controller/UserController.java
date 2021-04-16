package com.learningSpring.userservice.controller;

import com.learningSpring.userservice.entity.Department;
import com.learningSpring.userservice.entity.ResponseTemplateVo;
import com.learningSpring.userservice.entity.User;
import com.learningSpring.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser (@RequestBody User user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment (@PathVariable("id") long userId ){
        log.info("Inside getUserWithDepartment method of UserController ");
        return userService.getUserWithDepartment(userId);
    }




}
