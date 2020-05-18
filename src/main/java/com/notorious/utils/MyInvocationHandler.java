package com.notorious.utils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
    //接收委托对象
    private Object object=null;

    public Object bind(Object object){
        this.object=object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法名："+method.getName());
        System.out.println("参数是："+ Arrays.toString(args));
        Object result=method.invoke(object,args);
        System.out.println("结果是"+result);
        return result;
    }
}
