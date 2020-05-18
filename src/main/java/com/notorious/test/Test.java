package com.notorious.test;

import com.notorious.entity.Student;
import com.notorious.entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class Test {
    public static void main(String[] args) {
        //传统方法new一个对象
//        Student student = new Student();
//        student.setId(1L);
//        student.setName("张三");
//        student.setAge(22);
//        System.out.println(student);

        //从xml中通过id获取对象
        ApplicationContext appletContext=new ClassPathXmlApplicationContext("spring.xml");
//        Student student=(Student)appletContext.getBean("student");
//        System.out.println(student);

        //通过运行时类获取对象(xml一个类只能定义一个实例,否则会抛出异常)
//        Student student=(Student)appletContext.getBean(Student.class);
//        System.out.println(student);

        //从xml中通过有参构造获取对象
//        Student student2=(Student)appletContext.getBean("student2");
//        System.out.println(student2);
//
//        Student student3=(Student)appletContext.getBean("student2");
//        System.out.println(student3);
//
//        System.out.println(student2==student3);
//
//        System.out.println((Teacher)appletContext.getBean("teacher"));
//
//        //spring对象间的继承
//        System.out.println((Student)appletContext.getBean("student3"));
        Student stu=(Student)appletContext.getBean("stu");
        Teacher teacher1=(Teacher)appletContext.getBean("teacher1");
    }
}
