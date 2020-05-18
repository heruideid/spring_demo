package com.notorious.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Student {
    private long id;
    private String name;
    private int age;
    private Address address;

    public Student(){
        System.out.println("创建了Student对象");
    }
}
