package com.notorious.ioc;

import com.notorious.entity.Student;

public class Test {
    public static void main(String[] args) {
        //自定义ApplicationContext和ClassPathXmlApplicationContext，解析xml，利用反射构建对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("./src/main/resources/spring.xml");
        Student student=(Student)applicationContext.getBean("student");
        System.out.println(student);
    }
}
