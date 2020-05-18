package com.notorious.aop;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {
      @Before(value="execution(public int com.notorious.utils.impl.CalImpl.*(..))")
      public void before(JoinPoint joinPoint) {
            System.out.println("方法名："+joinPoint.getSignature().getName());
            System.out.println("参数是："+ Arrays.toString(joinPoint.getArgs()));
      }

      @After(value="execution(public int com.notorious.utils.impl.CalImpl.*(..))")
      public void after(JoinPoint joinPoint){
            System.out.println("方法执行完毕");
      }

      @AfterReturning(value="execution(public int com.notorious.utils.impl.CalImpl.*(..))",returning = "result")
      public void afterReturning(JoinPoint joinPoint,Object result){
            String methodName=joinPoint.getSignature().getName();
            System.out.println(methodName+"方法的结果是"+result);
      }

      @AfterThrowing(value="execution(public int com.notorious.utils.impl.CalImpl.*(..))",throwing = "excep")
      public void afterThrowing(JoinPoint joinPoint,Object excep){
            String methodName=joinPoint.getSignature().getName();
            System.out.println(methodName+"方法抛出了异常:"+excep);
      }
}
