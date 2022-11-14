package com.micro.practice.user.service;

import com.micro.practice.user.entity.User;
import com.micro.practice.user.feignclient.DepartmentClient;
import com.micro.practice.user.repository.UserRepository;
import com.micro.practice.user.vo.Department;
import com.micro.practice.user.vo.ResponseTemplateVO;
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

    @Autowired
    private DepartmentClient departmentClient;

    public User save(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not Found with id : " + userId));

        // Using RestTemplate
//        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(), Department.class);


        // Using FeignClient
        Department department = departmentClient.getDepartmentById(user.getDepartmentId());
        responseTemplateVO.setDepartment(department);
        responseTemplateVO.setUser(user);
        return responseTemplateVO;
    }

}
