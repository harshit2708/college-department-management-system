package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.entity.Teacher;
import com.example.demo.error.DepartmentNotFound;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.TeacherService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/teachers")
    public List<Teacher> fetchTeacherList(){
        List<Teacher> teachers = teacherService.fetchTeacherList();

        return teachers;
    }

    @PostMapping("/teachers")
    public Teacher saveTeacher(@Valid @RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @Transactional
    @DeleteMapping("/teachers/{id}")
    public String deleteTeacherByTeacherId(@PathVariable Long id){
        teacherService.deleteTeacherByTeacherId(id);

        return "Teacher Deleted Successfully";
    }


    @Transactional
    public String deleteTeacherByDepartment(Department department) throws DepartmentNotFound {
        teacherService.deleteTeacherByDepartment(department);

        return "Teacher Deleted Successfully";
    }

}
