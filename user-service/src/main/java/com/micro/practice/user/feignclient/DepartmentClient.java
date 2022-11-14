package com.micro.practice.user.feignclient;

import com.micro.practice.user.vo.Department;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//http://DEPARTMENT-SERVICE/department/id
@FeignClient(name = "DEPARTMENT-SERVICE", path = "/department")
@LoadBalancerClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {
    @GetMapping("/{id}")
    Department getDepartmentById(@PathVariable long id);
}
