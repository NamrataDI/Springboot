package com.springboot.employee.service;

import com.springboot.employee.client.DepartmentClient;
import com.springboot.employee.entity.Department;
import com.springboot.employee.entity.Employee;
import com.springboot.employee.entity.ResponseVo;
import com.springboot.employee.reporsitory.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentClient departmmentClient;

    public List<Employee> saveEmployees(List<Employee> employeeList) {
        return employeeRepository.saveAll(employeeList);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public ResponseVo getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseGet(() -> new Employee(0L, "Default",0.0, 0L));
        Department department = departmmentClient.getDepartment(employee.getDepartmentId());

        ResponseVo responseVo = new ResponseVo(employee,department);
        return responseVo;
    }


}
