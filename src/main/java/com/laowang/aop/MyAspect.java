package com.laowang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Aop的通知类
 */
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.laowang.service..*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        System.out.println("前置通知");
    }

    @AfterReturning(value = "pt()",returning = "result")
    public void after(Object result){
        System.out.println("后置通知 : " + result);
    }

    @AfterThrowing(value = "pt()",throwing = "ex")
    public void exceptionAdvice(Exception ex) {
        System.out.println("异常通知 :" + ex.getMessage());
    }

    @After("pt()")
    public void finallyAdvice() {
        System.out.println("最终通知");
    }

    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        try{
            System.out.println(1);
            Object result = joinPoint.proceed();
            System.out.println(2);
        }catch(Throwable throwable){
            System.out.println(3);
        }finally {
            System.out.println(4);
        }
    }

}
