package com.example.projectemp.service;

import com.example.projectemp.entity.Employee;
import com.example.projectemp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private  EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;

    }


    public List<Employee> findAllEmployee(){
        List<Employee> employeeList= employeeRepository.findAll();
        return employeeList;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);


    }
    public Optional<Employee> getEmployeeById(Long id){

        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional;
        }else{

            optional.orElse( new Employee());
        }

        return optional;


    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployeeById(Long id,Employee employee){
        Optional<Employee> optional= getEmployeeById(id);

        optional.get().setName(employee.getName());
        optional.get().setSurname(employee.getSurname());

        addEmployee(optional.get());

        return optional.get();


    }




}