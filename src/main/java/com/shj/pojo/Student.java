package com.shj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer sid;
    private String name;
    private String sex;
    private int age;
    private Integer score;
}
