package com.learningSpring.userservice.service;

import com.learningSpring.userservice.entity.Department;
import com.learningSpring.userservice.entity.ResponseTemplateVo;
import com.learningSpring.userservice.entity.User;
import com.learningSpring.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");

        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(long userId) {
        log.info("Inside  getUserWithDepartment method of UserService");
        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId() , Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
