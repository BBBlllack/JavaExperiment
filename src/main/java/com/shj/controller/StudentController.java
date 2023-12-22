package com.shj.controller;

import com.shj.pojo.Result;
import com.shj.pojo.Student;
import com.shj.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    // 查询所有学生
    public Result<List<Student>> students(){
        return Result.success(studentService.queryAllStudents());
    }

    @PostMapping("/q")
    // 按条件查询学生
    public Result<List<Student>> queryStudents(@RequestBody Student student){
        return Result.success(studentService.queryStudents(student));
    }

    @PostMapping("/u")
    // 更新学生信息
    public Result<Boolean> updateStudent(@RequestBody Student student){
        Result<Boolean> result = new Result<>();
        log.info("update:" + student.toString());
        Boolean flag = studentService.updateStudent(student);
        result.setData(flag);
        return result;
    }

    @PostMapping
    // 新增学生
    public Result<String> addStudent(@RequestBody Student student){
        log.info("add:" + String.valueOf(student));
        Boolean flag = studentService.addStudent(student);
        return Result.success("ok");
    }

    @DeleteMapping("/{sid}")
    // 删除学生
    public Result<Integer> delStudent(@PathVariable("sid") Integer sid){
        Result<Integer> result = new Result<>();
        Integer count = studentService.removeStudent(sid);
        result.setData(count);
        return result;
    }

    @GetMapping("/now")
    // 测试方法
    public Result<String> now(){
        return Result.success(LocalDateTime.now().toString());
    }


}
