package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.TeacherService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private TeacherService teacherService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside Save Department");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @Transactional
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {

        Department department = departmentService.fetchDepartmentById(departmentId);
        teacherService.deleteTeacherByDepartment(department);
        departmentService.deleteDepartmentById(departmentId);
        return "deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public Department UpdateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.UpdateDepartmentById(departmentId, department);
    }

    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
