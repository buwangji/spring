package com.laowang.aop;

/**
 * Aop的通知类
 */
public class MyAspect {


    public void before(){
        System.out.println("前置通知");
    }

    public void after(Object result){
        System.out.println("后置通知 : " + result);
    }

    public void exceptionAdvice(Exception ex) {
        System.out.println("异常通知 :" + ex.getMessage());
    }

    public void finallyAdvice() {
        System.out.println("最终通知");
    }


}
