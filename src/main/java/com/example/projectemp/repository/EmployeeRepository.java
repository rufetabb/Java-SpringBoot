package com.example.projectemp.repository;

import com.example.projectemp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee,Long> {
}
