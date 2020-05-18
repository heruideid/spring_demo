package com.notorious.test;

import com.notorious.entity.Car;
import com.notorious.entity.StaticFactory;
import com.notorious.utils.Cal;
import com.notorious.utils.MyInvocationHandler;
import com.notorious.utils.impl.CalImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
//        System.out.println(StaticFactory.getCar(1L));
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-staticFactory.xml");
//        System.out.println((Car)applicationContext.getBean("car1"));
        Cal cal=new CalImpl();
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler();
        Cal cal1=(Cal)myInvocationHandler.bind(cal);
        System.out.println(cal1.add(1,1));
    }
}
