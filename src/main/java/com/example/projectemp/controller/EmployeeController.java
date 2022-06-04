package com.example.projectemp.controller;

import com.example.projectemp.entity.Employee;
import com.example.projectemp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee>  addEmployee(@RequestBody Employee employee) {
              Employee employee1=employeeService.addEmployee(employee);
     return new ResponseEntity<Employee>(employee1, HttpStatus.CREATED);


    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> allEmployee(){

        return new ResponseEntity(employeeService.findAllEmployee(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id).get(),HttpStatus.OK);


    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id){

        return new ResponseEntity<Employee>(employeeService.updateEmployeeById(id,employee),HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> updateEmployee( @PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);

    }


}