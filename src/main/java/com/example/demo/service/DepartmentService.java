package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFound;

    public void deleteDepartmentById(Long departmentId);

    public Department UpdateDepartmentById(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

}
