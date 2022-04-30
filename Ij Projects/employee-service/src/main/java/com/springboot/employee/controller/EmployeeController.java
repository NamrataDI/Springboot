package com.springboot.employee.controller;

import com.springboot.employee.entity.Employee;
import com.springboot.employee.entity.ResponseVo;
import com.springboot.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseVo getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/all")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employeeList){
        return employeeService.saveEmployees(employeeList);
    }

}
