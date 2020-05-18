package com.notorious.test;


import com.notorious.utils.Cal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_AOP {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-aop.xml");
        Cal proxy=(Cal) applicationContext.getBean("calImpl");
        proxy.add(1,2);
        proxy.div(1,0);
    }
}
