package com.shj.services;

import com.shj.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryAllStudents();

    Integer removeStudent(Integer sid);

    Boolean addStudent(Student student);

    List<Student> queryStudents(Student student);

    Boolean updateStudent(Student student);
}
