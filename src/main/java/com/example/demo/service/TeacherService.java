package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> fetchTeacherList();

    public Teacher saveTeacher(Teacher teacher);

    public void deleteTeacherById(Long teacherId);


    void deleteTeacherByDepartment(Department department);

    void deleteTeacherByTeacherId(Long id);
}
