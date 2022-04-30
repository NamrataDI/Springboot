package com.springboot.employee.client;

import com.springboot.employee.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DepartmentClient {

    @Autowired
    private RestTemplate restTemplate;


    public Department getDepartment(Long id){
        return restTemplate.getForObject("http://localhost:9002/departments/"+id,Department.class);
    }
}
