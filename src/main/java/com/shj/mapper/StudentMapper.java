package com.shj.mapper;

import com.shj.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<Student> getAllStudents();

    @Delete("DELETE FROM student WHERE sid = #{sid}")
    Integer delStudentBySid(@Param("sid")Integer sid);

    @Insert("INSERT into student values(null,#{name},#{sex},#{age},0)")
    void addStudent(@Param("name") String name, @Param("sex") String sex, @Param("age") Integer age);

    @Select("SELECT * FROM student WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Student> getStudents(@Param("name") String name);

    @Update("UPDATE student SET name = #{name}, sex = #{sex}, age = #{age}, score = #{score} WHERE sid = #{sid}")
    Integer updateStudent(@Param("sid") Integer sid, @Param("name") String name,
                          @Param("sex") String sex, @Param("age") Integer age, @Param("score") Integer score);

}
