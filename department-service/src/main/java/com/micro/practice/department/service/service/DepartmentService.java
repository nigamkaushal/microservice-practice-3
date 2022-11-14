package com.micro.practice.department.service.service;

import com.micro.practice.department.service.entity.Department;
import com.micro.practice.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department get(long id) {
        log.info("Inside getDepartment of DepartmentService");
        return departmentRepository.findById(id).get();
    }
}
