package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> fetchTeacherList() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public void deleteTeacherByDepartment(Department department) {
        teacherRepository.deleteTeacherByDepartment(department);
    }

    @Override
    public void deleteTeacherByTeacherId(Long id) {
        teacherRepository.deleteById(id);
    }

}
