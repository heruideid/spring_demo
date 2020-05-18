package com.notorious.entity;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    List<Student> students;

    public Teacher(){
        System.out.println("创建Teacher对象");
    }
}


