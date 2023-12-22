package com.shj.services.Impl;

import com.shj.mapper.StudentMapper;
import com.shj.pojo.Student;
import com.shj.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public Integer removeStudent(Integer sid) {
        return studentMapper.delStudentBySid(sid);
    }

    @Override
    public Boolean addStudent(Student student) {
        studentMapper.addStudent(student.getName(),student.getSex(),student.getAge());
        return true;
    }

    @Override
    public List<Student> queryStudents(Student student) {
        return studentMapper.getStudents(student.getName());
    }

    @Override
    public Boolean updateStudent(Student student) {
        Integer count = studentMapper.updateStudent(
                student.getSid(),
                student.getName(),
                student.getSex(),
                student.getAge(),
                student.getScore()
        );
        return count > 0;
    }
}
